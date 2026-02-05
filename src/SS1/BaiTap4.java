package SS1;

import java.util.Scanner;

public class BaiTap4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập giá sách (USD - kiểu double): ");
        double bookPrice = sc.nextDouble();

        System.out.print("Nhập tỷ giá (VNĐ - kiểu float): ");
        float exchangeRate = sc.nextFloat();

        double totalVND = bookPrice * exchangeRate;
        long roundedTotal = (long) totalVND;

        System.out.println("Giá chính xác (số thực): " + totalVND);
        System.out.println("Giá làm tròn để thanh toán (long): " + roundedTotal);
    }
}