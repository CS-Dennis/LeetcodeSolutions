public class Solution45 {
    public int jump(int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        int jumps = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxStepsNow = nums[i];

            if(i+maxStepsNow >= nums.length-1){
                jumps++;
                break;
            }

            int maxStepsNext = nums[i + maxStepsNow];
            int totalNowAndNext = maxStepsNow + maxStepsNext;

            int temp = 0;
            int innerSteps = 0;
            int maxInnerSteps = 0;
            int jumpIndex = 0;
            for (int j = i + 1; j < i + maxStepsNow; j++) {
                temp++;

                innerSteps = temp + nums[j];
                if (maxInnerSteps < innerSteps) {
                    maxInnerSteps = innerSteps;
                    jumpIndex = j;
                }
            }

            if (totalNowAndNext > maxInnerSteps) {
                i = i + maxStepsNow - 1;
                jumps++;
            } else {
                i = jumpIndex - 1;
                jumps++;
            }

        }
        return jumps;
    }

}
