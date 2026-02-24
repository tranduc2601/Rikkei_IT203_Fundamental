package SS2;

import java.util.Scanner;

public class BaiTap3 {
    public static void main(String[] BT3) {

        Scanner sc = new Scanner(System.in);
        int quantity;
        System.out.println(" Nhap so luong sach tra muon:");
        quantity = sc.nextInt();
        for (int i = 1; i <= quantity; i++) {
            System.out.println(" Nhap so ngay tra cuon cuon thu " + i);
            int lateDays = sc.nextInt();
            int fine = lateDays * 5000;
            System.out.println(" Tong so tien phat cuoi cung la: " + fine);
        }
    }
}
