package SS11;

interface IMixable {
    void mix();
}

abstract class Drink {
    protected String id;
    protected String name;
    protected double price;

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract double calculatePrice();
    public void displayInfo() {
        System.out.printf("Mã: %s | Tên: %s | Giá gốc: %.0f VNĐ\n", id, name, price);
    }
}

class Coffee extends Drink {
    private boolean hasMilk;

    public Coffee(String id, String name, double price, boolean hasMilk) {
        super(id, name, price);
        this.hasMilk = hasMilk;
    }

    @Override
    public double calculatePrice() {
        return hasMilk ? (price + 5000) : price;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Loại: " + (hasMilk ? "Có sữa" : "Đen đá"));
    }
}

class FruitJuice extends Drink implements IMixable {
    private int discountPercent;

    public FruitJuice(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculatePrice() {
        return price - (price * discountPercent / 100.0);
    }

    @Override
    public void mix() {
        System.out.println("Đang ép trái cây tươi...");
    }
}

public class HCM_KS24_CNTT1_IT203A_TranMinhDuc_SS11 {
    public static void main(String[] args) {
        System.out.println("===== HỆ THỐNG QUẢN LÝ COFFEE SHOP =====\n");

        Drink[] drinks = new Drink[3];

        drinks[0] = new Coffee("CF01", "Bạc sỉu", 30000, true);
        drinks[1] = new FruitJuice("FJ01", "Nước cam", 40000, 10);
        for (int i = 0; i < drinks.length; i++) {
            Drink currentDrink = drinks[i];

            if (currentDrink != null) {
                System.out.println("--- Hóa đơn #" + (i + 1) + " ---");

                currentDrink.displayInfo();

                System.out.println("Thành tiền (Thực thu): " + currentDrink.calculatePrice() + " VNĐ");

                if (currentDrink instanceof IMixable) {
                    IMixable mixableDrink = (IMixable) currentDrink;
                    mixableDrink.mix(); 
                }

                System.out.println();
            }
        }
    }
}