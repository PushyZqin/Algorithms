---
export_on_save:
  html: true
---
    
# [771. 宝石与石头](https://leetcode-cn.com/problems/jewels-and-stones/submissions/)
    
## Question

给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

示例 1:

```java
输入: J = "aA", S = "aAAbbbb"
输出: 3
```

示例 2:

```java
输入: J = "z", S = "ZZ"
输出: 0
```

注意:

- S 和 J 最多含有50个字母。
- J 中的字符不重复。

## Solution

这题没什么好说的。。。 就算你用暴力破解也可以beat `93.99%`   😂😂😂 

```java
public int numJewelsInStones(String J, String S) {
    int sum = 0;
    for (int i = 0; i < J.length(); i++) {
        for (int j = 0; j < S.length(); j++) {
            if (J.charAt(i) == S.charAt(j))
                sum++;
        }

    }
    return sum;
}
```

既然归属于**哈希表**的范围，那我们就用哈希表来解决：

```java
public int numJewelsInStones(String J, String S) {
    Set<Character> set = new HashSet<>();
    for (char ch : J.toCharArray())
        set.add(ch);

    int res = 0;
    for (int i = 0; i < S.length(); i++) {
        if (set.contains(S.charAt(i))) res++;
    }
    return res;
}
```

又或者？！🤔

```java
public int numJewelsInStones2(String J, String S) {
    int res = 0;
    int[] map = new int[100];

    for (int i = 0; i < J.length(); i++) {
        map[J.charAt(i) - 'A'] = 1;
    }

    for (int i = 0; i < S.length(); i++) {
        if (map[S.charAt(i) - 'A'] != 0) res++;
    }
    return res;
}
```