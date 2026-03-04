package BTTH;

import java.util.Scanner;

// Lớp Student - Định nghĩa đối tượng sinh viên [cite: 54, 73]
class Student {
    private String id;
    private String fullName;
    private int age;
    private String gender;
    private double mathScore;
    private double physicsScore;
    private double chemistryScore;
    private double averageScore;
    private String rank;

    public Student(String id, String fullName, int age, String gender, double mathScore, double physicsScore, double chemistryScore) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.mathScore = mathScore;
        this.physicsScore = physicsScore;
        this.chemistryScore = chemistryScore;
        calculateResult(); // Tự động tính điểm và xếp loại khi khởi tạo [cite: 101]
    }

    public void calculateResult() {
        this.averageScore = (mathScore + physicsScore + chemistryScore) / 3.0; // [cite: 116]
        // Quy tắc xếp loại theo yêu cầu SRS [cite: 117, 118, 119, 120, 121]
        if (averageScore >= 8.0 && mathScore >= 6.5 && physicsScore >= 6.5 && chemistryScore >= 6.5) {
            this.rank = "Giỏi";
        } else if (averageScore >= 6.5 && mathScore >= 5.0 && physicsScore >= 5.0 && chemistryScore >= 5.0) {
            this.rank = "Khá";
        } else if (averageScore >= 5.0 && mathScore >= 3.5 && physicsScore >= 3.5 && chemistryScore >= 3.5) {
            this.rank = "Trung bình";
        } else {
            this.rank = "Yếu";
        }
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public double getAverageScore() { return averageScore; }

    public void display() {
        // Hiển thị định dạng bảng [cite: 21, 103, 190]
        System.out.printf("| %-10s | %-18s | %-4d | %-6s | %-6.2f | %-10s |\n",
                id, fullName, age, gender, averageScore, rank);
    }
}

// Lớp chính quản lý hệ thống [cite: 74, 75]
public class MPSS8 {
    private static Student[] students = new Student[100]; // Mảng lưu trữ [cite: 11, 58]
    private static int currentCount = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            // Menu chuẩn SRS [cite: 78, 80, 89]
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Hiển thị tất cả sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Sắp xếp theo ĐTB (Giảm dần)");
            System.out.println("5. Xóa sinh viên theo mã");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng (1-9): ");

            try {
                choice = Integer.parseInt(sc.nextLine()); // Xử lý ngoại lệ nhập liệu [cite: 140]
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1: addStudent(); break;
                case 2: showAll(); break;
                case 3: searchByName(); break;
                case 4: sortByGPA(); break;
                case 5: deleteStudent(); break;
                case 9: System.out.println("Tạm biệt Đức!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9); // Vòng lặp menu [cite: 64, 95]
    }

    private static void addStudent() {
        if (currentCount >= students.length) { // Kiểm tra mảng đầy [cite: 136, 195]
            System.out.println("Danh sách đã đầy!");
            return;
        }
        System.out.print("Mã SV: "); String id = sc.nextLine();
        // Kiểm tra mã sinh viên không trùng [cite: 99]
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                System.out.println("Lỗi: Mã SV đã tồn tại!");
                return;
            }
        }
        System.out.print("Họ tên: "); String name = sc.nextLine();
        System.out.print("Tuổi (18-30): "); int age = Integer.parseInt(sc.nextLine());
        System.out.print("Giới tính: "); String gender = sc.nextLine();
        System.out.print("Điểm Toán: "); double m = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm Lý: "); double p = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm Hóa: "); double c = Double.parseDouble(sc.nextLine());

        // Validate dữ liệu [cite: 100, 139]
        if (age < 18 || age > 30 || m < 0 || m > 10 || p < 0 || p > 10 || c < 0 || c > 10) {
            System.out.println("Dữ liệu không hợp lệ!");
            return;
        }

        students[currentCount++] = new Student(id, name, age, gender, m, p, c); // Thêm vào mảng [cite: 16]
        System.out.println("Thêm thành công!");
    }

    private static void showAll() {
        if (currentCount == 0) {
            System.out.println("Chưa có sinh viên nào!");
            return;
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-18s | %-4s | %-6s | %-6s | %-10s |\n", "Mã SV", "Họ Tên", "Tuổi", "G.Tính", "ĐTB", "Xếp Loại");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < currentCount; i++) {
            students[i].display(); // Duyệt mảng hiển thị [cite: 20, 61]
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    private static void searchByName() {
        System.out.print("Nhập tên cần tìm: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < currentCount; i++) {
            // Tìm kiếm mờ theo tên [cite: 24, 107]
            if (students[i].getFullName().toLowerCase().contains(name.toLowerCase())) {
                students[i].display();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy!");
    }

    private static void sortByGPA() {
        // Sắp xếp Bubble Sort [cite: 68, 123, 141]
        for (int i = 0; i < currentCount - 1; i++) {
            for (int j = 0; j < currentCount - i - 1; j++) {
                if (students[j].getAverageScore() < students[j+1].getAverageScore()) {
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp xong!");
        showAll();
    }

    private static void deleteStudent() {
        System.out.print("Nhập mã SV muốn xóa: ");
        String id = sc.nextLine();
        int index = -1;
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.print("Xác nhận xóa (Y/N)? "); // Xác nhận trước khi xóa [cite: 113]
            if (sc.nextLine().equalsIgnoreCase("Y")) {
                // Xóa bằng cách dịch chuyển mảng [cite: 33, 114, 197]
                for (int i = index; i < currentCount - 1; i++) {
                    students[i] = students[i+1];
                }
                students[--currentCount] = null;
                System.out.println("Xóa thành công!");
            }
        } else {
            System.out.println("Không tìm thấy mã SV!");
        }
    }
}