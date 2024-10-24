import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,-1,-1,4,2,-3,4,-10,-1,5};
        Solution53 s = new Solution53();

        System.out.println( s.maxSubArray(nums));
    }
}