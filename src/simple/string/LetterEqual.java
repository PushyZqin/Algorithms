package simple.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断两个给定的字符串，判断这两个字符串的字母是不是完全一样（顺序可以不一样）
 *
 * @author Pushy
 * @since 2018/12/23 21:37
 */
public class LetterEqual {

    /**
     * 通过将字符串的字符放入到无序集合中，然后通过内置的equal()方法来对比两个无序集合是否相等
     * 就可以判断出两个字符串是否相等
     */
    public static boolean solution(String s, String t) {
        Set<Character> characters1 = new HashSet<>();
        Set<Character> characters2 = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            characters1.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            characters2.add(t.charAt(i));
        }

        return characters1.equals(characters2);
    }

    public static boolean solution1(String s1, String s2) {
        // 分别存储字符串的字符
        char[] array1 = new char[26];
        char[] array2 = new char[26];

        for (int i = 0; i < s1.length(); i++) {
            char value = s1.charAt(i);
            // 算出要存储的位置
            int index = value - 'a';
            array1[index]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char value = s2.charAt(i);
            // 算出要存储的位置
            int index = value - 'a';
            array2[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        boolean result = LetterEqual.solution("pleasefollowthewechatpublicnumber",
                "pleowcnumberthewechatpubliasefoll");

        long end = System.nanoTime();

        System.out.println(result);


        System.out.println("Time：" + (end - start));
    }


}
