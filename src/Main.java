public class Main {
    public static void main(String[] args) {

        Student.showTotalStudent();

        Student sv1 = new Student("D24TXCN106","Tran Minh Duc");
        sv1.displayInfo();
        Student sv2 = new Student("D24TXCN105","Tran Minh");
        sv2.displayInfo();
        Student sv3 = new Student("D24TXCN104","Tran");
        sv3.displayInfo();

        Student.showTotalStudent();
    }
}