---
export_on_save:
  html: true
---
    
# [389. 找不同](https://leetcode-cn.com/problems/find-the-difference/)
    
## Question

给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

示例:

```java
输入：
s = "abcd"
t = "abcde"

输出：
e

解释：
'e' 是那个被添加的字母。
```

## Solution

### 1. 哈希表

需要注意的是**所给的字符串是有可能包含相同的字符的**。

与 [242. 有效的字母异位词](https://github.com/pushyzheng/Algorithms/blob/master/src/site/pushy/algorithms/leetcode/problemset/_242_Valid_Anagram) 的操作方式相似，用数组替代哈希表实现，用数组的值来记录字符串`s`中字符的次数。然后遍历字符串`t`，当对应位置上为`0`时说明没有足够的字符能够“抵消”：

```java
public char findTheDifference(String s, String t) {
    int[] arr = new int[26];

    for (char ch : s.toCharArray()) {
        arr[ch - 'a']++;
    }
    for (char ch : t.toCharArray()) {
        if (arr[ch - 'a'] == 0)
            return ch;
        else
            arr[ch - 'a']--;
    }
    return '\u0000';   // 没有不同的字符
}
```

### 2. 异或操作

与 [136. 只出现一次的数字](https://github.com/pushyzheng/Algorithms/blob/master/src/site/pushy/algorithms/leetcode/problemset/_136_Single_Number) 类似，可以用异或进行巧解：

```java
public char findTheDifference2(String s, String t) {
    s = s + t;
    char[] c = s.toCharArray();

    int ch = 0;
    for (int i = 0; i < c.length; i++) {
        ch ^= c[i];  // 运用异或的性质，数字与自身异或结果为0
    }
    return (char) ch;
}
```