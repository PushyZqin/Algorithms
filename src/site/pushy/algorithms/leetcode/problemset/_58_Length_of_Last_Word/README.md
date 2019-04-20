# 58. 最后一个单词的长度

## Question

给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:

```java
输入: "Hello World"
输出: 5
```

## Solution

不说了，没明白考察什么？！

```java
public int lengthOfLastWord(String s) {
    if (s == null || s.isEmpty()) return 0;

    String[] strings = s.split(" ");
    if (strings.length == 0)
        return 0;
    return strings[strings.length - 1].length();
}
```