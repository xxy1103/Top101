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

    ListNode mov;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        // write code here
        this.mov = head;
        return recursionJudgePail(head);
    }

    public boolean recursionJudgePail(ListNode recursionMov) {
        if (recursionMov == null) {
            return true;
        }
        if (recursionJudgePail(recursionMov.next)) {
            if (recursionMov.val == mov.val) {
                mov = mov.next;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }
}