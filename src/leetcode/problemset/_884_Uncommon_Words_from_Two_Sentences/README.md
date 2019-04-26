---
export_on_save:
  html: true
---
    
# [884. 两句话中的不常见单词](https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/)
    
## Question

给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）

如果一个单词在**其中一个句子中只出现一次，在另一个句子中却没有出现**，那么这个单词就是不常见的。

返回所有不常用单词的列表。

您可以按任何顺序返回列表。

示例 1：

```java
输入：A = "this apple is sweet", B = "this apple is sour"
输出：["sweet","sour"]
```

示例 2：

```java
输入：A = "apple apple", B = "banana"
输出：["banana"]
```

提示：

- 0 <= A.length <= 200
- 0 <= B.length <= 200
- A 和 B 都只包含空格和小写字母。

## Solution

该题比较巧妙的解法用一个哈希表来存储两个字符串相加后每个单词的出现个数，然后找到只出现一次的单词，即为题中所说的**不常见的单词**：

```java
public String[] uncommonFromSentences(String A, String B) {
    Map<String, Integer> count = new HashMap();
    for (String word : A.split(" "))
        count.put(word, count.getOrDefault(word, 0) + 1);
    for (String word : B.split(" "))
        count.put(word, count.getOrDefault(word, 0) + 1);

    List<String> res = new ArrayList<>();
    for (String word : count.keySet()) {
        if (count.get(word) == 1) res.add(word);  // 不常用单词
    }
    return res.toArray(new String[res.size()]); // to String array
}
```