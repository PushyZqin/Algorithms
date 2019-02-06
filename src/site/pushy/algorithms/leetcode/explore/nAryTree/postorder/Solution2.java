package site.pushy.algorithms.leetcode.explore.nAryTree.postorder;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/2/1 11:20
 */
public class Solution2 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> ansStack = new Stack<>();

        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ansStack.push(root);
            for (Node child : root.children) {  // 将该结点的子结点都放入stack中
                stack.push(child);
            }
        }
        /* 将ansStack的所有元素出栈并加入到List当中，即为遍历的结果 */
        while (!ansStack.empty()) {
            res.add(ansStack.pop().val);
        }
        return res;

    }

}