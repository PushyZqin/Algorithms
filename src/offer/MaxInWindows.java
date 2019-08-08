package offer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length) return result;

        int i = 0, j = size - 1;
        int max = 0, maxIdx = 0;  // 最大值和最大索引值

        for (int k = 0; k <= j; k++) {
            if (num[k] > max) {
                max = num[k];
                maxIdx = k;
            }
        }
        result.add(max);
        i++;
        j++;

        while (j < num.length) {
            if (i > maxIdx) { // 最大值过期，重新寻找当前窗口中的最大值
                max = num[i];
                for (int k = i; k <= j; k++) {
                    if (num[k] > max) {
                        max = num[k];
                        maxIdx = k;
                    }
                }
                result.add(max);
            } else {
                if (num[j] > max) {
                    result.add(num[j]);
                    max = num[j];
                    maxIdx = j;
                } else {
                    result.add(max);
                }
            }
            j++;
            i++;
        }
        return result;
    }

    /**
     * 通过双端队列来实现
     */
    public ArrayList<Integer> maxInWindows2(int[] nums, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums.length < size || size < 1) {
            return res;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();  // 存放元素的索引
        for (int i = 0; i < size; i++) {   // 处理第一个滑动窗口
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) { // 弹出不可能为最大值的元素
                queue.pollLast();
            }
            queue.addLast(i);
        }
        for (int i = size; i < nums.length; i++) {
            res.add(nums[queue.peekFirst()]);
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) { // 弹出不可能为最大值的元素
                queue.pollLast();
            }
            // 当前滑动窗口已经不包含队列首元素，说明该最大值已经过期，删除该元素
            if (!queue.isEmpty() && queue.peekFirst() <= (i - size)) {
                queue.pollFirst();
            }
            queue.addLast(i);
        }
        res.add(nums[queue.peekFirst()]);
        return res;
    }

    public static void main(String[] args) {
        MaxInWindows maxInWindows = new MaxInWindows();
//        int[] arr = new int[]{16, 14, 12, 10, 8, 6, 4};
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> result = maxInWindows.maxInWindows2(arr, 3);
        System.out.println(result);
    }

}
