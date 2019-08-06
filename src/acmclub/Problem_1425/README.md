# 1425: 单挑 BOSS

## Question

![UTOOLS1556503882416.png](https://i.loli.net/2019/04/29/5cc65d4c8130c.png)

示例：

```java
输入：
5 3 2 2
0 0 0 0

输出：
Try Again
```

## Solution

本题给的一个关键条件为`1 <= h, a, b, k <= 10^9`，说明需要用`long`类型存储输入的值。读取输入代码输入如下：

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
        String line = scanner.nextLine();
        String[] arr = line.split(" ");
        long h = Long.parseLong(arr[0]);
        long a = Long.parseLong(arr[1]);
        long b = Long.parseLong(arr[2]);
        long k = Long.parseLong(arr[3]);

        if (h == 0 && a == 0 && b == 0 && k == 0) break;

        String res = solution(h, a, b, k);
        System.out.println(res);
    }
}
```

根据题意，我们分为以下情况：

- 开局一刀斩，攻击力大于等于BOSS血量：`a >= h`；

- 攻击力小于BOSS每回合回血的量，始终杀不死：`b >= a`；

- **K个回合掉的血量大于休息回合回血的量**，BOSS肯定会被慢慢磨死：`(a - b) * k > b`；

- 在未到达休息回合就已经over了：`h <= (a - b) * k`。

完整代码如下：

```java
public static String solution(long h, long a, long b, long k) {
    if (a >= h) return SUCCESS;  // 秒杀
    if (b >= a) return FAIL;     // 回血大于攻击力，肯定杀不死

    // K个回合掉的血量 > 休息回合回血的量，BOSS肯定会over
    if ((a - b) * k > b) return SUCCESS;

    // 在未到达休息回合就over了
    if (h <= (a - b) * k) return SUCCESS;

    return FAIL;
}
```