package fourth.bagQueueStack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Dijkstra 的双栈算术表达式求值算法
 *
 * @author Pushy
 * @since 2019/1/6 12:25
 */
public class DijkstraDoublyStackEvaluate {

    private static final List<String> opsList = Arrays.asList("+", "-", "*", "/", "sqrt");

    public static double solution(String stdIn) {
        Stack<String> ops = new Stack<>();     // 运算符栈
        Stack<Double> vals = new Stack<>();    // 操作数栈

        for (int i = 1; i < stdIn.length() + 1; i++) {
            String s = stdIn.substring(i - 1, i);
            if (s.equals("(")) {
            }   // 如果是字符 "("，则忽略，继续下一个字符的遍历
            else if (opsList.contains(s)) {  // 如果是运算符则压入栈
                ops.push(s);
            } else if (s.equals(")")) {
                /* 如果是字符 ")"，弹出运算符和操作数，计算结果后并重新压入栈 */
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } else {  // 如果字符既不是运算符也不是括号，那么将它作为 double 压入操作数栈
                vals.push(Double.parseDouble(s));
            }
        }
        return vals.pop();
    }


    public static void main(String[] args) {
        double res = DijkstraDoublyStackEvaluate.solution("(1+((2+3)*(4*5)))");
        System.out.println(res);
    }

}
