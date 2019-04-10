# 167. 两数之和 II - 输入有序数组

## Question

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

- **返回的下标值（index1 和 index2）不是从零开始的。**
- 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

示例:

```java
输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
```

## Solution

### 暴力破解法

该题如果使用的是双循环的暴力破解法来实现，虽然容易理解，但是算法执行的效率非常的低：

```java
public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == target) {
                retrun new int[]{i + 1, j + 1}
            }
        }
    }
    return new int[]{0, 0};
}
```

### 双指针

我们可以使用双指针来优化，当满足`numbers[start] + numbers[end] == target`则迭代结束。

如果和小于目标值时，`start`指针向后移动一位（和会增大）；如果和大于目标值时，`end`指针向前一位（和会减小）。

```java
public static int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    int start = 0, end = numbers.length - 1;

    while (start < end) {
        if (numbers[start] + numbers[end] == target) {
            res[0] = start + 1;
            res[1] = end + 1;
            return res;
        } else if (numbers[start] + numbers[end] < target) {
            start++;
        } else { // numbers[start] + numbers[end] > target
            end--;
        }
    }
    return res;
}
```