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
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode pMov = pHead;
        for(int i = 0; i<k; i++){
            if(pMov == null){
                return null;
            }
            pMov = pMov.next;
        }
        ListNode mov = pHead;
        while(pMov != null){
            pMov = pMov.next;
            mov = mov.next;
        }
        return mov;

    }
}