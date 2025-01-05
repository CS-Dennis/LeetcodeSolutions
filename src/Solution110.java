import java.util.ArrayList;
import java.util.List;

public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        List<Integer> maxLevel = new ArrayList<>();

        getSubTreeLevels(root, 1, maxLevel);
        return checkIfHeightBalanced(root);
    }

    private void getSubTreeLevels(TreeNode node, int currentLevel, List<Integer> maxLevel) {
        if (maxLevel.isEmpty()) {
            maxLevel.add(0);
        }

        if (currentLevel > maxLevel.get(0)) {
            maxLevel.set(0, currentLevel);
        }

        if (node.left != null) {
            getSubTreeLevels(node.left, currentLevel + 1, maxLevel);
        }
        if (node.right != null) {
            getSubTreeLevels(node.right, currentLevel + 1, maxLevel);
        }
    }

    private boolean checkIfHeightBalanced(TreeNode node){
        if(node==null){
            return true;
        }
        List<Integer> maxLeft = new ArrayList<>();
        maxLeft.add(0);
        List<Integer> maxRight = new ArrayList<>();
        maxRight.add(0);
        if(node.left!=null){
            getSubTreeLevels(node.left, 1, maxLeft);
        }

        if(node.right!=null){
            getSubTreeLevels(node.right, 1, maxRight);
        }

        if(Math.abs(maxLeft.get(0)-maxRight.get(0))>1){
            return false;
        }

        return checkIfHeightBalanced(node.left) && checkIfHeightBalanced(node.right);
    }
}
