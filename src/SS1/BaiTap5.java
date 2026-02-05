package SS1;

import java.util.Scanner;

public class BaiTap5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách (4 chữ số): ");
        int bookCode = sc.nextInt();

        int units = bookCode % 10;
        int dozens = (bookCode / 10) % 10;
        int hundreds = (bookCode / 100) % 10;
        int thousands = bookCode / 1000;

        int sumOfFirstThree = thousands + hundreds + dozens;
        int expectedCheckDigit = sumOfFirstThree % 10;

        boolean isValid = units == expectedCheckDigit;
        String resultText = isValid ? "HỢP LỆ" : "SAI MÃ";

        System.out.println("Chữ số kiểm tra kỳ vọng: " + expectedCheckDigit);
        System.out.println("Kết quả kiểm tra mã sách: " + resultText);
    }
}