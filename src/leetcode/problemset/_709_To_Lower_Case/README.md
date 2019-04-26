---
export_on_save:
  html: true
---

# 709. 转换成小写字母

## Question

实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。

示例 1：

```java
输入: "Hello"
输出: "hello"
```

示例 2：

```java
输入: "here"
输出: "here"
```

## Solution

先吐个槽，第一次有答案达成一致题目！ 做了一天的题，看到这么简单的着实欣慰呢！ :-)

![TIM截图20190412211733.png](https://i.loli.net/2019/04/12/5cb090575c321.png)

这题考察的想必就是字符中大小写`char`值的转换，算法很简单，遍历字符数组，当字符是大写(满足`ch >= 'A' && ch <= 'Z'`)时，由ASCII表可知：将该字符加上32即可转换为小写：

```java
public String toLowerCase(String str) {
    StringBuilder sb = new StringBuilder();
    for (char ch : str.toCharArray()) {
        if (ch >= 'A' && ch <= 'Z') { // 大写字母
            ch += (char) (ch + 32);  // 转换为小写
        }
        sb.append(ch);
    }
    return sb.toString();
}
```

表如下：

![TIM截图20190412212456.png](https://i.loli.net/2019/04/12/5cb091b0e3260.png)

之前遇到的很多都有考字符的操作，下面是一些操作数字字符时的一些操作。

**判断是数字字符**：

```java
if (ch >= '0' && ch <= '9') {
    ...
}
```

**将数字字符转换为int数字**：

```java
char ch = '9'
int num = ch - '30'   // int value 9
```