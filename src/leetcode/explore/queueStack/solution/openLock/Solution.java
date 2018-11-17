package leetcode.explore.queueStack.solution.openLock;

import java.util.*;

/**
 * @author Pushy
 * @since 2018/11/13 10:36
 */
public class Solution {

    public int openLock(String[] deadends, String target) {
        String start = "0000";

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(start)) return -1;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                for (int j = 0; j < 4; j++) { // 对于密码中的每一位做+1 -1的操作
                    for (int o : new int[]{-1, 1}) {
                        char[] chars = cur.toCharArray();
                        chars[j] = change(chars[j], o);
                        String temp = new String(chars);

                        if (temp.equals(target)) {
                            return res;
                        }

                        if (!dead.contains(temp) && !visited.contains(temp)) {
                            visited.add(temp);
                            queue.add(temp);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private char change(char c, int i) {
        if (1 == i) {
            return c == '9' ? '0' : (char) (c + i);
        } else {
            return c == '0' ? '9' : (char) (c + i);
        }
    }

    public static void main(String[] args) {

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        Solution solution = new Solution();
        int res = solution.openLock(deadends, target);

        System.out.println("res = " + res);
    }

}
