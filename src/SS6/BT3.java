package SS6;

public class BT3 {

    private String productId;
    private String productName;
    private double price;

    public BT3(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        if (price > 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Lỗi: Giá bán không hợp lệ! Vui lòng nhập giá lớn hơn 0.");
        }
    }

    public void displayInfo() {
        System.out.println("Mã SP: " + productId);
        System.out.println("Tên SP: " + productName);
        System.out.println("Giá bán: " + price + " VNĐ");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        BT3 product = new BT3("KB01", "Bàn phím Aula S75PRO", 1200000);

        product.displayInfo();

        product.setPrice(-500000);

        product.displayInfo();
    }
}