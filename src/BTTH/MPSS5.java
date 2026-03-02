package BTTH;

import java.util.Scanner;

public class MPSS5 {
    public static void main(String[] HappyNumbers) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("=== CHƯƠNG TRÌNH KIỂM TRA SỐ HẠNH PHÚC ===");

        while (true) {
            System.out.print("Nhập một số nguyên dương n: ");
            input = scanner.nextLine().trim();

            if (input.matches("^[1-9]\\d{0,8}$")) {
                break;
            } else {
                System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên dương hợp lệ!");
            }
        }

        int n = Integer.parseInt(input);

        if (isHappy(n)) {
            System.out.println(n + " là SỐ HẠNH PHÚC!");
        } else {
            System.out.println(n + " KHÔNG phải là số hạnh phúc (infinite loop).");
        }
        scanner.close();
    }



    public static boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = getNext(n);
        }
        return n == 1;
    }

    public static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n = n / 10;
        }
        return totalSum;
    }
}
