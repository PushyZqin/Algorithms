package site.pushy.algorithms.apply.tree;

import site.pushy.algorithms.datastructure.tree.BinaryTree;

import java.util.Stack;

/**
 * @author Pushy
 * @since 2019/4/4 9:21
 */
public class ExpressionTree {

    class Node {
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

    public void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public void midOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        midOrderTraverse(node.left);
        System.out.print(node.data + " ");
        midOrderTraverse(node.right);
    }

    public void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        ExpressionTree eTree = new ExpressionTree();

        Node root = eTree.create("123*+45*6+7*+");

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
