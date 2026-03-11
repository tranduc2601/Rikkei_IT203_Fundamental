package SS13;

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
            System.out.print("Chọn chức năng (1-6): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addMedicine(); break;
                case 2: updateQuantity(); break;
                case 3: removeMedicine(); break;
                case 4: printInvoice(); break;
                case 5: findCheapMedicine(); break;
                case 6:
                    System.out.println("Đã thoát ứng dụng. Chúc bác sĩ một ngày làm việc hiệu quả!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addMedicine() {
        System.out.println("\n--- THÊM THUỐC VÀO ĐƠN ---");
        System.out.print("Nhập mã thuốc: ");
        String id = scanner.nextLine();

        System.out.print("Nhập số lượng: ");
        int qty = Integer.parseInt(scanner.nextLine());

        Medicine existingMedicine = findMedicineById(id);

        if (existingMedicine != null) {
            int newQty = existingMedicine.getQuantity() + qty;
            existingMedicine.setQuantity(newQty);
            System.out.println("=> Đã cộng dồn số lượng. Tổng số lượng hiện tại: " + newQty);
        } else {
            System.out.print("Nhập tên thuốc: ");
            String name = scanner.nextLine();

            System.out.print("Nhập đơn giá: ");
            double price = Double.parseDouble(scanner.nextLine());

            prescription.add(new Medicine(id, name, price, qty));
            System.out.println("=> Thêm thuốc thành công!");
        }
    }

    private static void updateQuantity() {
        System.out.println("\n--- ĐIỀU CHỈNH SỐ LƯỢNG ---");
        System.out.print("Nhập mã thuốc cần điều chỉnh: ");
        String id = scanner.nextLine();

        Medicine m = findMedicineById(id);
        if (m == null) {
            System.out.println("=> Không tìm thấy thuốc trong đơn!");
            return;
        }

        System.out.print("Nhập số lượng mới: ");
        int newQty = Integer.parseInt(scanner.nextLine());

        if (newQty <= 0) {
            prescription.remove(m);
            System.out.println("=> Đã xóa thuốc khỏi đơn vì số lượng bằng 0.");
        } else {
            m.setQuantity(newQty);
            System.out.println("=> Điều chỉnh số lượng thành công!");
        }
    }

    private static void removeMedicine() {
        System.out.println("\n--- XÓA THUỐC ---");
        System.out.print("Nhập mã thuốc cần xóa: ");
        String id = scanner.nextLine();

        Medicine m = findMedicineById(id);
        if (m == null) {
            System.out.println("=> Không tìm thấy thuốc trong đơn!");
        } else {
            prescription.remove(m);
            System.out.println("=> Xóa thuốc thành công!");
        }
    }

    private static void printInvoice() {
        System.out.println("\n================= HÓA ĐƠN THANH TOÁN =================");
        if (prescription.isEmpty()) {
            System.out.println("Đơn thuốc hiện đang trống!");
            System.out.println("======================================================");
            return;
        }

        System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "Mã Thuốc", "Tên Thuốc", "Số Lượng", "Đơn Giá", "Thành Tiền");
        System.out.println("----------------------------------------------------------------------");

        double grandTotal = 0;
        for (Medicine m : prescription) {
            double total = m.getTotalPrice();
            grandTotal += total;

            System.out.printf("%-10s %-20s %-10d %-15.0f %-15.0f\n",
                    m.getDrugId(), m.getDrugName(), m.getQuantity(), m.getUnitPrice(), total);
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.printf("TỔNG TIỀN THANH TOÁN: %.0f VNĐ\n", grandTotal);
        System.out.println("======================================================");
        prescription.clear();
        System.out.println("=> Đã lưu hóa đơn. Đơn thuốc đã được làm trống.");
    }

    private static void findCheapMedicine() {
        System.out.println("\n--- CÁC THUỐC CÓ ĐƠN GIÁ < 50.000 VNĐ ---");
        boolean found = false;

        for (Medicine m : prescription) {
            if (m.getUnitPrice() < 50000) {
                System.out.println("- " + m.getDrugName() + " (Giá: " + m.getUnitPrice() + " VNĐ)");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có thuốc nào giá dưới 50.000 VNĐ trong đơn.");
        }
    }

    private static Medicine findMedicineById(String id) {
        for (Medicine m : prescription) {
            if (m.getDrugId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }
}