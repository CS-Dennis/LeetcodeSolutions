package SolvedProblems;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
//        will use divide and conquer
        int length = nums.length;

        int midIndex = length / 2;
        int leftIndex = 0;
        int rightIndex = length-1;

        int startIndex = -1;
        int endIndex = -1;

        boolean findTarget = false;
        if (length == 0) {
            return new int[]{startIndex, endIndex};
        } else {
            while (!findTarget) {
                if (nums[midIndex] == target) {
                    findTarget = true;
                    startIndex = midIndex;
                    endIndex = midIndex;
                }
//                midIndex shift left
                else if (nums[midIndex] > target) {
                    rightIndex = midIndex;
                    midIndex = (rightIndex-leftIndex)/2+leftIndex;

                    if (midIndex == leftIndex) {
                        break;
                    }
                }
//                midIndex shift right
                else {
                    leftIndex = midIndex;
                    midIndex = rightIndex- (rightIndex-leftIndex)/2;
                    if (midIndex == rightIndex) {
                        break;
                    }
                }
            }
        }

//        check left
        for (int i = midIndex; i >= leftIndex; i--) {
            if (nums[i] == target) {
                startIndex = i;
            }
        }

//      check right
        for (int i = midIndex; i <= rightIndex; i++) {
            if (nums[i] == target) {
                endIndex = i;
            }
        }

        if (startIndex != -1 && endIndex == -1) {
            endIndex = startIndex;
        }
        if (startIndex == -1 && endIndex != -1) {
            startIndex = endIndex;
        }

        return new int[]{startIndex, endIndex};
    }
}
