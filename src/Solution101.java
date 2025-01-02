public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right != null) {
            return false;
        } else if (root.left != null && root.right == null) {
            return false;
        } else {
            return checkIfSymmetric(root.left, root.right);
        }
    }

    private boolean checkIfSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left != null && right == null) || (left == null && right != null) || (left.val != right.val)) {
            return false;
        }

        return checkIfSymmetric(left.left, right.right) && checkIfSymmetric(left.right, right.left);
    }
}
