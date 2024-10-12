package SolvedProblems;

public class Solution11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int leftIndex = 0;
        int rightIndex = length-1;

        int max = 0;

        while(rightIndex-leftIndex>=1){
            int tempArea = 0;
            int width = rightIndex-leftIndex;

            if(height[leftIndex]>= height[rightIndex]){
                tempArea = width*height[rightIndex];
                rightIndex--;
            } else {
                tempArea = width*height[leftIndex];
                leftIndex++;
            }

            if(tempArea>max){
                max = tempArea;
            }
        }

        return max;
    }
}
