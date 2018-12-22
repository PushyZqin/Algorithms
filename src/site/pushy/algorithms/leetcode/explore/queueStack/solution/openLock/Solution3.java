package site.pushy.algorithms.leetcode.explore.queueStack.solution.openLock;

import java.util.*;

/**
 * @author Pushy
 * @since 2018/111/17 111:37
 */
public class Solution3 {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if (dead.contains(start) || dead.contains(target)) {
            return -1;
        }

        Queue<String> queue1 = new LinkedList<>();  // 用来存放当前遍历的节点
        Queue<String> queue2 = new LinkedList<>();  // 用来存放所有的相邻子节点
        int step = 0;
        queue1.offer(start);
        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            if (cur.equals(target)) {
                return step;
            }

            List<String> nexts = getNexts(cur);
            // 遍历所有的相邻子节点，将未访问过的添加到queue2中
            for (String next : nexts) {
                if (!dead.contains(next) && !visited.contains(next)) {
                    queue2.add(next);
                    visited.add(next);
                }
            }
            // 当遍历的这一层遍历完成之后，步数加1，并且将存放这一层所有相邻子节点的queue2全部添加到queue1
            // 并清除queue2的所有元素
            if (queue1.isEmpty()) {
                step++;
                queue1 = queue2;  // queue1.addAll(queue2)
                queue2 = new LinkedList<>();  // queue2.clear()
            }
        }

        return -1;
    }

    // 获得相邻的子节点，对四个轮盘分别做+1和-1的操作，共有八种情况（八个相邻子节点）
    private List<String> getNexts(String cur) {

        List<String> nexts = new LinkedList<>();
        for (int i = 0; i < cur.length(); ++i) {
            char ch = cur.charAt(i);

            char newCh = ch == '0' ? '9' : (char)(ch - 1);
            StringBuilder builder = new StringBuilder(cur);
            builder.setCharAt(i, newCh);
            nexts.add(builder.toString());

            newCh = ch == '9' ? '0' : (char)(ch + 1);
            builder = new StringBuilder(cur);
            builder.setCharAt(i, newCh);
            nexts.add(builder.toString());
        }

        return nexts;
    }

    public static void main(String[] args) {

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        Solution3 solution3 = new Solution3();
        int res = solution3.openLock(deadends, target);

        System.out.println("res = " + res);
    }


}
