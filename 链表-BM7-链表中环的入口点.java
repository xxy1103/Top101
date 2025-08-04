import java.util.*;
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        ListNode mov = pHead;
        while(mov != null){
            if(nodeSet.contains(mov)){
                return mov;
            }
            nodeSet.add(mov);
            mov = mov.next;
        }
        return null;
    }
}
