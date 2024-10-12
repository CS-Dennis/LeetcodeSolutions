package SolvedProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> results = new ArrayList<>();
//        index 1
        for (int i = 0; i < length - 3; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //            index 2
            for (int j = i + 1; j < length - 2; j++) {
                if(j>i+1 && nums[j]== nums[j-1]){
                    continue;
                }
                int newTarget = target - nums[i] - nums[j];
//          index left and index right
                int leftIndex = j + 1;
                int rightIndex = length - 1;
                while (leftIndex < rightIndex) {
                    if(rightIndex< length-1 && nums[rightIndex]==nums[rightIndex+1]){
                        rightIndex--;
                        continue;
                    }

                    if (nums[leftIndex] + nums[rightIndex] == newTarget) {
                        long check =((long) nums[i])+((long) nums[j])+((long) nums[leftIndex])+((long) nums[rightIndex]);
                        if(check>Integer.MAX_VALUE || check<Integer.MIN_VALUE){
                            break;
                        }

                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[leftIndex]);
                        temp.add(nums[rightIndex]);
                        results.add(temp);
                        leftIndex++;
                        rightIndex--;
                    } else if (nums[leftIndex] + nums[rightIndex] < newTarget) {
                        leftIndex++;
                    } else if (nums[leftIndex] + nums[rightIndex] > newTarget) {
                        rightIndex--;
                    }
                }

            }
        }

        return results;
    }
}
