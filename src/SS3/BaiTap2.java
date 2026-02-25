package SS3;

import java.util.Scanner;

public class BaiTap2 {

    public static int searchBooks(String[] arr, String search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(search)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] books = {"Doraemon", "Genshin Impact Artbook", "Wuthering Waves Guide", "Java Mobile Programming", "Astrology Basics"};
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên sách cần tìm: ");
        String searchName = sc.nextLine();

        int position = searchBooks(books, searchName);

        if (position != -1) {
            System.out.println("Tìm thấy sách '" + books[position] + "' tại vị trí số: " + position);
        } else {
            System.out.println("Sách không tồn tại trong thư viện.");
        }

        sc.close();
    }
}