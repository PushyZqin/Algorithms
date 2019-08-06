package leetcode.problemset._257_Binary_Tree_Paths;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

import java.util.*;

/**
 * @author Pushy
 * @since 2019/5/5 16:12
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        findPath(root, "", res);
        return res;
    }

    public void findPath(TreeNode root, String path, List<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) { // 到达根结点，说明走完一条路径
            res.add(path + root.val);
        }
        String p = path + root.val + "->";
        findPath(root.left, p, res);
        findPath(root.right, p, res);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("1,2,3,null,5,null,null");
//        TreeNode root = TreeUtil.deserialize("1,2,3");

        Solution solution = new Solution();
        List<String> res = solution.binaryTreePaths(root);
        System.out.println("res：" + res);
    }

}