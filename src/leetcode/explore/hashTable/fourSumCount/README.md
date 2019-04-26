# [454. 四数相加 II](https://leetcode-cn.com/explore/learn/card/hash-table/207/conclusion/828/)

## Question

给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 `(i, j, k, l)` ，使得 `A[i] + B[j] + C[k] + D[l] = 0`。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 `0 ≤ N ≤ 500` 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

```java
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
```

## Solution

如果给定的每个元组长度较小，通过暴力破解很容易可以解出，时间复杂度为`O(n^4)`：

```java
public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int res = 0;
    int n = A.length;

    for (int i = 0; i < n; i++) {  // a
        for (int j = 0; j < n; j++) { // b
            for (int k = 0; k < n; k++) { // c
                for (int l = 0; l < n; l++) {  // d
                    if (A[i] + B[j] + C[k] + D[l] == 0) {
                        res++;
                    }
                }
            }
        }
    }
    return res;
}
```

但是题中给出说明：长度在`0 ≤ N ≤ 500`内。因此使用暴力破解肯定会`TLE`，和[1. 两数之和](https://github.com/pushyzheng/Algorithms/tree/master/src/site/pushy/algorithms/leetcode/problemset/_1_Two_Sum)一样，我们可以**借助哈希表来优化嵌套循环。**

具体思路是先双循环遍历数组`A`与`B`，将两个数组中各元素相加的和放入到哈希表中，值为**相同的和出现的个数**；接着双循环遍历`C`与`D`，求出两个数组个元素相加的和并取反，然后**判断取反的值是否存在于哈希表中**，则值为这两个和相加为`0`的个数：

```java
public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;

    for (int a : A) { // 将AB各元素的和添加到哈希表中
        for (int b : B) {
            int sum = a + b;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }

    for (int c : C) {
        for (int d : D) {
            int sum = - (c + d);  // CD相加的和取反
            if (map.containsKey(sum)) {
                res += map.get(sum);
            }
        }
    }
    return res;
}
```