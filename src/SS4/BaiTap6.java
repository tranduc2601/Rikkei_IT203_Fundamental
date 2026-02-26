package SS4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BaiTap6 {

    public static String filterSensitiveWords(String text, String[] blacklist) {
        String result = text;
        for (String word : blacklist) {
            StringBuilder stars = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                stars.append("*");
            }

            result = Pattern.compile(word, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)
                    .matcher(result)
                    .replaceAll(stars.toString());
        }
        return result;
    }

    public static String truncateReview(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        }

        String truncated = text.substring(0, maxLength);
        int lastSpaceIndex = truncated.lastIndexOf(" ");

        if (lastSpaceIndex > 0) {
            truncated = truncated.substring(0, lastSpaceIndex);
        }

        StringBuilder finalReview = new StringBuilder(truncated);
        finalReview.append("...");
        return finalReview.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] blacklist = {"tệ", "ngu ngốc", "rác rưởi", "đần độn"};

        int MAX_LENGTH = 200;

        System.out.println("=== HỆ THỐNG KIỂM DUYỆT ĐÁNH GIÁ ===");
        System.out.println("(Gõ 'exit' để thoát chương trình)\n");

        while (true) {
            System.out.print("Nhập đánh giá của bạn: ");
            String review = sc.nextLine();

            if (review.equalsIgnoreCase("exit")) {
                System.out.println("Đã thoát hệ thống kiểm duyệt.");
                break;
            }

            String filteredReview = filterSensitiveWords(review, blacklist);
            String finalResult = truncateReview(filteredReview, MAX_LENGTH);

            System.out.println("Review sau khi xử lý: " + finalResult + "\n");
        }

        sc.close();
    }
}