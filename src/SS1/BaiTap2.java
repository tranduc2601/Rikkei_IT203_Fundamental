package SS1;

import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số ngày chậm trễ: ");
        int daysLate = sc.nextInt();
        System.out.print("Nhập số lượng sách mượn: ");
        int bookCount = sc.nextInt();
        double baseFine = daysLate * bookCount * 5000;
        boolean isSeverePenalty = (daysLate > 7) && (bookCount >= 3);
        double finalFine = isSeverePenalty ? baseFine * 1.2 : baseFine;
        boolean isCardLocked = finalFine > 50000;
        System.out.printf("Tiền phạt gốc: %.1f VNĐ\n", baseFine);
        System.out.printf("Tiền phạt sau điều chỉnh: %.1f VNĐ\n", finalFine);
        System.out.println("Yêu cầu khóa thẻ: " + isCardLocked);
        sc.close();
    }
}