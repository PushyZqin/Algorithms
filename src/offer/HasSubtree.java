package offer;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return false;
    }

    public static void main(String[] args) {
        TreeNode l1 = TreeUtil.deserialize("1,2,3,4,5,6,7");
        TreeNode l2 = TreeUtil.deserialize("2,4,5");

        HasSubtree s = new HasSubtree();
        boolean res = s.HasSubtree(l1, l2);
        System.out.println(res);
    }

}
