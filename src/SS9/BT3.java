package SS9;

class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
}
class Manager extends Employee {
    private String department;

    public Manager(String name, double baseSalary, String department) {
        super(name, baseSalary);

        this.department = department;
    }
    public void displayInfo() {
        System.out.println("--- THÔNG TIN QUẢN LÝ ---");
        System.out.println("Tên quản lý: " + getName());
        System.out.println("Lương cơ bản: " + getBaseSalary() + " VNĐ");
        System.out.println("Phòng ban: " + department);
    }
}

public class BT3 {
    public static void main(String[] args) {
        Manager mgr = new Manager("Trần Minh Đức", 15000000.0, "Phòng Kỹ thuật (IT)");

        mgr.displayInfo();
    }
}