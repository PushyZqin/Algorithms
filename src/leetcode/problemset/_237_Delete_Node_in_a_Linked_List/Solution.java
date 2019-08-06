package leetcode.problemset._237_Delete_Node_in_a_Linked_List;

import leetcode.explore.linkedList.ListNode;
import leetcode.explore.linkedList.ListUtil;

/**
 * @author Pushy
 * @since 2019-2-4 09:46:28
 */
public class Solution {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;      // 将该结点的值设置为后继的值
        node.next = node.next.next;    // 删除后继结点
    }

    public static void main(String[] args) {
        ListNode root = ListUtil.getListByArray(new int[]{4, 5, 1, 9});

        Solution solution = new Solution();
        solution.deleteNode(root.next);
        System.out.println(ListUtil.toString(root));
    }

}