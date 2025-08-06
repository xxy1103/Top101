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
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // 原来是归并排序
        return mergeSort(head);
       
    }

    public ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode centre = getCentre(head);
        System.out.println("中心点值为："+centre.val);
        ListNode head1 = head;
        ListNode head2 = centre.next;
        centre.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return combineTowSortedList(head1,head2);

    }

    public ListNode combineTowSortedList(ListNode head1,ListNode head2){
        ListNode head = new ListNode(0);
        ListNode mov = head;
        ListNode mov1 = head1;
        ListNode mov2 = head2;
        while(mov1 != null && mov2 != null){
            if(mov1.val < mov2.val){
                mov.next = mov1;
                mov1 = mov1.next;
            }
            else{
                mov.next = mov2;
                mov2 = mov2.next;
            }
            mov = mov.next;
        }
        if(mov1 == null){
            mov.next = mov2;
        }
        else{
            mov.next = mov1;
        }
        return head.next;
    } 

    public ListNode getCentre(ListNode head){
        ListNode fastNode = head;
        ListNode slowNode = head;
        int i = 0;
        while(fastNode.next != null){
            fastNode = fastNode.next;
            i++;
            if(i % 2 == 0){
                slowNode = slowNode.next;
            }
        }
        return slowNode;
    }    
}
