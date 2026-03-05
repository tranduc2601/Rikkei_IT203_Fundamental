package SS9;


class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void displayInfo(){
        System.out.println("Họ và Tên: "+name);
        System.out.println("Tuổi: "+age);
    }
}

class Student extends Person{
    private String studentId;
    private double gpa;

    public Student(String name, int age, String studentId, double gpa){
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Ma Sinh vien: "+studentId);
        System.out.println("GPA: "+gpa);
    }
}
public class BT1{
    public static void main(String[] args) {
        System.out.println("Thong tin sinh vien");
        Student sv = new Student(" Nguyen Van A",20, "SV001", 8.5);
        sv.displayInfo();
    }
}
