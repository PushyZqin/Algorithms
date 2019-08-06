# Question

![UTOOLS1556337555682.png](https://i.loli.net/2019/04/27/5cc3d398530a9.png)

示例：

![UTOOLS1556339197375.png](https://i.loli.net/2019/04/27/5cc3da0168b9f.png)

# Solution

用`emptyCnt`表示手中空瓶数量，`fullCnt`用空瓶兑换汽水数量，`res`表示小张喝到的汽水数量。

需要注意的是，当空瓶数量等于`2`，可以向老板借一瓶空瓶然后喝了之后还有一个空瓶可以归还老板，但是小于`2`则不行：

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        if (n == 0) break;

        int res = solution(n);
        System.out.println(res);
    }
}

public static int solution(int n) {
    int emptyCnt = n, fullCnt = 0;
    int res = 0;

    while (emptyCnt != 0) {
        if (emptyCnt >= 3) { // 手中空瓶 >= 3
            int cnt = emptyCnt / 3;
            emptyCnt %= 3;
            fullCnt += cnt;

            if (fullCnt != 0) {
                emptyCnt += fullCnt;
                res += fullCnt;
                fullCnt = 0;
            }
        } else if (emptyCnt == 2){ // 手中剩余空瓶数 = 2，可以向老板借一个空瓶，然后再归还一个空瓶
            res++;
            break;
        } else {  // 手中剩余的空瓶数 <= 2，无法再借空瓶还了
            break;
        }
    }
    return res;
}
```