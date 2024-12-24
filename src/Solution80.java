public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int counter = 0;
        int currentMatch = nums[0];
        int marker = nums[0] - 1;

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                counter++;
                k++;
            } else {
                if (nums[i] == currentMatch) {
                    counter++;
                    if (counter >= 3) {
                        nums[i] = marker;
                    } else {
                        k++;
                    }
                } else {
                    currentMatch = nums[i];
                    counter = 1;
                    k++;
                }
            }
        }

        counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter++;
            if(counter==nums.length){
                break;
            }
            if (nums[i] == marker) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = marker;
                i--;
            }
        }

        System.out.println("marker: "+marker);
        for (int i: nums){
            System.out.print(i+" ");
        }
        System.out.println("");
        return k;
    }
}
