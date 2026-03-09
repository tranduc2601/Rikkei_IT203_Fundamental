package SS12;
public class Mini_Projects {
    interface IMixable {
        public void mix();
    }

    abstract class Drink {
        protected int id;
        protected String name;
        protected double price;

        public Drink(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public abstract double calculatePrice();

        public void display() {
            System.out.println("Ma: " + id);
            System.out.println("Ten: " + name);
            System.out.println("Gia goc: " + price);
        }
    }

    public class Coffee extends Drink {
        boolean hasMilk;

        public Coffee(int id, String name, double price, boolean hasMilk) {
            super(id, name, price);
            this.hasMilk = hasMilk;
        }

        @Override
        public double calculatePrice() {
            if (hasMilk) {
                return price + 5000;
            }
            return price;
        }

        @Override
        public void display() {
            super.display();
            if (hasMilk) {
                System.out.println("Có Sữa!");
            }
            else {
                System.out.println("Đen Đá!");
            }
        }
    }

    public class FruitJuice extends Drink implements IMixable {
        int discountPercent;

        public FruitJuice(int id, String name, double price, int discountPercent) {
            super(id, name, price);
            this.discountPercent = discountPercent;
        }

        @Override
        public double calculatePrice() {
            return price - (price * discountPercent / 100.0);
        }

        @Override
        public void mix() {
            System.out.println("Đang Ép Trái Cây Tươi!");
        }
    }

    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];

        Mini_Projects mp = new Mini_Projects();

        drinks[0] = mp.new Coffee(1, "Bạc Sỉu", 20000, true);
        drinks[1] = mp.new FruitJuice(2, "Nước Cam", 15000, 10);
        drinks[2] = null;

        for (Drink d : drinks) {
            if (d != null) {
                d.display();
                System.out.println("Thành Tiền: " + d.calculatePrice());
            }
            else {
                if (d instanceof IMixable iMixable) {
                    iMixable.mix();
                }
            }
        }
    }
}