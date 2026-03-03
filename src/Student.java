public class Student {
    private String id;
    private String name;

    static int StudentCount = 0;
    static final String SCHOOL_NAME = "ABC University";

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        StudentCount++;
    }


    public void displayInfo(){
        System.out.println("Ma SV: "+id);
        System.out.println("Ten SV: "+name);
        System.out.println("Ten truong: "+SCHOOL_NAME);

        System.out.println("====================");
    }
    public static void showTotalStudent() {
        System.out.println("Tong so sinh vien toan truong: "+StudentCount);

        System.out.println("====================");
    }
}
