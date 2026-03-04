package SS8;

import java.util.Scanner;

class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String sex;
    private double mark;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, String sex, double mark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.mark = mark;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public double getMark() { return mark; }
    public void setMark(double mark) { this.mark = mark; }

    public void displayData() {
        System.out.printf("ID: %-8s | Tên: %-15s | Tuổi: %-3d | Giới tính: %-5s | Điểm: %.1f\n",
                studentId, studentName, age, sex, mark);
    }
}

public class HCM_KS24_CNTT1_IT203_TranMinhDuc_SS8 {
    private static Student[] students = new Student[100];
    private static int currentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n======= Quatrn lý sinh viên =======");
            System.out.println("1. Hiển thị danh sách tất cả sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên theo ID");
            System.out.println("4. Tìm kiếm sinh viên theo tên");
            System.out.println("5. Xóa sinh viên theo ID");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn (1-6): ");

            System.out.print("Chọn chức năng (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private static void displayAllStudents() {
        if (currentCount == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (int i = 0; i < currentCount; i++) {
            students[i].displayData();
        }
    }

    private static void addStudent() {
        if (currentCount >= 100) {
            System.out.println("Danh sách đã đầy!");
            return;
        }
        System.out.print("Mã SV: "); String id = scanner.nextLine();
        System.out.print("Tên SV: "); String name = scanner.nextLine();
        System.out.print("Tuổi: "); int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Giới tính: "); String sex = scanner.nextLine();
        System.out.print("Điểm: "); double mark = Double.parseDouble(scanner.nextLine());

        students[currentCount++] = new Student(id, name, age, sex, mark);
        System.out.println("Thêm thành công!");
    }

    private static void updateStudent() {
        System.out.print("Nhập ID cần sửa: ");
        String id = scanner.nextLine();
        int index = findIndex(id);

        if (index != -1) {
            System.out.print("Tên mới: "); students[index].setStudentName(scanner.nextLine());
            System.out.print("Tuổi mới: "); students[index].setAge(Integer.parseInt(scanner.nextLine()));
            System.out.print("Giới tính mới: "); students[index].setSex(scanner.nextLine());
            System.out.print("Điểm mới: "); students[index].setMark(Double.parseDouble(scanner.nextLine()));
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy ID!");
        }
    }

    private static void searchByName() {
        System.out.print("Nhập tên tìm kiếm: ");
        String search = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getStudentName().toLowerCase().contains(search.toLowerCase())) {
                students[i].displayData();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy!");
    }

    private static void deleteStudent() {
        System.out.print("Nhập ID cần xóa: ");
        String id = scanner.nextLine();
        int index = findIndex(id);

        if (index != -1) {
            for (int i = index; i < currentCount - 1; i++) {
                students[i] = students[i + 1];
            }
            students[--currentCount] = null;
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy ID!");
        }
    }

    private static int findIndex(String id) {
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getStudentId().equalsIgnoreCase(id)) return i;
        }
        return -1;
    }
}