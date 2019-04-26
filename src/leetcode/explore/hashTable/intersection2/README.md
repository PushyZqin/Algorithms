# [350. 两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/comments/)

## Question

给定两个数组，编写一个函数来计算它们的交集。

示例 1:

```java
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
```

说明：

- 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
- 我们可以不考虑输出结果的顺序。

进阶:

- 如果给定的数组已经排好序呢？你将如何优化你的算法？
- 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
- 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

## Solution

### 哈希表

这题同样可以用哈希表的按键聚合来解题：先遍历一遍`nums1`：用哈希表统计每个数字的出现次数；然后遍历`nums2`：如果元素存在，在哈希表的计数值减一，并添加到结果列表中：

```java
public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums1) { // 第一趟记录数字出现次数
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    List<Integer> res = new ArrayList<>();
    for (int num : nums2) { // 第二趟遍历
        if (map.containsKey(num) && map.get(num) != 0) {
            res.add(num);
            map.put(num, map.get(num) - 1);  // 减一
        }
    }
    // list to array
    int[] arr = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
        arr[i] = res.get(i);
    }
    return arr;
}
```

执行效率：

![UTOOLS1555855428405.png](https://i.loli.net/2019/04/21/5cbc7848049e6.png)


### 指针查找

先将两个数组排序，声明指针`i`指向`num1`，指针`j`指向`num2`，并用`count`来记录交集的个数。

遍历两个数组，判断两个指针所指向的元素三种情况：

- 相等时：则存在交集，用数组`res`来记录，并将两个指针同时往后移动一个单位；
- `i`指向的元素大于`j`指向的元素：只需要将`j`往后移动一个单位即可（**说明当前`j`指向的元素过小，需要往后寻找更大的数**）；
- `i`指向的元素小于`j`指向的元素：同理，只需要将`i`往后移动一个单位即可。

```java
public int[] intersect2(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int i = 0, j = 0;
    int[] res = new int[nums2.length];
    int count = 0;  // 记录交集的元素个数

    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
            res[count++] = nums1[i];
            i++;
            j++;
        } else if (nums1[i] > nums2[j]) {
            j++;
        } else {
            i++;
        }
    }
    return Arrays.copyOf(res, count);
}
```

最后通过`Arrays.copyOf`方法将`res`数组多余的切割，并返回新的数组结果。

执行效率：

![UTOOLS1555903551244.png](https://i.loli.net/2019/04/22/5cbd3440676dc.png)


## 学到了

这里学到了一个操作技巧就是题目需要返回一个`int[]`结果，但我们事先并不知道结果的长度，导致无法申请合理长度的新数组。

我们可以仿造解法二中的技巧，先声明一个可能最大长度的数组（这里最大的交集个数为`num2.length`），然后用一个计数变量来记录真正结果的个数，最后通过`Arrays`的`copyOf`方法来切割掉多余的部分。

```java
int[] arr = {2, 2, 0, 0, 0, 0};
int[] res = Arrays.copyOf(arr, 2);  // 仅保留2个元素
System.out.println(Arrays.toString(res));
// [2, 2]

// 如果复制的数组大于原来数组的长度，多余的部分将会用默认值填充
int[] arr2 = {2, 2};
int[] res2 = Arrays.copyOf(arr2, 5); 
System.out.println(Arrays.toString(res2));
// [2, 2, 0, 0, 0]
```