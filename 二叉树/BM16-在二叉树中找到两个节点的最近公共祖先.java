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
    int o1,o2;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        this.o1 = o1;
        this.o2 = o2;
        Map<Boolean, Set<Integer>> map = postorderReturnValSet(root);
        Set<Integer> asnSet = map.get(true);
        for(Integer i : asnSet){
            System.out.println(i);
            return i;
        }
        return 0;

    }

    private Map<Boolean, Set<Integer>> postorderReturnValSet(TreeNode node){
        Map<Boolean, Set<Integer>> map  = new HashMap<>();
        if(node == null){
            map.put(false, new HashSet<>());
            return map;
        }
        Map<Boolean, Set<Integer>> left = postorderReturnValSet(node.left);
        if(left.containsKey(true)){
            return left;
        }
        Map<Boolean, Set<Integer>> right = postorderReturnValSet(node.right);
        if(right.containsKey(true)){
            return right;
        }
        Set<Integer> leftSet = left.get(false);
        Set<Integer> rightSet = right.get(false);
		if(node.val == o1 || node.val == o2)
        	leftSet.add(node.val);
		leftSet.addAll(rightSet);
        if(leftSet.contains(o1) && leftSet.contains(o2)){
                Set<Integer> ansSet = new HashSet<>();
                ansSet.add(node.val);
                map.put(true, ansSet);
                return map;
        }
        map.put(false, leftSet);
        return map;
        
    }
    
    public static void main(String[] args) {
        // 创建测试树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        
        Solution solution = new Solution();
        
        // 测试案例
        System.out.println("LCA of 5 and 1: " + solution.lowestCommonAncestor(root, 5, 1)); // 应该输出3
        System.out.println("LCA of 5 and 6: " + solution.lowestCommonAncestor(root, 5, 6)); // 应该输出5
        System.out.println("LCA of 7 and 2: " + solution.lowestCommonAncestor(root, 7, 2)); // 应该输出5
        System.out.println("LCA of 0 and 8: " + solution.lowestCommonAncestor(root, 0, 8)); // 应该输出1
    }
}