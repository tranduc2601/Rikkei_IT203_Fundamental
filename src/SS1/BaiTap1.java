package SS1;
import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách: ");
        String bookID = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String bookName = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int publishYear = sc.nextInt();

        System.out.print("Nhập giá bìa: ");
        double price = sc.nextDouble();

        System.out.print("Sách còn trong kho (true/false): ");
        boolean isAvailable = sc.nextBoolean();

        int currentYear = 2026;
        int bookAge = currentYear - publishYear;

        String displayBookName = bookName.toUpperCase();
        String status = isAvailable ? "Còn sách" : "Đã mượn";

        System.out.println("\n--- PHIẾU THÔNG TIN SÁCH ---");
        System.out.println("Tên sách: " + displayBookName);
        System.out.printf("Mã số: %s | Tuổi thọ: %d năm\n", bookID, bookAge);
        System.out.printf("Giá bán: %.2f VNĐ\n", price);
        System.out.println("Tình trạng: " + status);

        sc.close();
    }
}