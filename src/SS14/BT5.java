package SS14;

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

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    @Override
    public String toString() {
        return id + " - " + fullName + " - " + age + " - " + diagnosis;
    }
}

public class BT5 {
    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Dữ liệu mẫu test chức năng sắp xếp
        patients.add(new Patient("BN01", "An", 65, "Cúm"));
        patients.add(new Patient("BN02", "Bình", 70, "Tiểu đường"));
        patients.add(new Patient("BN03", "Anh", 65, "Cao huyết áp"));

        while (true) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ HỒ SƠ BỆNH ÁN ===");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addPatient(); break;
                case 2: updateDiagnosis(); break;
                case 3: dischargePatient(); break;
                case 4: sortPatients(); break;
                case 5: displayPatients(); break;
                case 6: return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addPatient() {
        System.out.println("\n--- TIẾP NHẬN BỆNH NHÂN ---");
        System.out.print("ID: ");
        String id = scanner.nextLine();

        if (findPatientById(id) != null) {
            System.out.println("Lỗi: ID bệnh nhân đã tồn tại!");
            return;
        }

        System.out.print("Họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Chẩn đoán: ");
        String diagnosis = scanner.nextLine();

        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println("Thêm bệnh nhân thành công");
    }

    private static void updateDiagnosis() {
        System.out.print("\nNhập ID bệnh nhân cần cập nhật: ");
        String id = scanner.nextLine();
        Patient p = findPatientById(id);

        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân");
        } else {
            System.out.print("Nhập chẩn đoán mới: ");
            p.setDiagnosis(scanner.nextLine());
            System.out.println("Cập nhật chẩn đoán thành công");
        }
    }

    private static void dischargePatient() {
        System.out.print("\nNhập ID bệnh nhân xuất viện: ");
        String id = scanner.nextLine();
        Patient p = findPatientById(id);

        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân");
        } else {
            patients.remove(p);
            System.out.println("Xuất viện thành công");
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
        System.out.println("Sau khi sắp xếp:");
        displayPatients();
    }

    private static void displayPatients() {
        for (Patient p : patients) {
            System.out.println(p.toString());
        }
    }

    private static Patient findPatientById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }
}