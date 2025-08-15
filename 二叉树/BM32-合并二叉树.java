import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution {

    TreeNode nullNode = new TreeNode(0);
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param t1 TreeNode类 
     * @param t2 TreeNode类 
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        preorderTraversal(t1,t1,t2);
        return t1;
    }
    public TreeNode preorderTraversal(TreeNode root, TreeNode mov1, TreeNode mov2){
        if(mov1 == null){
            mov1 = nullNode;
            root = mov2;
        }
        if(mov2 == null){  
            mov2 = nullNode;
            root = mov1;
        }
        root.val = mov1.val + mov2.val;
        if(root.val != 0){
            root.left = preorderTraversal(root.left, mov1.left, mov2.left);         
            root.right = preorderTraversal(root.right, mov1.right, mov2.right);
            return root;
        }
        else{
            return null;
        }
    }
}