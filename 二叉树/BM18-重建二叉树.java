import java.util.*;
import java.util.stream.Collectors;
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
    int i;
    int[] preOrder;    
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param preOrder int整型一维数组 
     * @param vinOrder int整型一维数组 
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        this.i = 0;
        this.preOrder = preOrder;
        List<Integer> list = Arrays.stream(vinOrder)
                           .boxed()
                           .collect(Collectors.toList());
        return constructTree(list);
    }

    public TreeNode constructTree(List<Integer> child){
        if(child.size() == 0)
            return null;
        TreeNode node = new TreeNode(preOrder[i++]);
        int indexOfNode = child.indexOf(node.val);
        try{
            node.left = constructTree(child.subList(0,indexOfNode));
        }
        catch(Exception e){
            node.left = null;
        }
        try{
            node.right = constructTree(child.subList(indexOfNode+1, child.size()));
        }
        catch(Exception E){
            node.right = null;
        }
        return node; 
    }
}