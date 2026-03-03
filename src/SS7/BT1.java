package SS7;

public class BT1 {

    private String studentId;
    private String studentName;

    public static int totalStudent = 0;

    public BT1(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        totalStudent++;
    }

    public void displayInfo() {
        System.out.println("Mã SV: " + studentId + " | Tên: " + studentName);
    }

    public static void displayTotalStudents() {
        System.out.println("-> Tổng số sinh viên hiện tại trong hệ thống: " + totalStudent);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== THỐNG KÊ SINH VIÊN ===");
        BT1.displayTotalStudents();

        BT1 sv1 = new BT1("B24DCCN123", "Trần Minh Đức");
        sv1.displayInfo();
        BT1.displayTotalStudents();

        BT1 sv2 = new BT1("B24DCCN456", "Nguyễn Văn A");
        sv2.displayInfo();
        BT1.displayTotalStudents();

        BT1 sv3 = new BT1("B24DCCN789", "Lê Thị B");
        sv3.displayInfo();
        BT1.displayTotalStudents();
    }
}