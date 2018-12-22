package site.pushy.algorithms.leetcode.explore.queueStack.solution.numSquares;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 *
 * @author Pushy
 * @since 2018/111/13 19:15
 */
public class Solution {

    Set<Integer> visited = new HashSet<>();

    public int numSquares(int n) {
        int step = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.remove();
                if (cur == 0) { // 当前遍历到的节点时目标节点
                    return step;
                }
                Queue<Integer> neighbors = getNeighbors(cur);  // 获取相邻节点
                queue.addAll(neighbors);  // 将获取到的相邻节点队列集合全部添加到待处理队列当中
            }
            step++;
        }
        return -1;
    }

    /**
     * 获取cur节点的所有相邻节点，即获取：当前节点的值减去，小于它的所有完全平方数的差（结果必须大于0）的队列
     */
    private Queue<Integer> getNeighbors(Integer cur) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 1;
        while (count <= cur) {
            int sum = cur - (count * count);
            if (sum < 0) {
                break;
            }
            if (!visited.contains(sum)) {  // 判断是否被访问过
                visited.add(sum);
                queue.add(sum);
            }
            count++;
        }
        return queue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.numSquares(7168);
        System.out.println("res = " + res);
    }

}
