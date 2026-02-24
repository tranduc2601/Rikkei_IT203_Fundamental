package SS2;

import java.util.Scanner;

public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ THƯ VIỆN ===");
            System.out.println("1. Tính tiền phạt trả sách");
            System.out.println("2. Đăng ký thẻ mượn sách VIP");
            System.out.println("3. Thoát chương trình");
            System.out.print("Vui lòng chọn chức năng (1-3): ");

            choice = sc.nextInt();

            switch (choice)
                {
                case 1: {
                    System.out.println("\n--- CHỨC NĂNG 1: TÍNH TIỀN PHẠT ---");
                    System.out.print("Nhập số lượng sách độc giả trả: ");
                    int bookCount = sc.nextInt();
                    long totalFine = 0;

                    for (int i = 1; i <= bookCount; i++) {
                        System.out.print("Nhập số ngày quá hạn của cuốn thứ " + i + ": ");
                        int daysLate = sc.nextInt();

                        if (daysLate > 5) {
                            totalFine += (5 * 2000) + ((daysLate - 5) * 5000);
                        } else if (daysLate > 0) {
                            totalFine += daysLate * 2000;
                        }
                    }
                    System.out.println("Tổng tiền phạt của độc giả: " + totalFine + " VNĐ");
                    break;
                }
                case 2:
                    System.out.println("\n--- CHỨC NĂNG 2: ĐĂNG KÝ THẺ VIP ---");
                    System.out.print("Nhập tuổi của độc giả: ");
                    int age = sc.nextInt();
                    System.out.print("Nhập số sách đã mượn trong tháng qua: ");
                    int borrowedBooks = sc.nextInt();
                    System.out.print("Có thẻ sinh viên ưu tiên không? (1 = Có, 0 = Không): ");
                    int hasPriorityCard = sc.nextInt();

                    if ((age >= 18 && borrowedBooks >= 10) || hasPriorityCard == 1) {
                        System.out.println("Kết quả: Đủ tiêu chuẩn nâng cấp VIP");
                    } else {
                        System.out.println("Kết quả: Chưa đủ tiêu chuẩn");
                    }
                    break;

                case 3:
                    System.out.println("\nĐã thoát chương trình. Hẹn gặp lại!");
                    break;

                default:
                    System.out.println("\nLựa chọn không hợp lệ, vui lòng chọn lại!");
                    break;
            }
        } while (choice != 3);

        sc.close();
    }
}