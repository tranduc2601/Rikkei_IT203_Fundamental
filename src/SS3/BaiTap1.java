package SS3;

import java.util.Scanner;

public class BaiTap1 {
    static Scanner sc = new Scanner(System.in);

    public static int[] addBookToLibraries(int n) {
        int[] arr = new int[n];
        System.out.println("Nhập mã số cho " + n + " cuốn sách:");
        for (int i = 0; i < n; i++) {
            System.out.print("Sách thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void displayLibraries(int[] arr) {
        System.out.println("--- KẾT QUẢ ---");
        System.out.print("Danh sách mã sách:\t");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",\t");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Nhập số lượng sách cần quản lý: ");
        int n = sc.nextInt();

        int[] books = addBookToLibraries(n);
        displayLibraries(books);

        sc.close();
    }
}