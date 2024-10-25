package SolvedProblems;

public class Solution42 {
    public int trap(int[] height) {
        int length = height.length;
        if (length <= 1) {
            return 0;
        }

        int totalWater = 0;

        int[] leftWaterTrapped = new int[length];
        int[] rightWaterTrapped = new int[length];

        leftWaterTrapped[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftWaterTrapped[i] = Math.max(leftWaterTrapped[i - 1], height[i]);
        }

        rightWaterTrapped[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightWaterTrapped[i] = Math.max(rightWaterTrapped[i + 1], height[i]);
        }

        for (int i = 0; i < length; i++) {
            totalWater += Math.min(leftWaterTrapped[i], rightWaterTrapped[i]) - height[i];
        }

        return totalWater;
    }
}
