package SS13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BT2 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList(
                "Paracetamol", "Ibuprofen", "Panadol", "Paracetamol", "Aspirin", "Ibuprofen"
        );

        List<String> output = removeDuplicatesAndSort(input);

        System.out.println(output);
    }

    public static List<String> removeDuplicatesAndSort(List<String> list) {
        List<String> uniqueList = new ArrayList<>();

        for (String item : list) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        Collections.sort(uniqueList);

        return uniqueList;
    }
}