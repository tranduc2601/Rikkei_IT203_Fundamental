package SS4;

import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên sách: ");
        String title = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        String author = sc.nextLine();

        System.out.print("Nhập thể loại: ");
        String genre = sc.nextLine();

        String normalizedTitle = title.trim().replaceAll("\\s+", " ").toUpperCase();

        String cleanedAuthor = author.trim().replaceAll("\\s+", " ").toLowerCase();
        String[] words = cleanedAuthor.split(" ");

        StringBuilder formattedAuthor = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String firstLetter = word.substring(0, 1).toUpperCase();
                String restOfWord = word.substring(1);
                formattedAuthor.append(firstLetter).append(restOfWord).append(" ");
            }
        }

        String finalAuthor = formattedAuthor.toString().trim();

        System.out.println("\n--- KẾT QUẢ MONG MUỐN ---");
        System.out.println("[" + normalizedTitle + "] - Tác giả: " + finalAuthor);

        sc.close();
    }
}