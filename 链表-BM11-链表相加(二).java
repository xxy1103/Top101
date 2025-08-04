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
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        ListNode preHead1 = new ListNode(0);
        preHead1.next = head1;
        ListNode preHead2 = new ListNode(0);
        preHead2.next = head2;
        ListNode mov1 = preHead1;
        ListNode mov2 = preHead2;
        int head1Substracthead2 = 0;
        while(mov1.next != null || mov2.next != null){
            if(mov1.next != null){
                mov1 = mov1.next;
                head1Substracthead2++;
            }
            if(mov2.next != null){
                mov2 = mov2.next;
                head1Substracthead2--;
            }
        } 
        System.out.println(head1Substracthead2);
        if(head1Substracthead2<0){   //head1比较短
            LinkAdd(preHead2,preHead1,-head1Substracthead2);
            if(preHead2.val == 0){
                return preHead2.next;
            }
            else{
                return preHead2;
            }
        }
        else{                   //head2比较短
            LinkAdd(preHead1,preHead2,head1Substracthead2);
            if(preHead1.val == 0){
                return preHead1.next;
            }
            else{
                return preHead1;
            }
        }
    }
        public int LinkAdd(ListNode longer,ListNode shorter,int LongerSubstractShorter){
        if(longer == null || shorter == null){
            return 0;
        }
        int sum = 0;
        if(LongerSubstractShorter>0){
            sum = longer.val + LinkAdd(longer.next,shorter,LongerSubstractShorter-1);
        }
        else{
            sum = longer.val + shorter.val + LinkAdd(longer.next,shorter.next,0);
        }
        if(sum >9){
            longer.val = sum -10;
            return 1;
        }
        else{
            longer.val = sum;
            return 0;
        }
    }

}