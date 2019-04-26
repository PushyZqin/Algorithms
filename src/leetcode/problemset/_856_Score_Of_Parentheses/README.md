---
export_on_save:
  html: true
---

# [856. 括号的分数](https://leetcode-cn.com/problems/score-of-parentheses/)

## Question

给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：

- () 得 1 分。
- AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
- (A) 得 2 * A 分，其中 A 是平衡括号字符串。

![UTOOLS1556095336655.png](https://i.loli.net/2019/04/24/5cc0216998e18.png)

提示：

- S 是平衡括号字符串，且只含有 ( 和 ) 。
- `2 <= S.length <= 50`