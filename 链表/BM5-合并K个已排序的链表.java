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
     * @param lists ListNode类ArrayList 
     * @return ListNode类
     */
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here
        int k = lists.size();
        ListNode[] mov = new ListNode[k];
        for(int i = 0; i < lists.size();i++){
          	mov[i] = lists.get(i);
        }
		ListNode head = new ListNode(1);
		ListNode movMain = head;
		while(is_continue(mov,k)){
			//找到未归纳节点中值最小的节点
			int minIndex = -1;
			for(int i = 0;i<k;i++){
				if(mov[i] != null){
					if(minIndex == -1){
						minIndex = i;
					}
					else{
						if(mov[minIndex].val > mov[i].val){
							minIndex = i;
						}
					}
				}
			}
			//将最小节点加入归纳链表
			movMain.next = mov[minIndex];
			mov[minIndex] = mov[minIndex].next;
			movMain = movMain.next;
		}
		for(int i = 0;i < k;i++){
			if(mov[i] != null){
				movMain.next = mov[i];
			}
		}
		return head.next;
    }
	public boolean is_continue(ListNode[] mov,int k){
		int count = 0;
		for(int i = 0;i<k;i++){
			if(mov[i] != null){
				count++;
			}
			if(count >=2){
				return true;
			}
		}
		return false;
	}
}