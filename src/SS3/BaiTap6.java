package SS3;

import java.util.Arrays;

public class BaiTap6 {

    public static int[] mergeBooks(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            temp[count++] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            temp[count++] = b[i];
        }

        Arrays.sort(temp);

        int[] uniqueTemp = new int[temp.length];
        int uniqueCount = 0;

        for (int i = 0; i < temp.length; i++) {
            if (i == 0 || temp[i] != temp[i - 1]) {
                uniqueTemp[uniqueCount++] = temp[i];
            }
        }

        int[] arrayMerge = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            arrayMerge[i] = uniqueTemp[i];
        }

        return arrayMerge;
    }

    public static void main(String[] args) {
        int[] khoCu = {1, 3, 5, 7, 9};
        int[] loMoi = {2, 3, 5, 6, 8, 9, 10};

        System.out.println("Kho cũ:   " + Arrays.toString(khoCu));
        System.out.println("Lô mới:   " + Arrays.toString(loMoi));

        int[] khoTong = mergeBooks(khoCu, loMoi);

        System.out.println("Kho tổng (đã gộp & lọc trùng): " + Arrays.toString(khoTong));
    }
}