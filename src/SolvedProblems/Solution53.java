package SolvedProblems;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            boolean restart = false;

            int tempTotal = nums[i];

            if(max< nums[i]){
                max = nums[i];
            }

            if(nums[i]<=0){
                continue;
            }

            if(i+1 < nums.length) {
                for (int j = i + 1; j < nums.length; j++) {
                    tempTotal +=nums[j];

                    if(max<tempTotal){
                        max = tempTotal;
                    }

                    if(tempTotal<0){
                        restart = true;
//                       restart start from the very next index
                        i=j-1;
                        break;
                    }
                }
            }


            if(!restart){
                break;
            }
        }

        return max;
    }
}
