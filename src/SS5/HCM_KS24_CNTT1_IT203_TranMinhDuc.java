package SS5;

import java.util.Scanner;

public class HCM_KS24_CNTT1_IT203_TranMinhDuc {

    static String[] studentIds = new String[100];
    static int studentCount = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] SDMG) {
        int choice = 0;

        do {
            System.out.println("\n========== HỆ THỐNG QUẢN LÝ MSSV ==========");
            System.out.println("1. Hiển thị danh sách MSSV");
            System.out.println("2. Thêm mới MSSV");
            System.out.println("3. Cập nhật MSSV theo Index");
            System.out.println("4. Xóa MSSV");
            System.out.println("5. Tìm kiếm MSSV");
            System.out.println("6. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (1-6): ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    System.out.println("Đã thoát chương trình. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (choice != 6);
    }

    public static void displayStudents() {
        System.out.println("\n--- DANH SÁCH MSSV HIỆN CÓ ---");
        if (studentCount == 0) {
            System.out.println("Danh sách đang trống!");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println("STT " + (i + 1) + " (Index " + i + "): " + studentIds[i]);
        }
    }

    public static void addStudent() {
        System.out.println("\n--- THÊM MỚI MSSV ---");
        if (studentCount >= 100) {
            System.out.println("Lỗi: Danh sách đã đạt tối đa 100 sinh viên!");
            return;
        }

        String newId = "";
        while (true) {
            System.out.print("Nhập MSSV (Định dạng Bxxxxxxx - VD: B2101234): ");
            newId = scanner.nextLine().trim();

            if (newId.matches("^B\\d{7}$")) {
                break;
            } else {
                System.out.println("Lỗi: MSSV không đúng định dạng. Vui lòng nhập lại!");
            }
        }

        studentIds[studentCount] = newId;
        studentCount++;
        System.out.println("Thêm thành công MSSV: " + newId);
    }

    public static void updateStudent() {
        System.out.println("\n--- CẬP NHẬT MSSV ---");
        if (studentCount == 0) {
            System.out.println("Danh sách trống, không có dữ liệu để cập nhật!");
            return;
        }

        System.out.print("Nhập vị trí (Index từ 0 đến " + (studentCount - 1) + ") cần sửa: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= studentCount) {
            System.out.println("Lỗi: Vị trí Index không hợp lệ!");
            return;
        }

        System.out.println("MSSV hiện tại ở vị trí " + index + " là: " + studentIds[index]);

        String updatedId = "";
        while (true) {
            System.out.print("Nhập MSSV mới (Định dạng Bxxxxxxx): ");
            updatedId = scanner.nextLine().trim();

            if (updatedId.matches("^B\\d{7}$")) {
                break;
            } else {
                System.out.println("Lỗi: MSSV không đúng định dạng. Vui lòng nhập lại!");
            }
        }

        studentIds[index] = updatedId;
        System.out.println("Đã cập nhật thành công!");
    }

    public static void deleteStudent() {
        System.out.println("\n--- XÓA MSSV ---");
        if (studentCount == 0) {
            System.out.println("Danh sách trống, không có dữ liệu để xóa!");
            return;
        }

        System.out.print("Nhập chính xác MSSV cần xóa: ");
        String targetId = scanner.nextLine().trim();
        int indexFound = -1;

        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i].equalsIgnoreCase(targetId)) {
                indexFound = i;
                break;
            }
        }

        if (indexFound != -1) {
            for (int i = indexFound; i < studentCount - 1; i++) {
                studentIds[i] = studentIds[i + 1];
            }
            studentCount--;
            System.out.println("Đã xóa thành công MSSV: " + targetId);
        } else {
            System.out.println("Lỗi: Không tìm thấy MSSV '" + targetId + "' trong hệ thống!");
        }
    }

    public static void searchStudent() {
        System.out.println("\n--- TÌM KIẾM MSSV ---");
        if (studentCount == 0) {
            System.out.println("Danh sách đang trống!");
            return;
        }

        System.out.print("Nhập chuỗi ký tự cần tìm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean isFound = false;

        System.out.println("Kết quả tìm kiếm cho '" + keyword + "':");
        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i].toLowerCase().contains(keyword)) {
                System.out.println("- " + studentIds[i] + " (Index: " + i + ")");
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("Không có MSSV nào khớp với từ khóa tìm kiếm.");
        }
    }
}