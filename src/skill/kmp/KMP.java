package skill.kmp;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/4/19 11:40
 */
public class KMP {

    /**
     * 暴力破解查找
     */
    public static int violentMatch(String s, String p) {
        int ls = s.length(), lp = p.length();
        int i = 0, j = 0;

        while (i < ls && j < lp) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == lp) return i - j;
        else return -1;
    }

    public static int kmpSearch(String s, String p) {
        int i = 0, j = 0;
        char[] src = s.toCharArray(), ptn = p.toCharArray();
        int ls = src.length, lp = ptn.length;

        int[] next = getNext(ptn);
        while (i < ls && j < lp) {
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == lp)
            return i - j;
        return -1;
    }

    private static int[] getNext(char[] ptn) {
        int lp = ptn.length;
        int[] next = new int[lp];

        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < lp - 1) {
            if (k == -1 || ptn[j] == ptn[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    public static void main(String[] args) {
//        int r = violentMatch("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
        int r = kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD");

        System.out.println(r);
    }

}
