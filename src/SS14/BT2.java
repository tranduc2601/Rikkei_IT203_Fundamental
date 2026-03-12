package SS14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        Map<String, String> danhMucThuoc = new HashMap<>();
        danhMucThuoc.put("T01", "Paracetamol");
        danhMucThuoc.put("T02", "Ibuprofen");
        danhMucThuoc.put("T03", "Aspirin");
        danhMucThuoc.put("T04", "Amoxicillin");
        danhMucThuoc.put("T05", "Vitamin C");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã thuốc cần tra cứu: ");
        String maThuoc = scanner.nextLine();

        if (danhMucThuoc.containsKey(maThuoc)) {
            System.out.println("Tên thuốc: " + danhMucThuoc.get(maThuoc));
        } else {
            System.out.println("Thuốc không tồn tại.");
        }
    }
}