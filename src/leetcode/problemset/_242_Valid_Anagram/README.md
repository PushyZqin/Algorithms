---
export_on_save:
  html: true
---
    
# [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
    
## Question

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:

```java
输入: s = "anagram", t = "nagaram"
输出: true
```

示例 2:

```java
输入: s = "rat", t = "car"
输出: false
```

## Solution

从示例中可以看出，字母异位词是指两个单词包含相同的字母，但是次序不同。例如`silent`与`listen`则是字母异位词。

所以只需要**判断两个字符串是否所有的字符都是相同的即可**，具体做法如下：首先初始化一个长度为`26`的数组（因为英文字母有`26`个），遍历字符串`s`并用数组的值来记录各个字母出现的个数；再遍历字符串`t`并将指定的字母位置减一（相当于抵消的操作）。最后遍历数组`arr`，如果全部为`0`则代表所有字母都是相同的：

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] arr = new int[26];

    for (int i = 0; i < s.length(); i++) {
        arr[s.charAt(i) - 'a']++;
        arr[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) return false;
    }
    return true;
}
```