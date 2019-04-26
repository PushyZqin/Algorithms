---
export_on_save:
  html: true
---
    
# [290. 单词模式](https://leetcode-cn.com/problems/word-pattern/)
    
## Question

![UTOOLS1556080884113.png](https://i.loli.net/2019/04/24/5cbfe8f5f1e2c.png)

## Solution

不难，用哈希表来记录模式中每一个字母对一的单词即可：

```java
public boolean wordPattern(String pattern, String str) {
    String[] strs = str.split(" ");
    if (strs.length != pattern.length()) return false;
    if (str.isEmpty() && pattern.isEmpty()) return true;

    Map<Character, String> map = new HashMap<>();
    for (int i = 0; i < pattern.length(); i++) {
        char pc = pattern.charAt(i);
        String sc = strs[i];

        if (map.containsKey(pc)) { // 查找哈希表的映射表能否和单词对应
            String val = map.get(pc);
            if (!val.equals(sc)) return false;
        } else if (map.containsValue(sc)) { // 排除掉多对一的情况
            return false;
        } else {
            map.put(pc, sc);
        }
    }
    return true;
}
```
