package leetcode.explore.queueStack.solution.numSquares;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 *
 * @author Pushy
 * @since 2018/11/13 19:15
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
                Integer temp = queue.remove();
                if (temp == 0) {
                    return step;
                }
                Queue<Integer> neighbors = getNeighbors(temp);
                queue.addAll(neighbors);
            }
            step++;
        }
        return -1;
    }

    private Queue<Integer> getNeighbors(Integer temp) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 1;
        while (count <= temp) {
            int sum = temp - (count * count);
            if (sum < 0) {
                break;
            }
            if (!visited.contains(sum)) {
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
