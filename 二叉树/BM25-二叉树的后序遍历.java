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

    List<Integer> result;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        result = new ArrayList<>();
        AddNodeToResult(root);
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void AddNodeToResult(TreeNode root) {
        if (root == null) {
            return;
        }
        AddNodeToResult(root.left);
        AddNodeToResult(root.right);
        result.add(root.val);
    }

}