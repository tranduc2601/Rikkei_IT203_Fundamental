package SS4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BaiTap3 {
    public static void main(String[] args) {
        String[] transactions = {"BK001-20/01", "BK005-21/01", "BK099-22/01"};

        StringBuilder report = new StringBuilder();
        report.append("--- BÁO CÁO MƯỢN SÁCH ---\n");

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        report.append("Ngày tạo: ").append(currentDate).append("\n");

        for (String transaction : transactions) {
            report.append("Giao dịch: ").append(transaction).append("\n");
        }

        System.out.println(report.toString());

        int loopCount = 50000;

        long startTimeSb = System.currentTimeMillis();
        StringBuilder testSb = new StringBuilder();
        for (int i = 0; i < loopCount; i++) {
            testSb.append("Giao dịch: BK001-20/01\n");
        }
        long timeSb = System.currentTimeMillis() - startTimeSb;

        long startTimeStr = System.currentTimeMillis();
        String testStr = "";
        for (int i = 0; i < loopCount; i++) {
            testStr += "Giao dịch: BK001-20/01\n";
        }
        long timeStr = System.currentTimeMillis() - startTimeStr;

        System.out.println("Số thời gian thực thi đối với StringBuilder: " + timeSb);
        System.out.println("Số thời gian thực thi đối với String: " + timeStr);
    }
}