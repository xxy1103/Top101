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
    public ListNode ReverseList (ListNode head) {
        // write code here
        ListNode pre_mov = null;
        ListNode mov = head;
        ListNode bre_mov = mov;
        if(bre_mov != null){
            bre_mov = bre_mov.next;
        }
        while(mov != null){
            mov.next = pre_mov;
            pre_mov = mov;
            mov = bre_mov;
            if(bre_mov != null){
                bre_mov = bre_mov.next;
            }
        }
        return pre_mov;
    }
}