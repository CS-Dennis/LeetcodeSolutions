import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        Solution4 s = new Solution4();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}