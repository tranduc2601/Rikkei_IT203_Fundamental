package SS14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Medicine {
    private String drugId;
    private String drugName;
    private double unitPrice;
    private int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDrugId() { return drugId; }
    public String getDrugName() { return drugName; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }
}

public class BT6 {
    static List<Medicine> prescription = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== ỨNG DỤNG KÊ ĐƠN THUỐC ĐIỆN TỬ ===");
            System.out.println("1. Thêm thuốc vào đơn");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc khỏi đơn");
            System.out.println("4. In hóa đơn thanh toán");
            System.out.println("5. Tìm thuốc giá rẻ (< 50.000 VNĐ)");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addMedicine(); break;
                case 2: updateQuantity(); break;
                case 3: removeMedicine(); break;
                case 4: printInvoice(); break;
                case 5: findCheapMedicine(); break;
                case 6: return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addMedicine() {
        System.out.print("\nNhập mã thuốc: ");
        String id = scanner.nextLine();

        Medicine existing = findMedicineById(id);

        System.out.print("Nhập số lượng: ");
        int qty = Integer.parseInt(scanner.nextLine());

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + qty);
            System.out.println("Thêm thuốc thành công (Đã cộng dồn số lượng)");
        } else {
            System.out.print("Nhập tên thuốc: ");
            String name = scanner.nextLine();
            System.out.print("Nhập đơn giá: ");
            double price = Double.parseDouble(scanner.nextLine());

            prescription.add(new Medicine(id, name, price, qty));
            System.out.println("Thêm thuốc thành công");
        }
    }

    private static void updateQuantity() {
        System.out.print("\nNhập mã thuốc cần điều chỉnh: ");
        String id = scanner.nextLine();
        Medicine m = findMedicineById(id);

        if (m == null) {
            System.out.println("Không tìm thấy thuốc");
        } else {
            System.out.print("Nhập số lượng mới: ");
            int newQty = Integer.parseInt(scanner.nextLine());

            if (newQty <= 0) {
                prescription.remove(m);
                System.out.println("Đã xóa thuốc khỏi đơn");
            } else {
                m.setQuantity(newQty);
                System.out.println("Điều chỉnh số lượng thành công");
            }
        }
    }

    private static void removeMedicine() {
        System.out.print("\nNhập mã thuốc cần xóa: ");
        String id = scanner.nextLine();
        Medicine m = findMedicineById(id);

        if (m == null) {
            System.out.println("Không tìm thấy thuốc");
        } else {
            prescription.remove(m);
            System.out.println("Xóa thuốc thành công");
        }
    }

    private static void printInvoice() {
        System.out.println("\n--- HÓA ĐƠN THANH TOÁN ---");
        if (prescription.isEmpty()) {
            System.out.println("Đơn thuốc trống!");
            return;
        }

        System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "Mã Thuốc", "Tên Thuốc", "Số Lượng", "Đơn Giá", "Thành Tiền");
        double grandTotal = 0;

        for (Medicine m : prescription) {
            double total = m.getTotalPrice();
            grandTotal += total;
            System.out.printf("%-10s %-20s %-10d %-15.0f %-15.0f\n",
                    m.getDrugId(), m.getDrugName(), m.getQuantity(), m.getUnitPrice(), total);
        }

        System.out.println("\nTổng tiền đơn thuốc: " + grandTotal + " VNĐ");
        prescription.clear();
        System.out.println("=> Đã in hóa đơn và làm trống đơn thuốc.");
    }

    private static void findCheapMedicine() {
        System.out.println("\n--- THUỐC GIÁ RẺ (< 50.000 VNĐ) ---");
        boolean found = false;

        for (Medicine m : prescription) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m.getDrugId() + " - " + m.getDrugName() + " (Giá: " + m.getUnitPrice() + ")");
                found = true;
            }
        }

        if (!found) System.out.println("Không có thuốc nào giá dưới 50.000 VNĐ");
    }

    private static Medicine findMedicineById(String id) {
        for (Medicine m : prescription) {
            if (m.getDrugId().equalsIgnoreCase(id)) return m;
        }
        return null;
    }
}