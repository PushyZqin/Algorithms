package offer;

/**
 * @author pushy zheng
 * @since 2019/8/2
 */
public class MaxSubPlus {

    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int sum = 0;

        for (int num : array) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubPlus maxPlus = new MaxSubPlus();

        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(maxPlus.FindGreatestSumOfSubArray(arr));
    }
}
