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

    class NodeWithLevel {
        TreeNode node;
        int level;

        public NodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        // write code here
        LinkedList<NodeWithLevel> deque = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int currentLevel = 0;
        ArrayList<Integer> currentLevelList = null;
        if (pRoot == null) {
            return result;
        }
        deque.push(new NodeWithLevel(pRoot, currentLevel + 1));
        while (!deque.isEmpty()) {
            NodeWithLevel myNode = null;
            if (currentLevel % 2 == 0)
                myNode = deque.getLast();
            else
                myNode = deque.peek();
            int level = myNode.level;
            if (currentLevel < level) {
                result.add(new ArrayList<>());
                currentLevel = level;
            }
            if (currentLevel % 2 == 0) {
                myNode = deque.getLast();
                deque.removeLast();
            } else {
                myNode = deque.poll();
            }
            currentLevelList = result.get(level - 1);
            currentLevelList.add(myNode.node.val);
            if (level % 2 == 0) {
                if (myNode.node.right != null)
                    deque.push(new NodeWithLevel(myNode.node.right, level + 1));
                if (myNode.node.left != null)
                    deque.push(new NodeWithLevel(myNode.node.left, level + 1));
            } else {
                if (myNode.node.left != null)
                    deque.offer(new NodeWithLevel(myNode.node.left, level + 1));
                if (myNode.node.right != null)
                    deque.offer(new NodeWithLevel(myNode.node.right, level + 1));
            }
        }
        return result;
    }
}