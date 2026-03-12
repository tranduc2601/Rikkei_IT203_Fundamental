package SS14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BT3 {
    public static void main(String[] args) {
        List<Integer> listA_Int = Arrays.asList(101, 102, 105);
        List<Integer> listB_Int = Arrays.asList(102, 105, 108);

        List<Integer> commonInts = findCommonPatients(listA_Int, listB_Int);
        System.out.println(commonInts);

        List<String> listA_Str = Arrays.asList("DN01", "DN02", "DN03");
        List<String> listB_Str = Arrays.asList("DN02", "DN04");

        List<String> commonStrs = findCommonPatients(listA_Str, listB_Str);
        System.out.println(commonStrs);
    }

    public static <T> List<T> findCommonPatients(List<T> list1, List<T> list2) {
        List<T> commonList = new ArrayList<>();

        for (T item : list1) {
            if (list2.contains(item)) {
                commonList.add(item);
            }
        }

        return commonList;
    }
}