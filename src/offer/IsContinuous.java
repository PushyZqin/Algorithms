package offer;

import java.util.Arrays;

public class IsContinuous {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);

        int count = 0;  // 0的个数
        for (int num : numbers) {
            if (num == 0) count++;
        }

        int start = count, end = start + 1;
        int gap = 0; // 间隔数
        while (end < numbers.length) {  // 计算间隔数
            if (numbers[start] == numbers[end]) // 当有两个数相等时不可能会组成顺子
                return false;

            gap += numbers[end] - numbers[start] - 1;
            start = end;
            end++;
        }
        System.out.println(gap);
        System.out.println(count);

        return (gap > count) ? false : true;
    }

    public static void main(String[] args) {
        IsContinuous s = new IsContinuous();
        System.out.println(s.isContinuous(new int[]{0, 3, 2, 6, 4}));
    }

}
