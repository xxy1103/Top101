import java.util.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode mov = head;
        for(int i = 0; i<10001;i++){
            if(mov == null){
                return false;
            }
            mov = mov.next;
        }
        return true;
    }
}