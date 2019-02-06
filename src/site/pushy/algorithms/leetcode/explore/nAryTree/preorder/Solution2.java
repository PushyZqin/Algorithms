package site.pushy.algorithms.leetcode.explore.nAryTree.preorder;

import site.pushy.algorithms.leetcode.explore.nAryTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/2/1 10:53
 */
public class Solution2 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            /* 由于使用的是栈先进后出的结构，因此需要将子节点倒序加入到栈中，也就是最右的结点在栈底 */
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

}