public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMinDepth(root, 1, 10000);
    }

    private int getMinDepth(TreeNode node, int nodeLevel, int currentMinValue) {
        if(node==null){
            return currentMinValue;
        }

        if(node!=null && node.left==null && node.right==null){
            return Math.min(nodeLevel, currentMinValue);
        }

        return Math.min(getMinDepth(node.left, nodeLevel+1, currentMinValue), getMinDepth(node.right, nodeLevel+1, currentMinValue));
    }
}
