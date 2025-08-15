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
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        // write code here
        return DepthFirstSearch(root, 0);

    }

    public int DepthFirstSearch(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = DepthFirstSearch(root.left, depth + 1);
        int rigthDepth = DepthFirstSearch(root.right, depth + 1);
        return Math.max(leftDepth, rigthDepth);
    }
}