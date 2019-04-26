---
export_on_save:
  html: true
---

# [844. 比较含退格的字符串](https://leetcode-cn.com/problems/backspace-string-compare/)

## Quesiton

给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 `#` 代表退格字符。

![UTOOLS1556095421749.png](https://i.loli.net/2019/04/24/5cc021bec4126.png)

提示：

- `1 <= S.length <= 200`
- `1 <= T.length <= 200`
- S 和 T 只含有小写字母以及字符 '#'。
 
## Solution

```java
public boolean backspaceCompare(String S, String T) {
    return getStack(S).equals(getStack(T));
}

private Stack<String> getStack(String tokens) {
    Stack<String> res = new Stack<>();

    for (Character ch : tokens.toCharArray()) {
        if (ch == '#') {
            if (!res.isEmpty()) res.pop();
        } else {
            res.push(ch.toString());
        }
    }
    return res;
}
```