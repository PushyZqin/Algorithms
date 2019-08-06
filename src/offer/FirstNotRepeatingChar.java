package offer;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {

    // 暴力破解，时间复杂度 O(n^2)
//    public char FirstNotRepeatingChar(String str) {
//        char[] chars = str.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//            boolean flag = true;
//            for (int j = i + 1; j < chars.length; j++) {
//                if (chars[i] == chars[j]) flag = false;
//            }
//
//            if (flag) {
//                return chars[i];
//            }
//        }
//        return 0;
//    }

    // 使用哈希表来优化双循环
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) return i;
        }
        return '\0';
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar s = new FirstNotRepeatingChar();
        int result = s.FirstNotRepeatingChar("abaccdeff");
        System.out.println(result);
    }

}
