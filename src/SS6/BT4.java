package SS6;

public class BT4 {

    private String empId;
    private String name;
    private double salary;

    public BT4() {
        this.empId = "Chưa cập nhật";
        this.name = "Chưa cập nhật";
        this.salary = 0.0;
    }

    public BT4(String empId, String name) {
        this.empId = empId;
        this.name = name;
        this.salary = 0.0;
    }

    public BT4(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Mã NV: " + empId);
        System.out.println("Tên NV: " + name);
        System.out.println("Lương: " + salary + " VNĐ");
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        BT4 emp1 = new BT4();

        BT4 emp2 = new BT4("NV01", "Nguyen Van A");

        BT4 emp3 = new BT4("NV02", "Le Thi B", 15000000);

        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
    }
}