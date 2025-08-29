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

    class MyNode{
        TreeNode node;
        int level;

        public MyNode(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        Queue<MyNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;

        ArrayList<Integer> currentLevelArrayList = null;
        int currentLevel = 0;
        queue.offer(new MyNode(root,currentLevel+1));
        while (!queue.isEmpty()) {
            MyNode mynode = queue.poll();
            if(currentLevel != mynode.level){
                currentLevel = mynode.level;
                currentLevelArrayList = new ArrayList<>();
                result.add(currentLevelArrayList);
            }
            currentLevelArrayList.add(mynode.node.val);
            if(mynode.node.left != null) queue.add(new MyNode(mynode.node.left, currentLevel+1));
            if(mynode.node.right != null) queue.add(new MyNode(mynode.node.right, currentLevel+1));
        }
        return result;
    }
}