package site.pushy.algorithms.leetcode.problemset._933_Number_of_Recent_Calls;

/**
 * @author Pushy
 * @since 2019/4/7 21:30
 */
public class RecentCounter {

    int[] queue = new int[10000];

    int size = 0;
    int front = 0;
    int rear = 0;

    public RecentCounter() {
    }

    public int ping(int t) {
        queue[rear++] = t;
        size++;

        while (true) {
            if (t - queue[front] > 3000) {
                front++;
                size--;
            } else {
                break;
            }
        }
        return size;
    }

}
