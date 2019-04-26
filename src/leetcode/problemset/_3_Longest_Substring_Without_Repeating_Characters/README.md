---
export_on_save:
  html: true
---
    
# [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/)
    
## Question

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

```java
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例 2:

```java
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

示例 3:

```java
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

## Solution

### 解法一

最开始的想法是用哈希表来记录字符最近一次出现的位置，`count`用于记录当前的子串的长度。

然后遍历字符串：

- 当该字符存在于哈希表则说明之前出现过该字符，即该子串重复，因此将`i`指针指向该字符最近一次出现的位置。然后对`count`与`max`取最大值，并将`count`重置为`0`，清空哈希表；

- 相反，用哈希表记录当前字符出现的位置`i`，并自增`count`。

```java
public int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) return s.length();

    Map<Character, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (map.containsKey(ch)) {
            i = map.get(ch);
            if (count > max) max = count;
            count = 0;
            map.clear();
        } else {
            map.put(ch, i);
            count++;
        }
    }
    return Math.max(count, max);
}
```

执行效率不太理想：

![UTOOLS1555923828211.png](https://i.loli.net/2019/04/22/5cbd83757de8e.png)


### 滑动窗口

该题最优的解法是运用滑动窗口，下面是滑动窗口的解释：

>滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)（左闭，右开）。

我们可以使用 `HashSet` 将字符存储在当前窗口 `[i, j)`（最初 `j = i`）中，这样就可以**用 `O(1)` 的时间来完成对字符是否在当前的子字符串中的检查。**

 然后我们向右侧滑动索引 `j`，如果它不在 `HashSet` 中，我们会继续滑动 `j`。直到 `s[j]` 已经存在于 `HashSet` 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 `i` 开头。如果我们对所有的 `i` 这样做，就可以得到答案。

 ```java
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();

    int res = 0, i = 0, j = 0;
    while (i < n && j < n) {
        if (!set.contains(s.charAt(j))) { // 当不再哈希集合中时，继续滑动j
            set.add(s.charAt(j));
            j++;
            // j - i即在此之前的无重复的最长子串
            // 并将与res的最大值重新复制给res
            res = Math.max(res, j - i);
        } else {
            set.remove(s.charAt(i));
            i++;
        }
    }
    // 此时，我们找到的没有重复字符的最长字符串将会以索引i开头
    return res;
}
 ```

 示意图如下（原图来自[五分钟学算法](https://juejin.im/post/5cbd13d7f265da03612ee746)）：

 ![](https://user-gold-cdn.xitu.io/2019/4/22/16a42956ee355d52?imageslim)

 更详细的滑动窗口优化解答可以看[3. 无重复字符的最长子串](https://leetcode-cn.com/articles/longest-substring-without-repeating-characters/)