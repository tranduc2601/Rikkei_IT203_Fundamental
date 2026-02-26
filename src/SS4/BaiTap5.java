package SS4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaiTap5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^(\\d{4}-\\d{2}-\\d{2}) \\| User: (\\w+) \\| Action: (BORROW|RETURN) \\| BookID: (\\w+)$";
        Pattern pattern = Pattern.compile(regex);

        int borrowCount = 0;
        int returnCount = 0;

        System.out.println("--- HỆ THỐNG TRÍCH XUẤT LOG THƯ VIỆN ---");
        System.out.println("Nhập dòng log (hoặc gõ 'exit' để thoát và xem thống kê):");

        while (true) {
            System.out.print("> ");
            String logLine = sc.nextLine();

            if (logLine.equalsIgnoreCase("exit")) {
                break;
            }

            Matcher matcher = pattern.matcher(logLine);

            if (matcher.matches()) {
                String date = matcher.group(1);
                String user = matcher.group(2);
                String action = matcher.group(3);
                String bookId = matcher.group(4);

                System.out.println("Ngày: " + date);
                System.out.println("Người dùng: " + user);
                System.out.println("Hành động: " + action);
                System.out.println("Mã sách: " + bookId + "\n");

                if (action.equals("BORROW")) {
                    borrowCount++;
                } else if (action.equals("RETURN")) {
                    returnCount++;
                }
            } else {
                System.out.println("Lỗi: Dòng log không đúng định dạng!\n");
            }
        }

        System.out.println("\n========= BẢNG THỐNG KÊ =========");
        System.out.println("Tổng số lượt mượn (BORROW): " + borrowCount);
        System.out.println("Tổng số lượt trả (RETURN): " + returnCount);

        sc.close();
    }
}