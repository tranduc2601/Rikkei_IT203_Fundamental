package SS3;

import java.util.Scanner;

public class BaiTap5 {

    public static int deleteBook(int[] arr, int n, int bookId) {
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            System.out.println("Đã xóa sách mã " + bookId);
            return n - 1;
        } else {
            System.out.println("Không tìm thấy sách mã " + bookId + " trong kho.");
            return n;
        }
    }

    public static void displayBooks(int[] arr, int n) {
        System.out.print("Kho sách hiện tại (" + n + " cuốn): [ ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] books = new int[100];
        books[0] = 101;
        books[1] = 102;
        books[2] = 103;
        books[3] = 104;
        books[4] = 105;
        int n = 5;

        while (true) {
            if (n == 0) {
                System.out.println("Kho sách đã trống hoàn toàn!");
                break;
            }

            displayBooks(books, n);

            System.out.print("Nhập mã sách cần xóa (0 để thoát): ");
            int bookId = sc.nextInt();

            if (bookId == 0) {
                break;
            }

            n = deleteBook(books, n, bookId);
        }

        sc.close();
    }
}