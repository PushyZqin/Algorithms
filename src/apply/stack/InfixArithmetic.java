package apply.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

/**
 * @author Pushy
 * @since 2019/3/31 10:54
 */
public class InfixArithmetic {

    private static final Logger logger = Logger.getLogger("InfixArithmetic");

    private Map<Character, Integer> priority = new HashMap<>();

    public InfixArithmetic() {
        priority.put('+', 3);
        priority.put('-', 3);
        priority.put('*', 5);
        priority.put('/', 5);
        priority.put('(', 1);
    }

    /**
     * a + b * c + (d * e + f) * g => abc * + d e * f + g * +
     * @param infix infix expression string
     * @return suffix expression string
     */
    public String infixToSuffix(String infix) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (stack.isEmpty()) stack.push(c);
                else {
                    char top = stack.peek();
                    // 当栈顶元素为 (，如果当前操作符不是），则都将操作符推入栈中
                    if (top == '(') {
                        if (c != ')') stack.push(c);
                    }
                    // 如果当前操作符(，由于具有最高优先级，则将它放入栈中
                    else if (c == '(') {
                        stack.push(c);
                    }
                    // 如果当前操作符为 ')' 时，将栈中的元素弹出直到 '(' 为止，包括 ‘(’
                    else if (c == ')') {
                        while (top != '(') {
                            stack.pop();
                            sb.append(top);
                            top = stack.peek();
                        }
                        stack.pop();
                    }
                    // 如果当前运算符的优先级大于栈顶运算符的优先级，则入栈
                    else if (priority.get(c) > priority.get(top)) {
                        stack.push(c);
                    }
                    else {
                        // 如果当前运算符的优先级小于栈顶运算符的优先级，则将栈中的元素出栈
                        // 直到小于当前运算符的优先级元素为止
                        while (priority.get(c) <= priority.get(top)) {
                            stack.pop();
                            if (top != '(' && top != ')') sb.append(top);
                            if (stack.isEmpty()) break;
                            top = stack.peek();
                        }
                        // 将当前运算符入栈
                        stack.push(c);
                    }
                }
            }
        }
        // 将剩余的操作符全部入栈
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * 计算后缀表达式，算法如下：
     * 1. 如果是数字，则入栈
     * 2. 如果是操作符，则从栈中出栈两个数字通过该操作符进行计算，并将结果重新压入栈中
     * 3. 最后，栈顶元素（仅剩一个）即为所计算的结果值
     * @param suffix suffix expression string
     */
    public int countBySuffix(String suffix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else {
                if (stack.size() == 1) return stack.pop();
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res;
                if (c == '+') res = num1 + num2;
                else if (c == '-') res = num1 - num2;
                else if (c == '*') res = num1 * num2;
                else if (c == '/') res = num1 / num2;
                else continue;
                stack.push(res);
            }
        }
        if (stack.size() != 1) {
            throw new RuntimeException("Error expression can't be count, current stack: " + stack);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        InfixArithmetic arithmetic = new InfixArithmetic();
//        String infix = "(2 * 4) + 8 * 9 + (2 / 3)";
        String infix = "(1 + 2 * 2) * 3 * 34";
        String suffix = "122*+3**34";  // 123*+45*6+7*+

        logger.info("suffix: " + suffix);

        int res = arithmetic.countBySuffix(suffix);
        System.out.println(res);
    }

}
