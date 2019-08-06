package leetcode.explore.bst.BSTIterator;

import leetcode.explore.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/1/30 17:18
 */
public class BSTIterator {

    private List<Integer> valList;
    private int position = 0;

    public BSTIterator(TreeNode root) {
        valList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            valList.add(cur.val);
            cur = cur.right;
        }
    }

    /** @return the next smallest number */
    public int next() {
        int res = valList.get(position);
        position++;
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return position < valList.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        BSTIterator iterator = new BSTIterator(root);
//        iterator.next();    // 返回 3
//        iterator.next();    // 返回 7
//        iterator.hasNext(); // 返回 true
//        iterator.next();    // 返回 9
//        iterator.hasNext(); // 返回 true
//        iterator.next();    // 返回 15
//        iterator.hasNext(); // 返回 true
//        iterator.next();    // 返回 20
//        iterator.hasNext(); // 返回 false

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
