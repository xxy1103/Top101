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
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode pre_node = null;
        ListNode mov = head;
        ListNode af_node = null;
        //找到编号为m-1和m的节点
        for(int i = 1;i<m;i++){
            pre_node = mov;
            mov = mov.next;
        }
        //找到n+1节点
        af_node = mov.next;
        for(int i = m; i<n;i++){
            af_node = af_node.next;
        }
        //反转中间部分的链表
        ListNode pre_mov = af_node; //将反转后的链表指向af_node
        ListNode af_mov = mov.next;
        while(mov != af_node){
            mov.next = pre_mov;
            pre_mov = mov;
            mov = af_mov;
            if(af_mov != null){
                af_mov = af_mov.next;
            }
        }
        if(pre_node != null){
            pre_node.next = pre_mov;    //让pre_node指向反转后的链表头
            return head;
        }
        else{
            return pre_mov;
        }
    }
}