public class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        } else if (nums[0] == target) {
            return true;
        } else if (nums[0] < target) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    return true;
                } else if (nums[i] < nums[i - 1]) {
                    return false;
                }
            }
        } else {
            for (int i = nums.length - 1; i >= 1; i--) {
                if (nums[i] == target) {
                    return true;
                } else if (i < nums.length - 1 && nums[i] > nums[i + 1]) {
                    return false;
                }
            }
        }

        return false;
    }
}
