---
export_on_save:
  html: true
---

# [599. 两个列表的最小索引总和](https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/submissions/)

## Question

假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

示例 1:

```java
输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。
```

示例 2:

```java
输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
```

提示:

- 两个列表的长度范围都在 [1, 1000]内。
- 两个列表中的字符串的长度将在[1，30]的范围内。
- 下标从0开始，到列表的长度减1。
- 两个列表都没有重复的元素。

## Solution

本题没有什么难点，也想不到什么很好的解法。一样使用了哈希表来优化双循环（暴力破解），将时间复杂度降到`O(n)`。

第一趟遍历数组`list2`，建立起元素与下标的映射关系；第二趟遍历`list1`，寻找相同的餐馆索引总和最小数：

```java
public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list2.length; i++) {
        // 遍历，建立数组2的元素-下标映射
        map.put(list2[i], i);
    }

    int min = Integer.MAX_VALUE;
    List<String> res = new ArrayList<>();

    // 遍历数组1，寻找最小的索引总和
    for (int i = 0; i < list1.length; i++) {
        if (map.containsKey(list1[i])) {
            int idx = map.get(list1[i]);
            if (min >= idx + i) {
                min = idx + i;
                res.add(list1[i]);
            }
        }
    }
    String[] arr = new String[res.size()];
    return res.toArray(arr);
}
```