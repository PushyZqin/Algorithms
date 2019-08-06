package apply.stack;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @author Pushy
 * @since 2019/3/31 9:44
 */
public class Symbol {

    private List<Character> openingSymbols = Arrays.asList('(', '{', '[');
    private List<Character> closingSymbols = Arrays.asList(')', '}', ']');
    private Map<Character, Character> symbolMap = new HashMap<>();

    private Stack<Character> stack = new Stack<>();

    public Symbol() {
        symbolMap.put('}', '{');
        symbolMap.put(')', '(');
        symbolMap.put(']', '[');
    }

    public boolean validSymbol(String fileName) throws Exception {
        FileInputStream fs = new FileInputStream(new File(fileName));
        int size = fs.available();

        for (int i = 0; i < size; i++) {
            char c = (char) fs.read();
            // 如果是开放符号，则入栈
            if (openingSymbols.contains(c)) stack.push(c);
            // 如果是封闭符号，则当栈空时返回false
            // 否则将出栈，如果出栈的元素不是对应的开放符号，则返回false
            else if (closingSymbols.contains(c)) {
                if (stack.isEmpty()) throw new Exception("Unexpect symbol");
                else {
                    char top = stack.pop();
                    if (symbolMap.get(c) != top) {
                        throw new Exception("Unexpect symbol");
                    }
                }
            }
        }
        // 在读完文件之后，如果栈不为空，则返回false
        if (!stack.isEmpty()) {
            throw new Exception(String.format("Unexpect '%c' opposing symbol", stack.peek()));
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Symbol symbol = new Symbol();
        boolean res = symbol.validSymbol("C:\\tmp\\HelloWorld.java");
        System.out.println(symbol.stack);
        System.out.println(res);
    }

}
