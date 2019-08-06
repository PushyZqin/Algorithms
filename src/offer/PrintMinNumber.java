package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PrintMinNumber {

    public String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int j : list) {
            sb.append(j);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber solution = new PrintMinNumber();
        String result = solution.PrintMinNumber(new int[]{3, 32, 321});
        System.out.println(result);
    }

}
