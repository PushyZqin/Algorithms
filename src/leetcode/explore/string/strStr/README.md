---
export_on_save:
  html: true
---

# 28. 实现strStr()

## Question

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

```java
输入: haystack = "hello", needle = "ll"
输出: 2
```
示例 2:

```java
输入: haystack = "aaaaa", needle = "bba"
输出: -1
```

说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

## Solution

该题需要首先知道一点的是，目标结果值可能出现的最大下标是为多少？即：`haystack`字符长度 - `needle`字符长度

### 解法一

从`0`开始遍历到最大的下标值，当`haystack`中某个字符会等于`needle`的第一个字符时，开始进行查找：判断它们对应的字符是否相等，即需要满足`haystack.charAt(i + j) != needle.charAt(j)`条件，并用`flag`来标识是否在`haystack`中找到了目标子串：

```java
public static int strStr(String haystack, String needle) {
    int ll = haystack.length();
    int ls = needle.length();
    if (ll < ls) return -1;
    if (ls == 0) return 0;

    for (int i = 0; i < ll - ls + 1; i++) {
        if (haystack.charAt(i) == needle.charAt(0)) {
            boolean flag = true;
            for (int j = 0; j < ls; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                }
            }
            if (flag) return i;
        }
    }
    return -1;
}
```

### 解法二

第二种方法同样是从`0`开始遍历到最大的下标值，然后每次遍历截取`haystack`字符串的`[i, i + needle长度]`的子串，将其和`needle`比较是否相等，如果相等则`i`为目标值：

```java
public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) return 0;

    int ll = haystack.length();
    int ls = needle.length();
    if (ll < ls) return -1;

    int max = haystack.length() - needle.length();
    for (int i = 0; i < max + 1; i++) {
        // 通过截取出的haystack的与needle等长度的子串
        // 将它和needle进行比较是否相等
        String temp = haystack.substring(i, i + needle.length());
        if (temp.equals(needle)) {
            return i;
        }
    }
    return -1;
}
```

以`hello`示例，4次遍历将会截取子串`he`、`el`、`ll`、`lo`，第三个子串符合题意，则返回的索引值为`2`。


### 解法三

参考的解法高效率的解法，代码如下：

```java
public int strStr(String haystack, String needle) {
    char[] source = haystack.toCharArray();
    char[] target = needle.toCharArray();
    int targetCount = target.length;

    if (targetCount == 0) return 0;

    char first = target[0];
    int max = source.length - targetCount; // // 目标值会出现的最大的数

    for (int i = 0; i <= max; i++) {
        // 查找第一个字符串
        if (source[i] != first) {
            while (++i <= max && source[i] != first) ;
        }
        // 查找第一个字符串之后，开始查找剩余的字符是否相同
        if (i <= max) {
            int j = i + 1;
            int end = j + targetCount - 1;
            for (int k = 1; j < end && source[j] == target[k]; j++, k++) ;
            if (j == end) {
                // 找到所有的目标子串
                return i;
            }
        }
    }
    return -1;
}
```

