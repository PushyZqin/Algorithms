package offer;

import java.util.Stack;

public class ReverseSentence {

    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) return str;

        String[] strs = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (String s : strs) {
            stack.push(s);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseSentence s = new ReverseSentence();
        String str = s.ReverseSentence(" ");
        System.out.println(str);
    }

}
