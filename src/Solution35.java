public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return targetIndex(nums, 0, nums.length-1, target);
    }

    private int targetIndex(int[] sortedNums, int leftIndex, int rightIndex, int target) {
        if (rightIndex - leftIndex == 0) {
            if (sortedNums[leftIndex] == target) {
                return leftIndex;
            } else if (sortedNums[leftIndex] > target) {
                return leftIndex;
            } else if(sortedNums[leftIndex]<target){
                return leftIndex+1;
            }
        } else if (rightIndex - leftIndex == 1) {
            if (sortedNums[rightIndex] == target) {
                return rightIndex;
            } else if (sortedNums[leftIndex] == target) {
                return leftIndex;
            } else if (sortedNums[rightIndex] > target && sortedNums[leftIndex] < target) {
                return leftIndex + 1;
            } else if(sortedNums[leftIndex]>target){
                return leftIndex;
            } else if(sortedNums[rightIndex]<target){
                return rightIndex+1;
            }
        } else if (rightIndex - leftIndex > 1) {
            int length = rightIndex - leftIndex + 1;
            int midIndex = length / 2 + leftIndex;
            if(sortedNums[midIndex]==target){
                return midIndex;
            } else if(sortedNums[midIndex]>target){
                return targetIndex(sortedNums, leftIndex, midIndex-1, target);
            } else if(sortedNums[midIndex]<target){
                return targetIndex(sortedNums, midIndex+1, rightIndex, target);
            }
        }
        return -1;
    }
}
