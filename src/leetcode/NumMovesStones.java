package leetcode;

import java.util.Arrays;

/**
 * @author Pushy
 * @since 2019/4/30 19:33
 */
public class NumMovesStones {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        int[] res = new int[2];
        Arrays.sort(arr);

        int x = arr[0], y = arr[1], z = arr[2];
        int s1 = y - x, s2 = z - y;

        if (s1 == 1 && s2 == 1) { // 无法移动
            res[0] = 0;
        }
        // 求最小路径
        else if (s1 <= 2 || s2 <= 2) {
            res[0] = 1;
        }
        else {
            res[0] = 2;
        }

        // 求最大路径
        res[1] = s2 + s1 - 2;
        return res;
    }

    public static void main(String[] args) {
        NumMovesStones solution = new NumMovesStones();
        int[] res = solution.numMovesStones(7, 4, 1);
        System.out.println(Arrays.toString(res));
    }

}
