package offer;

public class GetNumberOfK {

    // 线性查找，时间复杂度为 O(n)
//    public int GetNumberOfK(int[] arr, int k) {
//        int res = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            while (i < arr.length && arr[i] == k) {
//                res++;
//                i++;
//            }
//        }
//        return res;
//    }

    /**
     * 二分查找，找出第一个K和最后一个K的位置，则出现的次数 n = last - first + 1
     */
    public int GetNumberOfK(int[] arr, int k) {
        int number = 0;

        if (arr != null && arr.length > 0) {
            int first = getFirstK(arr, k, 0, arr.length - 1);
            int last = getLastK(arr, k, 0, arr.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    /**
     * 寻找第一个值为k的数
     */
    private int getFirstK(int[] arr, int k, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == k) {
            // 如果中间数字是K，并且前一个元素不是K，则当前mid即为第一个K
            // 或者当mid为0时，也即第一个K
            if ((mid > 0 && arr[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                // 否则第一个K位于前半段
                end = mid - 1;
            }
        } else if (arr[mid] > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(arr, k, start, end);
    }

    /**
     * 寻找最后一个值为k的数
     */
    public int getLastK(int[] arr, int k, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == k) {
            // 如果中间数是K，并且后一个元素不是K，即当前mid为最后一个K
            // 或者当mid为最后一个元素时，也即最后一个K
            if ((mid < arr.length - 1 && arr[mid + 1] != k) || mid == arr.length - 1) {
                return mid;
            } else { // 否则第一个K位于后半段
                start = mid + 1;
            }
        } else if (arr[mid] < k) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastK(arr, k, start, end);
    }

    public static void main(String[] args) {
        GetNumberOfK s = new GetNumberOfK();
        int res = s.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3}, 3);
        System.out.println(res);
    }

}
