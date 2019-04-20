---
export_on_save:
  html: true
---

# 1002. 查找常用字符

## Question

给定仅有小写字母组成的字符串数组 A，返回列表中的**每个字符串中都显示的全部字符（包括重复字符）组成的列表**。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

示例 1：

```java
输入：["bella","label","roller"]
输出：["e","l","l"]
```

示例 2：

```java
输入：["cool","lock","cook"]
输出：["c","o"]
```
 
提示：

```java
1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母
```

## Solution

该题能想到的简单的方法是：

- 将首元素字符串`A[0]`切割为单个字符串存入`res`列表中；
- 遍历字符串列表，查找下一个单词的每一个字母是否存在于`res`中：
    - 如果存在：将该字母从`res`中删除，并将该字母添加到`tempList`中
    - 如果不存在：继续遍历
- 完成一个单词的查找后，将`tempList`赋值给`res`，重复步骤2。

```java
public List<String> commonChars(String[] A) {
    List<String> res = new ArrayList<>();
    for (Character str : A[0].toCharArray()) res.add(str.toString());

    for (int i = 0; i < A.length; i++) {
        String string = A[i];
        List<String> tempList = new ArrayList<>();
        for (Character ch : string.toCharArray()) {
            String s = ch.toString();
            if (res.contains(s)) { // 存在
                int idx = res.indexOf(s);
                res.remove(idx);
                tempList.add(s);
            }
        }
        res = tempList;
    }
    return res;
}
```

该题的思路是先假设所有的单词都包含`A[0]`的所有字母，然后在每次遍历单词的字母时，都去查找该字母是否真的包含了假设中存在的字母，如果没有就从假设列表（`res`）中删除该字母。并在每次遍历完一个单词之后，更新新的假设列表。但是这种解决的效率较低：

![TIM截图20190411193145.png](https://i.loli.net/2019/04/11/5caf25b40dba9.png)

参考了分布图表中较为靠前的一个解法：

```java
public List<String> commonChars2(String[] A) {
    List<String> res = new ArrayList<>();

    if (A == null || A.length <= 0) {
        return res;
    }
    // 用Integer.MAX_VALUE填充数组
    int[] chars = new int[26];
    for (int i = 0; i < 26; i++) {
        chars[i] = Integer.MAX_VALUE;
    }
    for (String a : A) {
        char[] content = a.toCharArray();
        int[] charsTemp = new int[26];
        // 统计每个字符串 各个字符数出现的次数
        for (char c : content) {
            charsTemp[c - 97]++; // c-97即该字母在数组中的索引值
        }
        System.out.println(Arrays.toString(charsTemp) + " <= charsTemp");
        // 取小值
        for (int i = 0; i < 26; i++) {
            if (charsTemp[i] < chars[i]) {
                chars[i] = charsTemp[i];
            }
        }
        System.out.println(Arrays.toString(chars) + " <= res");
    }
    // 添加到结果列表中
    for (int i = 0; i < chars.length; i++) {
        for (int k = 0; k < chars[i]; k++) {
            res.add((char) (i + 'a') + "");
        }
    }
    return res;
}
```

例如对于输入示例`["cool","lock","cook"]`来说，打印的数据为：

```java
[0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] <= charsTemp
[0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] <= res
[0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] <= charsTemp
[0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] <= res
[0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] <= charsTemp
[0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] <= res
res：[c, o]
```

其实原理也大致类似，用`chars`来记录所有单词中每个字母所出现的个数。