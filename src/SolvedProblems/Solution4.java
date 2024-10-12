package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int totalNums = nums1Length + nums2Length;
        boolean odd = totalNums % 2 == 1;
        int[] combinedNums = new int[totalNums];

        if(nums1.length==0 || nums2.length==0){
            if(nums1.length==0){
                return getMedian(nums2, odd);
            } else {
                return getMedian(nums1, odd);
            }
        }

//        scenario1: nums2 smallest is greater than nums1 largest
        if (nums2[0] > nums1[nums1.length - 1]) {
            for (int i = 0; i < nums1.length; i++) {
                combinedNums[i] = nums1[i];
            }

            for (int i = 0; i < nums2.length; i++) {
                combinedNums[nums1Length + i] = nums2[i];
            }

            return getMedian(combinedNums, odd);
        }

//        scenario2: nums1 smallest is greater than nums2 largest
        if (nums1[0] > nums2[nums2.length - 1]) {
            for (int i = 0; i < nums2.length; i++) {
                combinedNums[i] = nums2[i];
            }

            for (int i = 0; i < nums1.length; i++) {
                combinedNums[nums2Length + i] = nums1[i];
            }

            return getMedian(combinedNums, odd);
        }

//        scenario3: nums1 and nums2 are partially or completely overlapped
        int nums1Index = 0;
        int nums2Index = 0;
        List<Integer> combinedArraylist = new ArrayList<>();

        while ((nums1Index <= nums1Length - 1) && (nums2Index <= nums2Length - 1)) {
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                combinedArraylist.add(nums1[nums1Index]);
                nums1Index++;
            } else {
                combinedArraylist.add(nums2[nums2Index]);
                nums2Index++;
            }
        }

        if (nums1Index == nums1Length ) {
            for (int i = nums2Index; i < nums2Length; i++) {
                combinedArraylist.add(nums2[i]);
            }
        } else if (nums2Index == nums2Length ) {
            for (int i = nums1Index; i < nums1Length; i++) {
                combinedArraylist.add(nums1[i]);
            }
        }


        return getMedian(combinedArraylist.stream().mapToInt(i -> i).toArray(), odd);
    }

    public double getMedian(int[] nums, boolean odd) {
        int length = nums.length;
        if (odd) {
            return nums[length / 2];
        } else {
            return (nums[length / 2 - 1] + nums[length / 2]) / 2d;
        }
    }
}
