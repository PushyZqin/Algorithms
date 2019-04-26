# [387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)

## Question

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

```java
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
```

## Solution

### 哈希表

通过[按键聚合](https://leetcode-cn.com/explore/learn/card/hash-table/205/practical-application-hash-map/814/)的应用，维护一个哈希映射，其键是字符，而值是相应字符的计数器。每次迭代一个字符时，我们只需将相应的值加`1`。

最后遍历字符串，找到第一个值为`1`的索引值：

```java
public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) return -1;

    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < s.length(); i++) {
        if (map.get(s.charAt(i)) == 1) return i;
    }
    return -1;
}
```

执行的效率似乎不怎么理想：🙄 🙄 🙄 

![UTOOLS1555851081851.png](https://i.loli.net/2019/04/21/5cbc674f0c582.png)

我们可以使用数组来模拟哈希表的效果：

```java
public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) return -1;

    int[] arr = new int[26];
    for (char ch : s.toCharArray()) {
        arr[ch - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
        if (arr[s.charAt(i) - 'a'] == 1) {
            return i;
        }
    }
    return -1;
}
```

效率得到极大的提升：  😁😁😁

![UTOOLS1555853060985.png](https://i.loli.net/2019/04/21/5cbc6f0977535.png)


### 解法二

通过遍历`a ~ z`字符，当`s.indexOf(i) == s.lastIndexOf(i)`能够说明该字符串存在该字符仅一个，找到最小索引那个元素即可：

```java
public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) return -1;

    int res = Integer.MAX_VALUE;
    for (char i = 'a'; i <= 'z'; i++) {
        int idx = s.indexOf(i);
        if (idx != -1 && idx == s.lastIndexOf(i)) {
            res = Math.min(res, idx);  // compare&find mix
        }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
}
```

![UTOOLS1555853294489.png](https://i.loli.net/2019/04/21/5cbc6ff2733a5.png)