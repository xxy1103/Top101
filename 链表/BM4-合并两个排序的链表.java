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
     * @param pHead1 ListNode类 
     * @param pHead2 ListNode类 
     * @return ListNode类
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode mov1 = pHead1;
        ListNode af_mov1 = pHead1 != null? pHead1.next:null;
        ListNode mov2 = pHead2;
        ListNode af_mov2 = pHead2 != null? pHead2.next:null;
        ListNode head = new ListNode(1);
        ListNode mov = head;
        while(true){
            if(mov1 == null){
                mov.next = mov2;
                break;
            }
            else if(mov2 == null){
                mov.next = mov1;
                break;
            }
            if(mov1.val < mov2.val){
                mov.next = mov1;
                mov1 = af_mov1;
                if(af_mov1 != null){
                    af_mov1 = af_mov1.next;
                }
            }   
            else{
                mov.next = mov2;
                mov2 = af_mov2;
                if(af_mov2 != null){
                    af_mov2 = af_mov2.next;
                }
            }
            mov = mov.next;
        }
        return head.next;

    }
}