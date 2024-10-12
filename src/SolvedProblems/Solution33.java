package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution33 {
    // requirement: You must write an algorithm with O(log n) runtime complexity.
//    threfore, we need to use divide and conquer
    public int search(int[] nums, int target) {
        List<Integer> indexList = new ArrayList<>();
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        } else {


            findPivotIndex(nums, 0, nums.length - 1, indexList);

            int initIndex = indexList.size() == 1 ? indexList.get(0) : 0;
            int[] numsSorted = nums.clone();
            if (initIndex > 0) {
//                reconstruct the array
                int startIndex = 0;
                for (int i = initIndex; i < nums.length; i++) {
                    numsSorted[startIndex] = nums[i];
                    startIndex++;
                }

                for (int i = 0; i < initIndex; i++) {
                    numsSorted[startIndex] = nums[i];
                    startIndex++;
                }
            }

//            use divide and conquer to identify the target in the sorted array numsSorted
            int index = findTarget(numsSorted, 0, numsSorted.length - 1, target);
            if (index == -1) {
                return -1;
            }
            int targetIndex = (index + initIndex) % nums.length;
            return targetIndex;
        }
    }

    private int findTarget(int[] sortedNums, int leftIndex, int rightIndex, int target) {
        if (rightIndex - leftIndex == 0) {
            if (sortedNums[leftIndex] == target) {
                return leftIndex;
            } else {
                return -1;
            }
        }

        int midIndex = (rightIndex - leftIndex + 1) / 2 + leftIndex;

        if (sortedNums[midIndex] == target) {
            return midIndex;
        } else if (sortedNums[midIndex] > target) {
//            check left half
            return findTarget(sortedNums, leftIndex, midIndex - 1, target);
        } else if (sortedNums[midIndex] < target) {
//            check right half
            if (midIndex + 1 <= rightIndex) {
                return findTarget(sortedNums, midIndex + 1, rightIndex, target);
            }
        }

        return -1;
    }

    private void findPivotIndex(int[] nums, int leftIndex, int rightIndex, List<Integer> initIndex) {
        int subLength = rightIndex - leftIndex + 1;

        if (subLength > 1) {
            int midIndex = subLength / 2 + leftIndex;

            if (subLength == 2) {
                if (nums[midIndex] < nums[midIndex - 1]) {
                    initIndex.add(midIndex);
                }
            } else {
                if (nums[midIndex] < nums[midIndex - 1]) {
                    initIndex.add(midIndex);
                } else if (nums[midIndex] > nums[midIndex + 1]) {
                    initIndex.add(midIndex + 1);
                } else {
//                    search first half
                    findPivotIndex(nums, leftIndex, midIndex - 1, initIndex);

//                    search second half
                    findPivotIndex(nums, midIndex, rightIndex, initIndex);
                }
            }
        }
    }

}
