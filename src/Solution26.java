public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int uniqueCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                uniqueCounter++;
            } else {
                if(nums[i]==nums[uniqueCounter-1]){
                    nums[i] = -200;
                } else {
                    nums[uniqueCounter] = nums[i];
                    uniqueCounter++;
                }
            }
        }
        return uniqueCounter;
    }
}
