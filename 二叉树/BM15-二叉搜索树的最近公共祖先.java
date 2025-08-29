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
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @param p int整型 
     * @param q int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        if(root == null) return -1;
        if(root.val<=Math.max(p,q) && root.val >=Math.min(p, q))
            return root.val;
        int val1 = lowestCommonAncestor(root.left, p, q);
        if(val1 >= 0) return val1;   
        int val2 = lowestCommonAncestor(root.right, p, q);
        return val2;
        
    }
}