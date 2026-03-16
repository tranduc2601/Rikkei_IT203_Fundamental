package SS16;
// imprt thu vien
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;


//1a) Interface IRepository<T>
interface IRepository<T> {
    boolean add(T item);

    boolean removeById(String id);

    T findById(String id);

    List<T> findAll();
}

//1b) Abstract Class Product
abstract class Product {
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculateFinalPrice();

    public void displayInfo() {
        System.out.printf("MaSV: %s, TenSV: %s, Gia: %,.0f VND", id, name, price);
    }
}

//2a) Class ElectronicProduct (Kế thừa Product)
class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        if (warrantyMonths > 12) {
            return price + 1000000;
        }
        return price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(", ThoiHanBaoHanh: %d Thang", warrantyMonths);
    }
}

//2b) Class FoodProduct (Kế thừa Product)
class FoodProduct extends Product {
    private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateFinalPrice() {
        return price - (price * discountPercent / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(", GiamGia: %d%%", discountPercent);
    }
}

//3. Xây dựng lớp ProductRepository
class ProductRepository implements IRepository<Product> {
    private ArrayList<Product> list = new ArrayList<>();
    private HashMap<String, Product> map = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || item.getId() == null || map.containsKey(item.getId())) {
            return false;
        }
        list.add(item);
        map.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null || !map.containsKey(id)) {
            return false;
        }
        Product removedProduct = map.remove(id);
        list.remove(removedProduct);
        return true;
    }

    @Override
    public Product findById(String id) {
        if (id == null) return null;
        return map.get(id); // O(1) time complexity
    }

    @Override
    public List<Product> findAll() {
        // Trả về một bản sao để bảo vệ danh sách gốc
        return new ArrayList<>(list);
    }

    public Map<String, Integer> countByType() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Electronic", 0);
        stats.put("Food", 0);

        for (Product p : list) {
            if (p instanceof ElectronicProduct) {
                stats.put("Electronic", stats.get("Electronic") + 1);
            } else if (p instanceof FoodProduct) {
                stats.put("Food", stats.get("Food") + 1);
            }
        }
        return stats;
    }
}

//4
public class BTTH {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();

        repo.add(new ElectronicProduct("E01", "Laptop Dell XPS", 25000000, 24));
        repo.add(new ElectronicProduct("E02", "Chuột Logitech", 500000, 12));
        repo.add(new FoodProduct("F01", "Bánh Trung Thu", 150000, 10));
        repo.add(new FoodProduct("F02", "Sữa Tươi Vinamilk", 35000, 5));


        System.out.println("=== DANH SÁCH SẢN PHẨM ===");
        displayProductList(repo.findAll());

        System.out.println("=== TÌM SẢN PHẨM THEO ID (E01) ===");
        Product found = repo.findById("E01");
        if (found != null) {
            found.displayInfo();
            System.out.printf("Thành tiền (Thực tế): %,.0f VNĐ\n\n", found.calculateFinalPrice());
        } else {
            System.out.println("Không tìm thấy sản phẩm!\n");
        }

        System.out.println("=== DANH SÁCH SAU KHI SẮP XẾP (GIÁ GỐC TĂNG DẦN) ===");
        List<Product> sortedList = repo.findAll();
        Collections.sort(sortedList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
        displayProductList(sortedList);

        System.out.println("=== THỐNG KÊ SỐ LƯỢNG SẢN PHẨM ===");
        Map<String, Integer> statistics = repo.countByType();
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println("Loại " + entry.getKey() + ": " + entry.getValue() + " sản phẩm");
        }
    }

    private static void displayProductList(List<Product> list) {
        for (Product p : list) {
            if (p != null) {
                p.displayInfo();
                System.out.printf("=> Thành tiền: %,.0f VNĐ\n", p.calculateFinalPrice());
            }
        }
        System.out.println();
    }
}
