# 1905: 我爱数学 威力加强版

## Question

![UTOOLS1556503985839.png](https://i.loli.net/2019/04/29/5cc65db3a9734.png)

示例：

```java
输入：
1 -4 4
1 -3 2

输出：
2.00
1.00 2.00
```

## Solution

需要考虑多种情况，特别重要的是：无穷解的情况即`a == 0 && b == 0 && c == 0`：

```java
public static String solution(double a, double b, double c) {
    double s = b * b - (4 * a * c);

    if (a == 0 && b != 0 && c != 0) {  // 一元一次方程，一个根
        double root = -c / b;
        return String.format("%.2f", root);
    }
    else if (a == 0 && b == 0 && c == 0) {  // 无穷解
        return "Unlimited Answers.";
    }
    else if (a == 0 && b == 0 && c != 0) {  // 无根
        return "No Solution.";
    }
    else if (s < 0 && a != 0) {  // △ < 0，无解
        return "No Solution.";
    }
    else if (s == 0 && a != 0) {  // 两个相同的根
        double root = (-b) / (2 * a);
        return String.format("%.2f", root);
    }
    else if (s > 0 && a != 0) {  // 两个不同的根
        StringBuilder sb = new StringBuilder();
        double e = Math.sqrt(s);
        double r1 = (-b - e) / (2 * a);
        double r2 = (-b + e) / (2 * a);

        sb.append(String.format("%.2f", Math.min(r1, r2))).append(" "); // small
        sb.append(String.format("%.2f", Math.max(r1, r2)));             // big
        return sb.toString();
    }
    else {
        return "";
    }
}
```