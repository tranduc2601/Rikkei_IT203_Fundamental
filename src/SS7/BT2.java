package SS7;

class StudentBT2 {
    String name;

    public StudentBT2(String name) {
        this.name = name;
    }
}

public class BT2 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b = 20;

        System.out.println("=== SO SÁNH NGUYÊN THỦY VÀ THAM CHIẾU ===");
        System.out.println("1. Kiểu nguyên thủy (Primitive):");
        System.out.println("Giá trị của a: " + a);
        System.out.println("Giá trị của b: " + b);
        System.out.println("-------------------------");

        StudentBT2 sv1 = new StudentBT2("Trần Minh Đức");
        StudentBT2 sv2 = sv1;
        sv2.name = "Nguyễn Văn A";

        System.out.println("2. Kiểu tham chiếu (Reference):");
        System.out.println("Tên của sv1: " + sv1.name);
        System.out.println("Tên của sv2: " + sv2.name);
    }
}