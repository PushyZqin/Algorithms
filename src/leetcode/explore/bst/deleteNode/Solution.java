package leetcode.explore.bst.deleteNode;

import leetcode.explore.binaryTree.TreeNode;

/**
 * @author Pushy
 * @since 2019/1/31 10:12
 */
public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        // 找到了目标结点
        else {
            /* 判断是否有一个子节点不存在，或者都不存在，那么我们就将root指向另一个节点 */
            if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            } else {
                /* 左右子结点都存在时，我们需要在右子树找到最小值，即右子树中最左下方的节点，
                然后将该最小值赋值给root，然后再在右子树中调用递归函数来删除这个值最小的节点 */
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                root.val = cur.val;
                root.right = deleteNode(root.right, cur.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int key = 3;

        Solution solution = new Solution();
        TreeNode res = solution.deleteNode(root, key);
        System.out.println("res：" + res.left);
    }

}