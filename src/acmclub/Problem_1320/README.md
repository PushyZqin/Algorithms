# 1320: 分苹果

## Question

![UTOOLS1556504814879.png](https://i.loli.net/2019/04/29/5cc660f11b1b5.png)

示例：

```java
输入：6
输出：6
```

## Solution

```java
public static int solution(int n) {
    // 当某个人手中的苹果数量在 0~3 之间只能分开下一个个人
    // 无法再从下一个人继续往下分，为递归的终止条件，直接返回分给下一个人的分法个数就行
    if (n == 0) return 0;

    if (n >= 1 && n <= 3) return 2; // 1~3个仅2中分法

    // 如果大于3，分法的个数有[n/2, 1]种
    int sum = 0;
    for (int i = n / 2; i >= 1; i--) {
        sum += solution(i);
    }
    return sum;
}
```