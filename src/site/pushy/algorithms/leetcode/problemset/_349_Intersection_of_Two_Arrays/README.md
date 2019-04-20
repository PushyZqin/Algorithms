---
export_on_save:
  html: true
---

# [349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/)

## Question

![UTOOLS1555760484637.png](https://i.loli.net/2019/04/20/5cbb05671b84a.png)

## Solution

想不到什么优解，只能将两个数组添加到哈希集合中，然后判断是否存在其中一个集合来求出相交的元素：

```java
public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int num : nums1) set1.add(num);
    for (int num : nums2) set2.add(num);

    List<Integer> res = new LinkedList<>();
    for (Integer num : set1) {
        if (set2.contains(num)) {
            res.add(num);
        }
    }

    int[] arr = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
        arr[i] = res.get(i);
    }
    return arr;
}
```