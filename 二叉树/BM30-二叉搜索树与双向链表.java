import java.util.*;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode head = null;
    TreeNode preNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
 
        if(Convert(pRootOfTree.left) == null && head == null){
            head = pRootOfTree;
        }
        if(head != null){
            if(preNode != null){
                preNode.right = pRootOfTree;
            }
            pRootOfTree.left = preNode;
            preNode = pRootOfTree;
        }  
        Convert(pRootOfTree.right);    

        return head;
    }
}
