---
export_on_save:
  html: true
---
    
# [658. 找到 K 个最接近的元素](https://leetcode-cn.com/problems/find-k-closest-elements/)
    
## Question

给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。**如果有两个数与 x 的差值一样，优先选择数值较小的那个数**。

示例 1:

```java
输入: [1,2,3,4,5], k=4, x=3
输出: [1,2,3,4]
```
 
示例 2:

```java
输入: [1,2,3,4,5], k=4, x=-1
输出: [1,2,3,4]
```

说明:

1. k 的值为正数，且总是小于给定排序数组的长度。
2. 数组不为空，且长度不超过 104
3. 数组里的每个元素与 x 的绝对值不超过 104

更新(2017/9/19):

这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。

## Solution

该题先通过二分法寻找到等于`x`或者靠近`x`的索引，然后通过线性查找扩大`l`与`r`的范围，即`[l + 1, r)`所围成的元素即目标的数组的值：

```java
public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> res = new ArrayList<>();
    if (arr.length == 0) return res;

    int l = 0, r = arr.length;
    while (l + 1 < r) { // 二分法查找
        int mid = l + (r - l) / 2;
        if (arr[mid] > x) r = mid;
        else if (arr[mid] < x) l = mid;
        else {
            l = mid;
            r = mid + 1;
        }
    }

    while (k > 0) {
        if (l < 0) {  // 当左边已经找完时
            r++;
        } else if (r >= arr.length) { // 当右边已经找完时
            l--;
        } else {
            if (arr[r] - x < x - arr[l]) { // 计算与左右两边的距离
                r++;
            } else {
                l--;
            }
        }
        k--;
    }
    for (int i = l + 1; i < r; i++) { // [l + 1, r)即返回列表中的所有元素
        res.add(arr[i]);
    }
    return res;
}
```