package SS4;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BaiTap4 {
    public static void main(String[] args) {
        String cardID = "TV202312345";
        validateLibraryCard(cardID);
    }

    public static void validateLibraryCard(String cardID) {
        String fullRegex = "^[A-Z]{2}\\d{4}\\d{5}$";
        Pattern pattern = Pattern.compile(fullRegex);
        Matcher matcher = pattern.matcher(cardID);

        if (matcher.matches()) {
            System.out.println("Mã thẻ hợp lệ!");
        } else {
            if (cardID.length() != 11) {
                System.out.println("Lỗi: Mã thẻ phải có đúng 11 ký tự.");
            } else if (!Pattern.matches("^[A-Z]{2}.*", cardID)) {
                System.out.println("Lỗi: Thiếu tiền tố 2 chữ cái viết hoa ở đầu (Ví dụ: TV).");
            } else if (!Pattern.matches("^[A-Z]{2}\\d{4}.*", cardID)) {
                System.out.println("Lỗi: 4 ký tự tiếp theo phải là chữ số (Năm vào học).");
            } else {
                System.out.println("Lỗi: 5 ký tự cuối cùng phải là chữ số ngẫu nhiên.");
            }
        }
    }
}