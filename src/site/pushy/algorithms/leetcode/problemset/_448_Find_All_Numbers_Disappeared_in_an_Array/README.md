---
export_on_save:
  html: true
---

# 448. 找到所有数组中消失的数字

## Question

给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

```java
输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
```

## Solution

这题与 [1002. 查找常用字符](https://github.com/pushyzheng/Algorithms/tree/master/src/site/pushy/algorithms/leetcode/problemset/_1002_Find_Common_Characters) 查找类题目类似，可以用开辟一个新的数组`count`来在顺序的位置中记录数组中各个元素出现的个数。

然后遍历`count`数组，如果出现的次数为`0`，说明在`[1, n]`的范围中丢失。

```java
public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> list = new ArrayList<>();
    int[] count = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
        count[nums[i] - 1]++;
    }
    for (int i = 0; i < nums.length; i++) {
        if (count[i] == 0) list.add(i + 1);
    }
    return list;
}
```

对于`[4, 3, 2, 7, 8, 2, 3, 1]` 示例来说，各个元素出现的个数为：

```java
count => [1, 2, 2, 1, 0, 0, 1, 1]
//        1  2  3  4  5  6  7  8 
```

说明可以查找出`5、 6` 元素是丢失的。