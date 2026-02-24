package SS2;

import java.util.Scanner;

public class BaiTap4 {
    public static void main(String[] BT4) {
        Scanner sc = new Scanner(System.in);
        int bookID;

        do {
            System.out.print("Nhập mã ID sách mới (ID > 0): ");
            bookID = sc.nextInt();

            if (bookID <= 0) {
                System.out.println("Mã không hợp lệ, hãy nhập lại");
            }
        } while (bookID <= 0);

        System.out.println("Lưu mã sách thành công!");

        sc.close();
    }
}