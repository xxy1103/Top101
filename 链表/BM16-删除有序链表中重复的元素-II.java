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
    ListNode preMov;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        final int invalidValue = 1001;
        ListNode fakeHead = new ListNode(invalidValue);
        fakeHead.next = head;
        preMov = fakeHead;
        while (preMov != null) {
            deletePreMovAfterDuplicates();
        }
        return fakeHead.next;

    }
    public void deletePreMovAfterDuplicates() {
        if (preMov.next != null) {
            int duplicatesCount = 0;
            ListNode preMovNextFront = preMov.next;
            ListNode preMovNextTail = preMov.next;
            while (preMovNextTail != null && preMovNextFront.val == preMovNextTail.val) {
                preMovNextTail = preMovNextTail.next;
                duplicatesCount++;
            }
            if (duplicatesCount > 1) {
                preMov.next = preMovNextTail;
                System.out.println(preMovNextFront.val + "重复" + duplicatesCount + "次");
            } else {
                preMov = preMov.next;
            }
        }
        else{
            preMov = preMov.next;
        }
        
    }
}