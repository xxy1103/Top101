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
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode detect = preHead;
        ListNode deletePreNode = preHead;
        for(int i = 0; i <= n; i++){
            detect = detect.next;
        }
        while(detect != null){
            detect = detect.next;
            deletePreNode = deletePreNode.next;
        }
        deletePreNode.next = deletePreNode.next.next;
        return preHead.next;
    }
}