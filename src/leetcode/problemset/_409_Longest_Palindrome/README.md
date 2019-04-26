---
export_on_save:
  html: true
---
    
# [409. 最长回文串](https://leetcode-cn.com/problems/longest-palindrome/)
    
## Question

给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

```java
输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
```

## Solution

**分析**

回文字符串有两种类型，一种是由**成对的字符**组成如`abba`，另一种则是由**成对字符 + 单一字符**组成，如`abcba`。知道了这个规则，对于每个字符的出现次数来说：

- 偶数：全部都可以参与组成回文字符串；
- 奇数：参与字符串的个数为：`(n / 2) * 2`。

最后如果是第一种规则的话，回文串的长度需要再加`1`。

**解法**

我们可以运用哈希表的[按键聚合](https://leetcode-cn.com/explore/learn/card/hash-table/205/practical-application-hash-map/814/)，记录字符串中每个字符出现的次数。用`exitsSingle`来标识是哪一种组成的规则：

```java
public int longestPalindrome(String s) {
    if (s.length() < 1) return s.length();

    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    List<Integer> vals = new ArrayList<>(map.values());

    int res = 0;
    boolean exitsSingle = false;    // 是否存在单一的字符
    for (int i = 0; i < vals.size(); i++) {
        int val = vals.get(i);
        if (val % 2 == 0) {
            res += val;
        } else { // 不是2的倍数，如3、5、7
            res += (val / 2) * 2;
            exitsSingle = true;
        }
    }
    return res + (!exitsSingle ? 0 : 1);
}
```

执行效率如下，但是似乎不太理想 🤔🤔🤔：

![UTOOLS1556094190836.png](https://i.loli.net/2019/04/24/5cc01cf14a85d.png)

我们可以用数组替代哈希表来进行优化：

```java
public int longestPalindrome2(String s) {
    if (s.length() < 1) return s.length();

    char[] chars = s.toCharArray();
    int[] arr = new int['z' - 'A' + 1];
    for (int i = 0; i < chars.length; i++) {  // 记录字符的出现次数
        arr[chars[i] - 'A']++;
    }

    boolean exitsSingle = false;
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] % 2 == 0) {
            res += arr[i];
        } else { // 不是2的倍数，如3、5、7
            res += (arr[i] / 2) * 2;
            exitsSingle = true;
        }
    }
    return res + (!exitsSingle ? 0 : 1);
}
```

用空间替换了时间的效率：

![UTOOLS1556094341622.png](https://i.loli.net/2019/04/24/5cc01d878d6fd.png)