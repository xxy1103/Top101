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
    int nodeValue = Integer.MIN_VALUE;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return bool布尔型
     */
    public boolean isValidBST (TreeNode root) {
        // write code here
        return inorderTraversal(root);

    }

    private boolean inorderTraversal(TreeNode root){
        if(root == null) return true;

        if(!inorderTraversal(root.left)){
            return false;
        }
        if(nodeValue > root.val){
            return false;
        }
        nodeValue = root.val;
        if(!inorderTraversal(root.right)){
            return false;
        }
        return true;
    }
}