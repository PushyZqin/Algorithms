---
export_on_save:
  html: true
---

# [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/)

## Question

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

```java
输入: [2,2,1]
输出: 1
```

示例 2:

```java
输入: [4,1,2,1,2]
输出: 4
```

## Solution

### 1. 哈希表

使用哈希表很好理解，遍历数组**用表的值存储数字出现的个数**，然后再遍历哈希表找到值为`1`的键：

```java
public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) {
            return entry.getKey();
        }
    }
    return -1;
}
```

运行效率如下：

![TIM截图20190420184642.png](https://i.loli.net/2019/04/20/5cbaf8a388d86.png)

### 2. 数组查找

先对数组排序，然后遍历每次移动两个单位，并判断与前面一个元素是否相等，如果不相等则返回前面那个元素。

如果遍历完成之后还是没有结果，则说明只出现一次的数字为最后一个元素：

```java
public int singleNumber(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i += 2) {
        if (nums[i] != nums[i - 1]) {
            return nums[i - 1];
        }
    }
    return nums[nums.length - 1];
}
```

运行效率如下，感觉这题被异或求法霸占了 😑😑😑

![TIM截图20190420184629.png](https://i.loli.net/2019/04/20/5cbaf89eddb21.png)

### 3. 异或巧解

在Java中，`^`为按位异或运算符。如何运算呢？我们需要将十进制的数字转换为二进制，并且**如果相对应位值相同，则结果为0，否则为1**。

以`221`为例，在通过`2 ^ 2 ^ 1`运算之后的结果为`1`，刚好是只出现一次的数字，这是因为通过异或运算的特性是：**两个相同的数字进行异步操作的结果为0**：

```java
2 ->  0000 0010
^     |||| ||||
2 ->  0000 0010
=     |||| ||||
0 ->  0000 0000
^     |||| ||||
1 ->  0000 0001
=     |||| ||||
1 ->  0000 0001 
```

运行效率如下：

![TIM截图20190420185142.png](https://i.loli.net/2019/04/20/5cbaf9c75e00c.png)