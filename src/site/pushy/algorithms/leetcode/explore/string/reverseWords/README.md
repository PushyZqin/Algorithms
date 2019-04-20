# 151. 翻转字符串里的单词

## Question

给定一个字符串，逐个翻转字符串中的每个单词。

示例:  

```java
输入: "the sky is blue",
输出: "blue is sky the".
```

示例 2：

```java
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
```

示例 3：

```java
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

说明:

- 无空格字符构成一个单词。
- 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
- 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

## Solution

把字符串以`" "`进行分割，然后倒序遍历分割后的字符串数组，当元素不为空字符串时，将其添加到`sb`中，即能得到结果值：

```java
public static String reverseWords(String s) {
    if (s == null) return "";
    s = s.trim();
    if (s.isEmpty()) return s;

    String[] strings = s.split(" ");
    StringBuilder sb = new StringBuilder();

    for (int i = strings.length - 1; i >= 0; i--) {
        if (!strings[i].isEmpty()) {
            sb.append(strings[i]).append(" ")
        }
    }
    // 处理特殊的尾元素
    return sb.toString().trim();
}
```