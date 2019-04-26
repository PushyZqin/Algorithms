---
export_on_save:
  html: true
---

# [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

## Question

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

```java
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

说明：

- 所有输入均为小写字母。
- 不考虑答案输出的顺序。

## Solution

> 众所周知，哈希映射可以很好地按键分组信息。但是我们不能直接使用原始字符串作为键。我们必须设计一个合适的键来呈现字母异位词的类型。例如，有字符串 “eat” 和 “ate” 应该在同一组中。但是 “eat” 和 “act” 不应该组合在一起。
> 
>1. 属于同一组的所有值都将映射到同一组中。
>2. 需要分成不同组的值不会映射到同一组。
>
> 此过程类似于设计哈希函数，但这是一个本质区别。哈希函数满足第一个规则但可能不满足第二个规则。但是你的映射函数应该满足它们。
> 
> 在上面的示例中，我们的映射策略可以是：对字符串进行排序并使用排序后的字符串作为键。也就是说，“eat” 和 “ate” 都将映射到 “aet”。

解法如下：

```java
public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String newStr = String.valueOf(chars);

        if (map.containsKey(newStr)) {
            map.get(newStr).add(str);
        } else {
            List<String> value = new ArrayList<>();
            value.add(str);
            map.put(newStr, value);
        }
    }

    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        res.add(entry.getValue());
    }
    return res;
}
```

上面是不规范的写法，对结合框架不熟练使用的结果。。。 下面才是正确的姿势：

```java
public List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        String w = new String(chars);
        List<String> list = map.getOrDefault(w, new ArrayList<>());
        list.add(str);
        map.put(w, list);
    }
    return new ArrayList<>(map.values());
}
```