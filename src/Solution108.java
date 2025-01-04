public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildRootTreeNode(nums, 0, nums.length - 1);
    }

    //    side
//    left: 0, right: 1
    private TreeNode buildRootTreeNode(int[] nums, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        } else {
            int midIndex = startIndex + (endIndex - startIndex)/2;
            TreeNode root = new TreeNode(nums[midIndex]);

            root.left = buildRootTreeNode(nums, startIndex, midIndex-1);
            root.right = buildRootTreeNode(nums, midIndex+1, endIndex);

            return root;
        }

    }
}
