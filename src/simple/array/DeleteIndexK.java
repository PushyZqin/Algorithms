package simple.array;

import java.util.Arrays;

/**
 * 删除数组下标为k的元素
 *
 * @author Pushy
 * @since 2018/12/24 20:13
 */
public class DeleteIndexK {

    public static void solution(int[] array, int k) {
        for (int i = k; i < array.length; i++) {
            int last = array.length - 1;
            if (i == last) {
                array[last] = 0;   // 为了直观，这里姑且将空的元素设置为0
            }
            else {
                array[i] = array[i + 1];  // 将删除元素的后面元素全部往前移动一位
            }
        }

        /*for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }*/
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 26, 8, 28, 12, 3};

        DeleteIndexK.solution(array, 3);

        System.out.println(Arrays.toString(array));
    }

}