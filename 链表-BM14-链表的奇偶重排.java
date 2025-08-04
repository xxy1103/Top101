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
    public ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode mainMov = head;
        ListNode oddMov = oddHead;
        ListNode evenMov = evenHead;
        oddOrEvenJudger judger = new oddOrEvenJudger();
        while(mainMov != null){
            if(judger.isOdd()){
                oddMov.next = mainMov;
                oddMov = oddMov.next;
            }
            else{
                evenMov.next = mainMov;
                evenMov = evenMov.next;
            }
            mainMov = mainMov.next;
        }
        oddMov.next = evenHead.next;
        evenMov.next = null;
        return oddHead.next;
    }
    public class oddOrEvenJudger{
        private int index = 0;

        public boolean isOdd(){
            index++;
            if(index % 2 != 0){
                return true;
            }
            else{
                return false;
            }
            
        }
    }
}