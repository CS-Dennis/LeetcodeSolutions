package SolvedProblems;

import java.util.*;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int leftIndex = 0;
        int rightIndex = sortedNums.length - 1;

        int indexOne = -1;
        int indexTwo = -1;

        while (leftIndex < rightIndex) {
            if (sortedNums[leftIndex] + sortedNums[rightIndex] == target) {
                break;
            } else if (sortedNums[leftIndex] + sortedNums[rightIndex] < target) {
                leftIndex++;
            } else if (sortedNums[leftIndex] + sortedNums[rightIndex] > target) {
                rightIndex--;
            }
        }

        boolean indexOneFound = false;
        boolean indexTwoFound = false;

        for (int i = 0; i < nums.length; i++) {
            if (sortedNums[leftIndex] == sortedNums[rightIndex]) {
                if (nums[i] == sortedNums[leftIndex] && !indexOneFound) {
                    indexOne = i;
                    indexOneFound = true;
                }

                if (nums[i] == sortedNums[rightIndex] && indexOneFound && i != indexOne) {
                    indexTwo = i;
                    break;
                }

            } else {
                if (nums[i] == sortedNums[leftIndex]) {
                    indexOne = i;
                    indexOneFound = true;
                }
                if (nums[i] == sortedNums[rightIndex]) {
                    indexTwo = i;
                    indexTwoFound = true;
                }
                if (indexOneFound && indexTwoFound) {
                    break;
                }
            }
        }

        return new int[]{indexOne, indexTwo};
    }
}
