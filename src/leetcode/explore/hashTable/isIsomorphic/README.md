# [205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/submissions/) 

## Question

给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

```java
输入: s = "egg", t = "add"
输出: true
```

示例 2:

```java
输入: s = "foo", t = "bar"
输出: false
```

示例 3:

```java
输入: s = "paper", t = "title"
输出: true
```

说明:

- 你可以假设 s 和 t 具有相同的长度。

## Solution

### 解法一

使用一个哈希表来记录两个字符串中某个字符的映射记录，同时遍历两个字符串：

- 如果哈希表中包含了`s`中的某个字符，且映射的字符不与对应的`t`上的字符相等，则不是同构字符串。
- 如果哈希表中包含了`s`中的某个字符，但是却有`t`上的相同位置上字符的映射，则不是同构字符串。这是多对一的情况，如`s = ab, t = aa`的情况。

否则，将对应位置上的字符添加到哈希表的映射记录当中：

```java
public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char sc = s.charAt(i);
        char tc = t.charAt(i);

        if (map.containsKey(sc) && map.get(sc) != tc) {
            return false;
        }
        if (!map.containsKey(sc) && map.containsValue(tc)) {
            return false;
        }
        map.put(sc, tc);
    }
    return true;
}
```

### 解法二

从题中可以得出，每个字符要求一对一的映射关系。根据该特点，我们使用两个哈希表分别记录`s`和`t`中字符的出现情况（最近一次匹配成功的位置 + 1）。

初始化两个`256`大小的数字（默认全部为`0`），分别遍历两个字符串，从其中分别取出一个字符并在哈希表中查找其值，若不相等而返回`false`，若相等，则将其值更新为`i + 1`（区别已经被更新了）：

```java
public boolean isIsomorphic2(String s, String t) {
    int[] map1 = new int[256];
    int[] map2 = new int[256];

    for (int i = 0; i < s.length(); i++) {
        char sc = s.charAt(i), tc = t.charAt(i);
        if (map1[sc] != map2[tc]) return false;

        map1[sc] = i + 1;
        map2[tc] = i + 1;
    }
    return true;
}
```