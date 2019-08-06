package offer;

import leetcode.explore.linkedList.ListNode;

import java.util.ArrayList;

public class PrintListFromTail {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        printList(listNode, res);
        return res;
    }

    private void printList(ListNode root, ArrayList<Integer> res) {
        if (root == null) return;
        printList(root.next, res);
        res.add(root.val);
    }

}
