package SS14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BT4 {
    public static void main(String[] args) {
        List<String> reportedCases = Arrays.asList(
                "Cúm A", "Sốt xuất huyết", "Cúm A", "Covid-19", "Cúm A", "Sốt xuất huyết"
        );

        Map<String, Integer> statistics = new TreeMap<>();

        for (String disease : reportedCases) {
            if (statistics.containsKey(disease)) {
                int currentCount = statistics.get(disease);
                statistics.put(disease, currentCount + 1);
            } else {
                statistics.put(disease, 1);
            }

        }

        System.out.println("Output (đã sắp xếp):");
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}