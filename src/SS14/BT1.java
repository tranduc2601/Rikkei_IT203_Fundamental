package SS14;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class BT1 {
    public static void main(String[] args) {
        String[] input = {
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        };

        Set<String> waitingList = new LinkedHashSet<>(Arrays.asList(input));
        System.out.println("Danh sách gọi khám: " + String.join(", ", waitingList));
    }
}