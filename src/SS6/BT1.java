package SS6;

public class BT1 {

    String studentId;
    String fullName;
    int birthYear;
    double gpa;

    public BT1(String studentId, String fullName, int birthYear, double gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.gpa = gpa;
    }

    public void displayInfo() {
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Họ tên: " + fullName);
        System.out.println("Năm sinh: " + birthYear);
        System.out.println("Điểm trung bình: " + gpa);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        BT1 student1 = new BT1 ("SV01", "Nguyen Van A", 2005, 8.5);
        BT1 student2 = new BT1 ("SV02", "Le Thi B", 2006, 7.2);

        student1.displayInfo();
        student2.displayInfo();
    }
}