import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        final int invalidValue = 101;
        ListNode fackHead = new ListNode(invalidValue);
        fackHead.next = head;
        ListNode Mov = head;
        ListNode preMov = fackHead;
        while (Mov != null) {
            if (isEqual(Mov, preMov)) {
                preMov.next = Mov.next;
            } else {
                preMov = preMov.next;
            }
            Mov = preMov.next;
        }
        return head;

    }
    public boolean isEqual(ListNode node1, ListNode node2) {
        if (node1.val == node2.val) {
            return true;
        }
        return false;
    }
}