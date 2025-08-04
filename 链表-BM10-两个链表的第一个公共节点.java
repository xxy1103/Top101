import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> nodeSet = new HashSet<ListNode>();
        ListNode mov1 = pHead1;
        ListNode mov2 = pHead2;
        while(mov1 != null || mov2 != null){
            if(mov1 != null){
                if(nodeSet.contains(mov1)){
                    return mov1;
                }
                nodeSet.add(mov1);
                mov1 = mov1.next;
            }
            if(mov2 != null){
                if(nodeSet.contains(mov2)){
                    return mov2;
                }
                nodeSet.add(mov2);
                mov2 = mov2.next;
            }
        }
        return null;

    }
}
