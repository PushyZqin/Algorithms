package leetcode.problemset._38_Count_and_Say;

public class Solution {

    public String countAndSay(int n) {
        String str = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char prev = str.charAt(0);
            int count = 1;

            for (int j = 1; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == prev)
                    count++;
                else {
                    sb.append(count).append(prev);
                    prev = ch;
                    count = 1;
                }
            }
            sb.append(count).append(prev);
            str = sb.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.countAndSay(5);
        System.out.println(res);
    }

}
