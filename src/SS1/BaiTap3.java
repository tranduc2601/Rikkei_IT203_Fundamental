package SS1;

public class BaiTap3 {
    public static void main(String[] args) {
        String book1 = "Java Basic";
        String book2 = "Python Intro";

        System.out.println("Trước khi hoán đổi: Book1 = " + book1 + ", Book2 = " + book2);

        String temp = book1;
        book1 = book2;
        book2 = temp;

        System.out.println("Sau khi hoán đổi:  Book1 = " + book2 + ", Book2 = " + book1);
    }
}