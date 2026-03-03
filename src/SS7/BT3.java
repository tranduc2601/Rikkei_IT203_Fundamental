package SS7;

class ScoreUtils {

    public static boolean checkPass(double score) {
        return score >= 5.0;
    }

    public static double calculateAverage(double[] scores) {
        if (scores == null || scores.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (double score : scores) {
            sum += score;
        }

        return sum / scores.length;
    }
}

public class BT3 {

    public static void main(String[] args) {
        double[] scores = {6.5, 8.0, 4.5};

        System.out.print("Danh sách điểm: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        System.out.println(">> Kết quả xử lý:");

        double average = ScoreUtils.calculateAverage(scores);
        System.out.printf("- Điểm trung bình cả lớp: %.2f\n", average);

        for (double score : scores) {
            String status = ScoreUtils.checkPass(score) ? "Đạt" : "Trượt";
            System.out.println("- Điểm " + score + ": " + status);
        }
    }
}