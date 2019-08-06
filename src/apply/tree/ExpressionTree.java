package apply.tree;

import leetcode.explore.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/4/4 9:21
 */
public class ExpressionTree {

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }



        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    /**
     * 通过后缀表达式来创建表达式树
     * @param tokens
     * @return
     */
    public Node create(String tokens) {
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < tokens.length(); i++) {
            char ch = tokens.charAt(i);
            if (Character.isDigit(ch)) {
                Node node = new Node(ch);
                stack.push(node);
            } else {
                Node node1 = stack.pop();
                Node node2 = stack.pop();
                Node newNode = new Node(ch);
                newNode.right = node1;
                newNode.left = node2;
                stack.push(newNode);
            }
        }
        if (stack.size() != 1) {
            throw new RuntimeException("The tokens is illegal");
        }
        return stack.pop();
    }

    public void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public void midOrderTraverse(Node root) {
//        if (root == null) return;
//
//        midOrderTraverse(root.left);
//        System.out.print(root.data + " ");
//        midOrderTraverse(root.right);

        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();

        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            sb.append(cur.data).append(" ");
            cur = cur.right;
        }
        System.out.println(sb.toString());
    }

    public void postOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        ExpressionTree eTree = new ExpressionTree();

        Node root = new Node('+');
        root.left = new Node('+');
        root.left.left = new Node('a');
        root.left.right = new Node('*');
        root.left.right.left = new Node('b');
        root.left.right.right = new Node('c');

        root.right = new Node('*');
        root.right.right = new Node('g');
        root.right.left = new Node('+');
        root.right.left.left = new Node('*');
        root.right.left.right = new Node('f');
        root.right.left.left.left = new Node('d');
        root.right.left.left.right = new Node('c');

        System.out.println("前缀表达式：");
        eTree.preOrderTraverse(root);
        System.out.println();

        System.out.println("中缀表达式：");
        eTree.midOrderTraverse(root);
        System.out.println();

        System.out.println("后缀表达式：");
        eTree.postOrderTraverse(root);
    }

}
