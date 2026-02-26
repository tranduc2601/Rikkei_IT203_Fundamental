package SS4;

public class BaiTap2 {
    public static void main(String[] args) {
        String description = "Sách giáo khoa Toán lớp 12, Kệ: A1-102, tình trạng mới";

        if (description.contains("Kệ:")) {
            int startIndex = description.indexOf("Kệ:") + 3;
            int endIndex = description.indexOf(",", startIndex);

            if (endIndex == -1) {
                endIndex = description.length();
            }

            String location = description.substring(startIndex, endIndex).trim();
            System.out.println("Vị trí tìm thấy: " + location);

            String newDescription = description.replace("Kệ:", "Vị trí lưu trữ:");

            if (!newDescription.endsWith(".")) {
                newDescription += ".";
            }

            System.out.println("Mô tả mới: " + newDescription);
        } else {
            System.out.println("Không tìm thấy vị trí lưu trữ trong mô tả.");
        }
    }
}