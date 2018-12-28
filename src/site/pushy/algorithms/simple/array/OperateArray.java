package site.pushy.algorithms.simple.array;

public class OperateArray {

    static int findMaxElement(int[] array) {
        int max = array[0];  // 取出第一个值作为最大值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static int countAverage(int[] array) {
        int n = array.length;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / n;
    }

    static int[] reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(findMaxElement(array));
        System.out.println(countAverage(array));
        for (int i : reverse(array)) {
            System.out.println(i);
        }
    }

}
