package leetcode.explore.evalRPN;

/**
 * @author Pushy
 * @since 2019/4/2 17:04
 */
public class Solution2 {

    private int N = -1;

    public int evalRPC(String[] tokens) {
        if (N == -1) N = tokens.length - 1;
        String s = tokens[N--];
        char c = s.charAt(0);
        if (s.length() == 1 && "+-*/".indexOf(c) != -1) {
            int a = evalRPC(tokens);
            int b = evalRPC(tokens);
            switch (c) {
                case '+':return a+b;
                case '-':return b-a;
                case '*':return a*b;
                case '/':return b/a;
                default:break;
            }
        }
        return Integer.parseInt(s);
    }

}
