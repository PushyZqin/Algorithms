package nowcoder.crazy_queue;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/17 9:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int res = solution(arr, n);
            System.out.println(res);
        }
    }

    private static int solution(int[] arr, int n) {
        Arrays.sort(arr);

        int res = 0;
        int l = 0, r = n - 2;
        int[] nums = new int[n];
        int mid = n / 2;

        nums[mid] = arr[n - 1];
        int idx = 1;
        while (l < mid) {
            nums[mid - idx] = arr[l];
            l++;
            idx++;
        }

        System.out.println(Arrays.toString(nums));

        return -1;
    }

}