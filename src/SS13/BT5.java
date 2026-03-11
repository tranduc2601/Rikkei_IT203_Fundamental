package SS13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Patient {
    private String id;
    private String fullName;
    private int age;
    private String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    @Override
    public String toString() {
        return id + " - " + fullName + " - " + age + " tuổi - " + diagnosis;
    }
}

public class BT5 {
    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Dữ liệu mồi (Mock data) để test chức năng sắp xếp nhanh hơn
        patients.add(new Patient("BN01", "An", 65, "Cúm"));
        patients.add(new Patient("BN02", "Bình", 70, "Tiểu đường"));
        patients.add(new Patient("BN03", "Anh", 65, "Cao huyết áp"));

        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ HỒ SƠ BỆNH ÁN ===");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách (Tuổi giảm dần -> Tên A-Z)");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng (1-6): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addPatient(); break;
                case 2: updateDiagnosis(); break;
                case 3: dischargePatient(); break;
                case 4: sortPatients(); break;
                case 5: displayPatients(); break;
                case 6:
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }

    private static void addPatient() {
        System.out.println("\n--- TIẾP NHẬN BỆNH NHÂN ---");
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();

        if (findPatientById(id) != null) {
            System.out.println("Lỗi: ID bệnh nhân đã tồn tại!");
            return;
        }

        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = scanner.nextLine();

        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println("=> Thêm bệnh nhân thành công!");
    }

    private static void updateDiagnosis() {
        System.out.println("\n--- CẬP NHẬT CHẨN ĐOÁN ---");
        System.out.print("Nhập ID bệnh nhân cần cập nhật: ");
        String id = scanner.nextLine();

        Patient p = findPatientById(id);
        if (p == null) {
            System.out.println("=> Lỗi: Không tìm thấy bệnh nhân có ID = " + id);
        } else {
            System.out.print("Nhập chẩn đoán mới: ");
            String newDiagnosis = scanner.nextLine();
            p.setDiagnosis(newDiagnosis);
            System.out.println("=> Cập nhật chẩn đoán thành công!");
        }
    }

    private static void dischargePatient() {
        System.out.println("\n--- XUẤT VIỆN ---");
        System.out.print("Nhập ID bệnh nhân xuất viện: ");
        String id = scanner.nextLine();

        Patient p = findPatientById(id);
        if (p == null) {
            System.out.println("=> Lỗi: Không tìm thấy bệnh nhân có ID = " + id);
        } else {
            patients.remove(p);
            System.out.println("=> Đã làm thủ tục xuất viện cho BN: " + p.getFullName());
        }
    }

    private static void sortPatients() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                if (p1.getAge() != p2.getAge()) {
                    return Integer.compare(p2.getAge(), p1.getAge());
                }
                return p1.getFullName().compareTo(p2.getFullName());
            }
        });
        System.out.println("\n=> Đã sắp xếp danh sách thành công!");
        displayPatients();
    }

    private static void displayPatients() {
        System.out.println("\n--- DANH SÁCH BỆNH NHÂN ---");
        if (patients.isEmpty()) {
            System.out.println("Chưa có bệnh nhân nào.");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p.toString());
        }
    }

    private static Patient findPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}