package SS7;

class ClassRoom {

    private String studentName;
    public static int classFund = 0;

    public ClassRoom(String studentName) {
        this.studentName = studentName;
    }

    public void contribute(int amount) {
        classFund += amount;
        System.out.println(studentName + " vừa đóng " + amount + " VNĐ vào quỹ lớp.");
    }

    public static void showFund() {
        System.out.println("-> Tổng quỹ lớp hiện tại: " + classFund + " VNĐ");
        System.out.println("-------------------------");
    }
}

public class BT4 {

    public static void main(String[] args) {
        System.out.println("=== QUẢN LÝ QUỸ LỚP ===");
        ClassRoom.showFund();

        ClassRoom sv1 = new ClassRoom("Trần Minh Đức");
        ClassRoom sv2 = new ClassRoom("Nguyễn Văn A");
        ClassRoom sv3 = new ClassRoom("Lê Thị B");

        sv1.contribute(900000000);
        ClassRoom.showFund();

        sv2.contribute(100000);
        ClassRoom.showFund();

        sv3.contribute(50000);
        ClassRoom.showFund();
    }
}