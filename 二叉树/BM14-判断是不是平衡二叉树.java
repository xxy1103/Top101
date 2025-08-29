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
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
        return isBalancedReturnHeight(pRoot) >= 0 ? true : false;
    }

    public int isBalancedReturnHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = isBalancedReturnHeight(root.left);
        int rightHeight = isBalancedReturnHeight(root.right);
        if (Math.min(leftHeight, rightHeight) == -1 ||
                Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
}