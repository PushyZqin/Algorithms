package skill.recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/6/13 21:10
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) return;

        reverseString(s, 0);
    }

    private void reverseString(char[] s, int idx) {
        if (idx >= s.length / 2) return;

        char temp = s[idx];
        s[idx] = s[s.length - 1 - idx];
        s[s.length - 1 - idx] = temp;
        reverseString(s, idx + 1);
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        ReverseString solution = new ReverseString();
        solution.reverseString(s);

        System.out.println(Arrays.toString(s));
    }

}
