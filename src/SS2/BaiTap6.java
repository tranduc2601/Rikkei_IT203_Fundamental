package SS2;

import java.util.Scanner;

public class BaiTap6 {
    public static void main(String[] BT6) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int validDays = 0;

        for (int i = 1; i <= 7; i++) {
            String dayName = (i == 7) ? "Chủ Nhật" : "Thứ " + (i + 1);
            System.out.print("Nhập số lượt mượn sách của " + dayName + ": ");
            int borrows = sc.nextInt();

            if (borrows == 0) {
                continue;
            }

            if (borrows > max) {
                max = borrows;
            }
            if (borrows < min) {
                min = borrows;
            }

            sum += borrows;
            validDays++;
        }

        System.out.println("\n--- KẾT QUẢ THỐNG KÊ ---");

        if (validDays > 0) {
            double average = (double) sum / validDays;
            System.out.println("Lượt mượn cao nhất: " + max);
            System.out.println("Lượt mượn thấp nhất: " + min);
            System.out.printf("Trung bình lượt mượn (các ngày mở cửa): %.2f\n", average);
        } else {
            System.out.println("Thư viện đóng cửa cả tuần (không có dữ liệu).");
        }

        sc.close();
    }
}