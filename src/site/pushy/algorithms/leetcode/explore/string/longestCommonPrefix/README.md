# 14. 最长公共前缀

## Question

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

```java
输入: ["flower","flow","flight"]
输出: "fl"

```
示例 2:

```java
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

```
说明:

所有输入只包含小写字母 a-z 。

## Solution

### 简单解法

第一种比较容易理解的解法是先找到字符串数组中长度最小的字符串，然后开始从`0`往后截取子串，即`[0, 1)`、`[0, 2)` ...

每次截取出子串之后，都通过`startsWith()`方法判断数组中其他元素是否是以该子串开始：

```java
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    String str = strs[0];
    for (String s : strs) { // 找到最短的字符串
        if (s.length() < str.length()) {
            str = s;
        }
    }

    String res = "";
    for (int i = 1; i < str.length() + 1; i++) {
        String prefix = str.substring(0, i);

        boolean flag = true;
        for (int j = 0; j < strs.length; j++) {
            if (!strs[j].startsWith(prefix)) { // 判断是否有某一个前缀的子串没有
                flag = false;
            }
        }
        // 代表所有的字符串都有该前缀子串
        if (flag) res = prefix;
    }
    return res;
}
```

### 水平扫描法

另一种方法通过水平扫描法，先将数组首位`strs[0]`假设为最长的公共前缀。然后遍历字符串数组，当某个元素不满足该前缀时，将假设的前缀变量`prefix`从后往前截取一个字符重新比较。直到满足该前缀，或者`prefix`被截取为空字符串，则说明它们没有公共的前缀。

```java
public String longestCommonPrefix2(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}
```

### 二分法

>这个想法是应用二分查找法找到所有字符串的公共前缀的最大长度 L。 算法的查找区间是 (0 \ldots minLen)(0…minLen)，其中 minLen 是输入数据中最短的字符串的长度，同时也是答案的最长可能长度。 每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个。算法进行的过程中一共会出现两种可能情况：
S[1...mid] 不是所有串的公共前缀。 这表明对于所有的 j > i S[1..j] 也不是公共前缀，于是我们就可以丢弃后半个查找区间。
S[1...mid] 是所有串的公共前缀。 这表示对于所有的 i < j S[1..i] 都是可行的公共前缀，因为我们要找最长的公共前缀，所以我们可以把前半个查找区间丢弃。

![](https://leetcode-cn.com/media/original_images/14_lcp_binary_search.png)

解法如下：

```java
public String longestCommonPrefix3(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    int midLen = Integer.MAX_VALUE;  // 输入数据中最短的字符串的长度
    for (String str : strs) {
        midLen = Math.min(midLen, str.length());
    }
    int low = 1;
    int high = midLen;

    while (low <= high) {
        int mid = (low + high) / 2;
        if (isCommonPrefix(strs, mid))
            low = mid + 1;
        else
            high = mid - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len) {
    String str = strs[0].substring(0, len);
    for (String s : strs) {
        if (!s.startsWith(str)) return false;
    }
    return true;
}
```