package simple.array;

/**
 * 给你一个不重复的有序数组{0,1,2,3,....n}，其中有一个数字缺失，请把缺失的数字找出来
 * 例如：给定数组[0, 1, 3]，输出：2
 *
 * @author Pushy
 * @since 2018/12/24 20:58
 */
public class MissingNumber {

    /**
     * 由于题目告诉只缺少一个数字，所以用0~n的和 减去 数组的和，即为数组中缺少的数字
     *
     * @param nums
     */
    public static int solution(int[] nums) {
        int n = nums.length;
        int sum = n * (1 + n) / 2;   // 等差数列的前n项和：0~n的和

        int arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += nums[i];  // 数组的和
        }
        /* 将0~n（数组的长度）的和减去数组的和即为丢失的数字值 */
        return sum - arraySum;
    }

    /**
     * 比较笨的方法，通过一个辅助数组来实现
     */
    public static Integer solution1(int[] nums) {
        int randomNumber = 555555555;
        int[] newArrays = new int[nums.length + 1];

        for (int i = 0; i < newArrays.length; i++) {
            newArrays[i] = randomNumber; // 随意填充数组到新数组中
        }
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            newArrays[index] = 3333333;
        }
        /* 遍历新数组，只要还有值为 randomNumber，那么那个就是缺失的数字 */
        for (int i = 0; i < newArrays.length; i++) {
            if (newArrays[i] == randomNumber) {
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 7, 8};

        long start = System.nanoTime();

        int result = MissingNumber.solution1(array);
        System.out.println(result);

        long end = System.nanoTime();
        System.out.println("共花费总时间为：" + (end - start) + "ns");
    }

}