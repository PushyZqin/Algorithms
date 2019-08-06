package offer;

/**
 * @author pushy zheng
 * @since 2019/8/2
 */
public class NumberOf1Between1AndN {

// 暴力解法，遍历1~n添加到StringBuilder当中，然后遍历StringBuilder统计1字符出现的次数
//    public int NumberOf1Between1AndN_Solution(int n) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            sb.append(i);
//        }
//
//        int count = 0;
//        for (int i = 0; i < sb.length(); i++) {
//            if (sb.charAt(i) == '1') count++;
//        }
//        return count;
//    }

    /**
     * 时间复杂度为 O(nlogn)
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;

        for (int i = 1; i <= n; i++) {
            res += numberOf1(i);
        }
        return res;
    }

    private int numberOf1(int num) {
        int result = 0;
        while (num > 0) {
            if (num % 10 ==1) {
                result++;
                num /= 10;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        NumberOf1Between1AndN numberOf1Between1AndN = new NumberOf1Between1AndN();
        int result = numberOf1Between1AndN.NumberOf1Between1AndN_Solution(55);
        System.out.println(result);
    }
}
