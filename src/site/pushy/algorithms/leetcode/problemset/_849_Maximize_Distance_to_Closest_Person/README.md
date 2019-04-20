---
export_on_save:
  html: true
---

# 849. 到最近的人的最大距离

## Question

在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。

至少有一个空座位，且至少有一人坐在座位上。

亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。

返回他到离他最近的人的最大距离。

示例 1：

```java
输入：[1,0,0,0,1,0,1]
输出：2
解释：
如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
因此，他到离他最近的人的最大距离是 2 。 
```

示例 2：

```java
输入：[1,0,0,0]
输出：3
解释： 
如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
这是可能的最大距离，所以答案是 3 。
```

提示：

- 1 <= seats.length <= 20000
- seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。

## Solution

这题参考了讨论区中高票的解法，学习一下：

> 我们将有人的座位的下标记录到一个list中，剩下的事情就是要找一个点，距离list中某个元素的最大距离
以示例1为例，我们构造了一个list，为[0,4,6]，那么你想找的那个点的下标一定是在0-4和4-6之间，所以只需要求出他们之间的中点距离即可。 以示例2为例，我们构造了一个list，为[0]，那么你想找的那个店的下标一定在0-seats.length之间，依次比较即可。
所以我们可以将此题抽象出来，假设有一个seats数组，为[a0,a1,a2.....an]，其中有人的为i，j，k，那么我们要找的点就一定在0-i,i-j,j-k和k-seats.length之间，依次比较即可。

```java
public int maxDistToClosest(int[] seats) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < seats.length; i++) {
        if (seats[i] == 1) list.add(i);
    }

    int start = list.get(0);
    int end = seats.length - list.get(list.size() - 1) - 1;
    int max = Math.max(start, end);

    for (int i = 0; i < list.size() - 1; i++) {
        int temp = (list.get(i + 1) - list.get(i)) / 2;
        max = Math.max(temp, max);
    }
    return max;
}
```