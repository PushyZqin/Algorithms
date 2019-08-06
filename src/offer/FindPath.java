package offer;

import leetcode.explore.binaryTree.TreeNode;
import leetcode.explore.binaryTree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null || target == 0) return res;

        find(root, target, path, res);
        return res;
    }

    private void find(TreeNode root, int target, List<Integer> path, ArrayList<ArrayList<Integer>> res) {
        path.add(root.val);

        if (root.left == null && root.right == null && root.val == target) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            find(root.left, target - root.val, path, res);
        }
        if (root.right != null) {
            find(root.right, target - root.val, path, res);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        FindPath solution = new FindPath();

        TreeNode root = TreeUtil.deserialize("1,2,3,4,5,4,6");
        ArrayList<ArrayList<Integer>> res = solution.FindPath(root, 8);
        System.out.println(res);
    }

}
