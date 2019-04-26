---
export_on_save:
  html: true
---
    
# [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)
    
## Question

给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

- 字母异位词指字母相同，但排列不同的字符串。
- 不考虑答案输出的顺序。

示例 1:

```java
输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
```

示例 2:

```java
输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
```

## Solution

### 哈希表 + 滑动窗口

同样是哈希表的应用，用数组来替代哈希表，记录字符的出现个数。声明一个`dict`记录字符串`p`各字符出现的次数，用于之后与`s`的子串比较。数组`cur`则是用于记录当前滑动窗口中的子串各字符出现的次数。每次滑动窗口移动时，都**判断两个数组元素是否相同即是否为异位词**，如果相等添加到结果列表中即可：

```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    if (s.length() < p.length()) return res;
    int left = 0, right = 0;

    int[] dict = new int[26], cur = new int[26];
    for (int i = 0; i < p.length(); i++) {
        dict[p.charAt(i) - 'a']++;
        cur[s.charAt(right++) - 'a']++;
    }
    if (equal(dict, cur)) res.add(left);

    while (right < s.length()) {
        cur[s.charAt(right++) - 'a']++;
        cur[s.charAt(left++) - 'a']--;
        if (equal(dict, cur)) { // s子串与p是否为异位词
            res.add(left);
        }
    }
    return res;
}

// 判断两个数组对应位置上的元素是否全部相等
private boolean equal(int[] a, int[] b) {
    for (int i = 0; i < 26; i++) {
        if (a[i] != b[i]) return false;
    }
    return true;
}
```