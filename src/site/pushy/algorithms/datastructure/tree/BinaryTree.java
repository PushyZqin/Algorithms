package site.pushy.algorithms.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 二叉树Java代码实现
 *
 * @author Pushy
 * @since 2018/111/12 16:41
 */
public class BinaryTree {

    static class Node {

        public Object data;
        public Node left;
        public Node right;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 测试创建二叉树
     */
    public static Node createTree() {
        Node root = new Node("A");
        Node BNode = new Node("B");  // 创建左节点
        Node CNode = new Node("C"); // 创建右节点
        Node DNode = new Node("D");
        Node ENode = new Node("E");
        Node FNode = new Node("F");
        Node GNode = new Node("G");
        Node HNode = new Node("H");
        Node INode = new Node("I");

        DNode.left = GNode; DNode.right = HNode;
        BNode.left = DNode;

        ENode.right = INode;
        CNode.left = ENode; CNode.right = FNode;

        root.left = BNode; root.right = CNode;
        return root;
    }

    /**
     * 先序顺序递归创建二叉树结构
     */
    public static Node preOrderCreate(Node node) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        if (value != 0) {
            node = new Node(value);
            System.out.println("请输入左子结点的值：");
            node.left = preOrderCreate(node.left);
            System.out.println("请输入右子结点的值：");
            node.right = preOrderCreate(node.right);
        } else {
            node = null;
        }
        return node;
    }

    /**
     * 递归实现先序遍历二叉树
     */
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 递归实现中序遍历二叉树
     */
    public static void midOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        midOrderTraverse(node.left);
        System.out.print(node.data + " ");
        midOrderTraverse(node.right);
    }

    /**
     * 递归实现后序遍历二叉树
     */
    public static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 深度优先遍历，相当于先序遍历。使用栈非递归实现二叉树的遍历
     */
    public static void DFS(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            // 取出栈顶元素，判断是否有子节点
            Node temp = nodes.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null) {
                nodes.push(temp.right);
            }

            if (temp.left != null) {
                nodes.push(temp.left);
            }
        }
    }

    /**
     * 广度优先遍历：使用队列非递归的方式实现二叉树的遍历
     */
    public static void BFS(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node temp = nodes.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            if (temp.right != null) {
                nodes.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = BinaryTree.createTree();
//        Node root = BinaryTree.preOrderCreate(null);

        System.out.println("先序遍历：");
        BinaryTree.preOrderTraverse(root);

        System.out.println("\n中序遍历：");
        BinaryTree.midOrderTraverse(root);

        System.out.println("\n后序遍历：");
        BinaryTree.postOrderTraverse(root);

        System.out.println("\n深度优先遍历：");
        BinaryTree.DFS(root);

        System.out.println("\n广度优先遍历：");
        BinaryTree.BFS(root);
    }

}
