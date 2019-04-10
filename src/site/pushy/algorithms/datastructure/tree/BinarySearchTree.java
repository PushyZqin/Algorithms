package site.pushy.algorithms.datastructure.tree;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

/**
 * 二叉搜索树实现
 *
 * @author Pushy
 * @since 2019/4/3 20:50
 */
public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public boolean contains(int e, Node root) {
        if (root == null) return false;

        int res = Integer.compare(e, root.data);
        if (res > 0)
            return contains(e, root.right);
        else if (res < 0)
            return contains(e, root.left);
        else
            return true;
    }

    public Node find(int e, Node root) {
        if (root == null) return null;

        if (e > root.data)
            return find(e, root.right);
        else if (e < root.data)
            return find(e, root.left);
        else return root;
    }

    public Node findMin(Node root) {
        if (root == null) return null;

        if (root.left == null)
            return root;
        else
            return findMin(root.left);
    }

    public Node findMax(Node root) {
        if (root != null) {
            while (root.right != null)
                root = root.right;
        }
        return root;
    }

    public Node insert(Node root, int e) {
        if (root == null) {
            root = new Node(e);
        } else {
            if (e < root.data)
                root.left = insert(root.left, e);
            else if (e > root.data)
                root.right = insert(root.right, e);
            // else
        }
        return root;
    }

    public Node delete(Node root, int e) {
        if (root == null) return root;

        if (e > root.data)
            root.right = delete(root.right, e);
        else if (e < root.data)
            root.left = delete(root.left, e);
        else if (root.left != null && root.right != null) {
            // 当删除的结点的左右子结点都不为空时
            // 用其中序后继节点或者前驱节点来替换，再删除该目标节点
            Node cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            root.data = cur.data;  // 与找到的结点交换值
            //root.data = findMin(root.right).data;
            root.right = delete(root.right, root.data);  // 删除目标结点
        } else
            // 当删除的结点左右子结点都为空，或者其中一个为空的情况
            // 如果左结点不为空，则将该结点设置为左结点，否则设置为右结点
            root = (root.left != null) ? root.left : root.right;
        return root;
    }


    public static void main(String[] args) {
        Node root = new Node(6);

        BinarySearchTree searchTree = new BinarySearchTree();

        int[] arr = {6, 2, 8, 1, 4, 3, 7};
        for (int i = 0; i < arr.length; i++) {
            searchTree.insert(root, arr[i]);
        }

        System.out.println(root.left);
        System.out.println(root.right);

        System.out.println("max is :" + searchTree.findMax(root));
        System.out.println("mix is :" + searchTree.findMin(root));

        searchTree.delete(root, 8);

        System.out.println("max is :" + searchTree.findMax(root));
    }

}
