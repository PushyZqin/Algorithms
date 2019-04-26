---
export_on_save:
  html: true
---

# [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)

## Question

给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

示例 1:

```java
输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
```

示例 2:

```java
输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
```

注意:

- nums1和nums2中所有元素是唯一的。
- nums1和nums2 的数组大小都不超过1000。

## Solution

遍历num2，通过辅助栈将num2中的每个元素下一个出现的最大元素存入哈希表中。实现的方式和[每日温度](https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/879/)类似：

```java
private Map<Integer, Integer> getMap(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
        while (!stack.isEmpty() && arr[i] > stack.peek()) {
            int top = stack.pop();
            map.put(top, arr[i]);
        }
        stack.push(arr[i]);
    }
    return map;
}
```