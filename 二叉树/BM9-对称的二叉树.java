import java.util.*;


class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
  public TreeNode(int val) {
    this.val = val;
  }
}


public class Solution {
    TreeNode EndNode = new TreeNode(1001);

    TreeNode toLeft;
    LinkedList<TreeNode> leftStack;
    TreeNode toRight;
    LinkedList<TreeNode> rightStack;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pRoot TreeNode类 
     * @return bool布尔型
     */
    public boolean isSymmetrical (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return true;
        }
        EndNode.left = EndNode;
        EndNode.right = EndNode;
        toLeft = pRoot.left;
        toRight = pRoot.right;
        leftStack = new LinkedList<TreeNode>();
        leftStack.push(EndNode);
        rightStack = new LinkedList<TreeNode>();
        rightStack.add(EndNode);
        while(toLeft != EndNode && toRight != EndNode){
            if(toLeft == null && toRight == null) {
                rightInorderTraversal();
                leftInorderTraversal();
                System.out.println("都为null");
                continue;
            }
            if(toLeft == null) {
                System.out.println("左值为null");
                return false;
            }
            if(toRight == null) {
                System.out.println("右值为null");
                return false;
            }
            System.out.println("左侧值："+toLeft.val);
            System.out.println("右侧值："+toRight.val);
            if(toLeft.val != toRight.val) return false;
            rightInorderTraversal();
            leftInorderTraversal();
        }
        return true;
    }

    private void rightInorderTraversal(){
        if(toRight != null){
            rightStack.push(toRight);
            toRight = toRight.right;
        }
        else if(toRight == null){
            toRight = rightStack.pop();
            toRight = toRight.left;
        }
    }

    private void leftInorderTraversal(){
        if(toLeft != null){
            leftStack.push(toLeft);
            toLeft = toLeft.left;
        }
        else if(toLeft == null){
            toLeft = leftStack.pop();
            toLeft = toLeft.right;
        }
    }
}