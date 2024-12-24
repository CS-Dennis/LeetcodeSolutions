package SolvedProblems;

public class Solution55 {
    public boolean canJump(int[] nums) {
        boolean result = false;
        int currentSteps = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSteps = nums[i];

            if (currentSteps >= nums.length - 1 - i) {
                result = true;
                break;
            } else if (currentSteps == 0) {
                break;
            }

            if (i + 1 < nums.length) {
                int originalSteps = currentSteps;
                for (int j = i + 1; j <= i + originalSteps; j++) {
                    currentSteps--;

                    if (nums[j] > currentSteps) {
                        i = j - 1;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
