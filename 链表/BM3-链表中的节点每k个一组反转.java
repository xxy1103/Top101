public class Solution {

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode preNode = preHead;
        for(preNode = preHead; preNode.next != null; ){
            ListNode mov = preNode.next;
            ListNode movNext;
            int tmp = k;
            while(mov != null && --tmp > 0){
                mov = mov.next;
            }
            if(mov == null){
                break;
            }
            movNext = mov.next;
            ListNode originalAfNode = reverseNextK(preNode.next, k-1);
            if(originalAfNode == null){
                break;
            }
            originalAfNode.next = movNext;
            preNode.next = mov;
            preNode = originalAfNode;
        }
        return preHead.next;
    }

    public ListNode reverseNextK(ListNode preNode,int k){
        if(preNode == null){
            return null;
        }
        if(k == 0){
            return preNode;
        }
        ListNode originalAfNode = reverseNextK(preNode.next,k-1);
        if(originalAfNode == null){
            return null;
        }
        originalAfNode.next = preNode;
        return preNode;
    }
}