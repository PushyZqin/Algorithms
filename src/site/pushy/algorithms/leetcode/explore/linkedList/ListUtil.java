package site.pushy.algorithms.leetcode.explore.linkedList;

/**
 * @author Pushy
 * @since 2019/1/5 16:59
 */
public class ListUtil {

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        ListNode p = head;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append("->");
            }
            p = p.next;
        }

        sb.append("]");
        return sb.toString();
    }

}
