package SS7;

class Config {

    public static final int MAX_SCORE = 10;
    public static final int MIN_SCORE = 0;
    public static final String SUBJECT_NAME = "Lập trình Java";

}

public class BT5 {
//    Config.MAX_SCORE = 15;

    public static void main(String[] args) {
        System.out.println("=== CẤU HÌNH HỆ THỐNG ===");
        System.out.println("Môn học: " + Config.SUBJECT_NAME);
        System.out.println("Điểm tối đa: " + Config.MAX_SCORE);
        System.out.println("Điểm tối thiểu: " + Config.MIN_SCORE);
        System.out.println("-------------------------");

        int studentScore = 8;

        System.out.println("Kiểm tra điểm của sinh viên: " + studentScore);

        if (studentScore >= Config.MIN_SCORE && studentScore <= Config.MAX_SCORE) {
            System.out.println("-> Trạng thái: Điểm hợp lệ!");
        } else {
            System.out.println("-> Trạng thái: Điểm KHÔNG hợp lệ!");
        }
    }
}


