package SS2;

import java.util.Scanner;

public class BaiTap5 {
    public static void main(String[] BT5) {
        Scanner sc = new Scanner(System.in);
        int score = 100;
        int days;

        System.out.println("--- HỆ THỐNG TÍNH ĐIỂM UY TÍN ---");
        System.out.println("Nhập lịch sử trả sách (nhập 999 để kết thúc)");

        while (true) {
            System.out.print("Nhập số ngày trễ (<= 0 là đúng hạn, > 0 là trễ): ");
            days = sc.nextInt();

            if (days == 999) {
                break;
            }

            if (days <= 0) {
                score += 5;
            } else {
                score -= (days * 2);
            }
        }

        System.out.println("\nTổng điểm uy tín cuối cùng: " + score);

        if (score > 120) {
            System.out.println("Xếp loại: Độc giả Thân thiết");
        } else if (score >= 80 && score <= 120) {
            System.out.println("Xếp loại: Độc giả Tiêu chuẩn");
        } else {
            System.out.println("Xếp loại: Độc giả cần lưu ý");
        }

        sc.close();
    }
}