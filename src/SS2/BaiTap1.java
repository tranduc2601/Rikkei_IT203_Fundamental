package SS2;

import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] BT1) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();

        System.out.print("Nhập số sách đang giữ: ");
        int booksHeld = sc.nextInt();

        if (age >= 18 && booksHeld < 3) {
            System.out.println("Cho phép mượn sách");
        } else {
            if (age < 18) {
                System.out.println("Bạn chưa đủ tuổi");
            }
            if (booksHeld >= 3) {
                System.out.println("Bạn đã mượn quá số lượng cho phép");
            }
        }

        sc.close();
    }
}