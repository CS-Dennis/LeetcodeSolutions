import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        int length = nums.length;

//      treat midIndex and rightIndex as two sum problems
        for (int leftIndex = 0; leftIndex < length - 2; leftIndex++) {
            int newSum = nums[leftIndex] * (-1);

            int midIndex = leftIndex+1;
            int rightIndex = length-1;
            if(midIndex>=rightIndex){
                break;
            }

            if(leftIndex>0 && nums[leftIndex] == nums[leftIndex-1]){
                continue;
            }

            while(midIndex<rightIndex){

                if(nums[midIndex]+nums[rightIndex]==newSum){
                    if(midIndex>leftIndex+1 && nums[midIndex]==nums[midIndex-1]){
                        midIndex++;
                        continue;
                    }

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[leftIndex]);
                    temp.add(nums[midIndex]);
                    temp.add(nums[rightIndex]);
                    results.add(temp);
                    midIndex++;
                    rightIndex--;
                } else if(nums[midIndex]+nums[rightIndex]>newSum){
                    rightIndex--;
                } else {
                    midIndex++;
                }
            }
        }

        return results;
    }
}
