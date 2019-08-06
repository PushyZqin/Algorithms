package offer;

import java.util.ArrayList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length) return result;

        int i = 0, j = size - 1;
        int max = 0, maxIdx = 0;  // 最大值和最大索引值

        for (int k = 0; k <= j; k++) {
            if (num[k] > max) {
                max = num[k];
                maxIdx = k;
            }
        }
        result.add(max);
        i++;
        j++;

        while (j < num.length) {
            if (i > maxIdx) { // 最大值过期，重新寻找当前窗口中的最大值
                max = num[i];
                for (int k = i; k <= j; k++) {
                    if (num[k] > max) {
                        max = num[k];
                        maxIdx = k;
                    }
                }
                result.add(max);
            } else {
                if (num[j] > max) {
                    result.add(num[j]);
                    max = num[j];
                    maxIdx = j;
                } else {
                    result.add(max);
                }
            }
            j++;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxInWindows maxInWindows = new MaxInWindows();
        ArrayList<Integer> result = maxInWindows.maxInWindows(new int[]{16, 14, 12, 10, 8, 6, 4}, 5);
        System.out.println(result);
    }

}
