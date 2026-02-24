package SS2;

import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] BT2) {
        Scanner sc = new Scanner(System.in);
        char code;

        do {
            System.out.print("Nhập mã khu vực (A, B, C, D) hoặc 'X' để thoát: ");
            code = sc.next().toUpperCase().charAt(0);

            if (code == 'X') {
                System.out.println("Đã thoát chương trình.");
                break;
            }

            switch (code) {
                case 'A':
                    System.out.println("Tầng 1: Sách Văn học");
                    break;
                case 'B':
                    System.out.println("Tầng 2: Sách Khoa học");
                    break;
                case 'C':
                    System.out.println("Tầng 3: Sách Ngoại ngữ");
                    break;
                case 'D':
                    System.out.println("Tầng 4: Sách Tin học");
                    break;
                default:
                    System.out.println("Mã nhập sai!");
                    break;
            }
        } while (true);

        sc.close();
    }
}