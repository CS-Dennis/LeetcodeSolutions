import java.util.Arrays;
import java.util.Comparator;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Integer[] array = new Integer[m+n];
        if(m>0){
            for (int i = 0; i < m; i++) {
                array[i]=nums1[i];
            }
        }

        if(n>0){
            for (int i = 0; i < n; i++) {
                array[m+i] = nums2[i];
            }
        }
        Arrays.sort(array, Comparator.naturalOrder() );
        for (int i = 0; i < m+n; i++) {
            nums1[i] = array[i];
        }
    }
}
