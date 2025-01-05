public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }

        return findTarget(root, 0, targetSum);
    }

    private boolean findTarget(TreeNode node, int currentSum, int targetSum){
        currentSum=currentSum+node.val;

        if(node.left==null && node.right==null ){
            if(currentSum == targetSum) {
                return true;
            } else {
                return false;
            }
        }

        if(node.left==null){
            return findTarget(node.right, currentSum, targetSum);
        }

        if(node.right==null){
            return findTarget(node.left, currentSum, targetSum);
        }

        return findTarget(node.right, currentSum, targetSum) || findTarget(node.left, currentSum, targetSum);
    }
}
