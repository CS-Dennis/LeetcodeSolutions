import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0]+nums[1]+nums[2];
        boolean found = false;

        for (int i = 0; i < nums.length-2; i++) {
            if(found){
                break;
            }

            int newTarget = target-nums[i];

            int midIndex = i+1;
            int rightIndex = nums.length-1;

            while(midIndex<rightIndex){
//                bingo
                if(nums[midIndex]+nums[rightIndex] == newTarget){
                    result = target;
                    found = true;
                    break;
                } else if(nums[midIndex]+nums[rightIndex] < newTarget){
                    if(Math.abs(newTarget-(nums[midIndex]+nums[rightIndex]))<Math.abs(target-result)){
                        result = nums[midIndex]+nums[rightIndex]+nums[i];
                    }
                    midIndex++;
                } else if(nums[midIndex]+nums[rightIndex] > newTarget){
                    if(Math.abs(newTarget-(nums[midIndex]+nums[rightIndex]))<Math.abs(target-result)){
                        result = nums[midIndex]+nums[rightIndex]+nums[i];
                    }
                    rightIndex--;
                }
            }
        }
        return result;
    }
}
