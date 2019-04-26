---
export_on_save:
  html: true
---
    
# [204. 计数质数](https://leetcode-cn.com/problems/count-primes/)
    
## Question

统计所有小于非负整数 n 的质数的数量。

示例:

```java
输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
```

## Solution

### 1. 暴力破解

通过遍历`1 ~ n`，判断每个数能不能被大于`1`小于自身的所有数整除，如果能则说明该数不是质数：

```java
public int countPrimes0(int n) {
    int res = 0;
    for (int i = 2; i < n; i++) {
        boolean flag = true;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) { // 如果能被整除，则表明此数不是素数
                flag = false;
                break;
            }
        }
        if (flag) res++;
    }
    return res;
}
```

我们可以再进行优化，只需要判断每个数能不能被大于`1`小于自身开方即`Math.sqrt(i)`即可整除即可：

```java
public int countPrimes0(int n) {
    int res = 0;
    for (int i = 2; i < n; i++) {
        boolean flag = true;
        int k = (int) Math.sqrt(i);
        for (int j = 2; j <= k; j++) {
            if (i % j == 0) { // 如果能被整除，则表明此数不是素数
                flag = false;
                break;
            }
        }
        if (flag) res++;
    }
    return res;
}
```

这是因为：例如当`i = 8`时，它的开方值小于`3`，并且`3*2< 8 < 3*3`。所以如果整数`8`能被整除的话那么除数应该为小于`3`大于`1`的整数。又或者`i = 40`的时候`40 < 7*7`，所以只要40不能被大于1小于等于7的数整除，就可以断定40不是质数。

不过这种暴力破解还是有TLE的可能，更优解参考下面的埃拉托斯特尼筛法。


### 2. 埃拉托斯特尼筛法

[埃拉托斯特尼筛法](https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95) 是用来找出一定范围内所有素数的算法，其算式原理为：

> 给出要筛数值的范围n，找出根号`n`以内的素数`[p1, p2, ..., pk]`先用2去筛，即把2留下，把2的倍数剔除掉；再用下一个素数，也就是3筛，把3留下，把3的倍数剔除掉；接下去用下一个素数5筛，把5留下，把5的倍数剔除掉；不断重复下去......。

这是因为：**如果一个数是另一个数的倍数，那这个数肯定不是质数**。借助这个性质我们就可以用很快的效率来解题了：

```java
public int countPrimes(int n) {
    boolean[] prime = new boolean[n];
    Arrays.fill(prime, true);

    for (int i = 2; i < n; i++) {
        if (prime[i]) {
            for (int j = i * i; j < n; j += i) {
                // 将i的2倍、3倍、4倍...都标记为非素数 
                prime[j] = false;
            }
        }
    }

    int res = 0;
    for (int i = 2; i < n; i++) {
        if (prime[i]) res++;
    }
    return res;
}
```

算法的图示为（图片来自[维基百科](https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95#/media/File:Sieve_of_Eratosthenes_animation.gif)）：

![](https://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif)