import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums ={1,2,3};
        Solution46 s = new Solution46();
        List<Integer> a = new ArrayList<>();
        System.out.println(s.permute(nums));
    }
}