# 67. 二进制求和

## Question

给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

```java
输入: a = "11", b = "1"
输出: "100"

```

示例 2:

```java
输入: a = "1010", b = "1011"
输出: "10101"
```

## Solution

根据二进制的相加规则，当前位相加再`%2`则为结果，进位则`/2`。

根据这个规则，我们遍历两个子串，从后往前，将每一位相加，结果加入`result`，最后反转输出。

```java
public String addBinary2(String a, String b) {
    StringBuilder res = new StringBuilder();
    int la = a.length() - 1;
    int lb = b.length() - 1;
    int carry = 0;

    while (la >= 0 || lb >= 0) {
        int sum = carry;
        if (la >= 0) {
            sum += (a.charAt(la--) - '0');
        }
        if (lb >= 0) {
            sum += (b.charAt(lb--) - '0');
        }
        res.append(sum % 2);  // 相加结果
        // 进位，如果是1那么carry=0，如果是2则要进位给下面一位+1
        carry = sum / 2;
    }
    if (carry != 0) res.append(1);  // 都相加完了，还要进位的情况
    return res.reverse().toString();
}
```

这里学到了一个操作**两个不同长度字符串的技巧**：

```java
int la = a.length() - 1;
int lb = b.length() - 1;

while (la >= 0 || lb >= 0) {
    if (la >= 0) {
        // 当字符串a没遍历完处理的逻辑
    }
    if (lb >= 0) {
        // 当字符串b没遍历完处理的逻辑
    }
}
```