---
export_on_save:
  html: true
---

# [383. 赎金信](https://leetcode-cn.com/problems/ransom-note/)

## Question

给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。

(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

注意：

你可以假设两个字符串均只含有小写字母。

```java
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
```

## Solution

遍历`ransomNote`的字符数组，每次遍历都去查找`ransomNote`字符串中是否有相同的字符，如果找到将该字符设置为空字符，继续下次的查找：

```java
public boolean canConstruct(String ransomNote, String magazine) {
    char[] chars = magazine.toCharArray();
    for (char ch : ransomNote.toCharArray()) {
        boolean flag = false;
        for (int i = 0, length = chars.length; i < length; i++) {
            if (chars[i] == ch) {
                flag = true;
                chars[i] = '\u0000';
                break;
            }
        }
        if (!flag) return false;
    }
    return true;
}
```