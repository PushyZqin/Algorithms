package site.pushy.algorithms.leetcode.problemset;

import java.util.PriorityQueue;

/**
 * @author Pushy
 * @since 2019/1/31 11:07
 */
public class KthLargest {

    PriorityQueue<Integer> queue;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        size = k;

        for (Integer num : nums)
            add(num);
    }

    public int add(int val) {
        if (queue.size() < size)
            queue.offer(val);
        else {
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }

}
