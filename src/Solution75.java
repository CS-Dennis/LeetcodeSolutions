import java.util.ArrayList;
import java.util.List;

public class Solution75 {
    public void sortColors(int[] nums) {
        List<Integer> red = new ArrayList<>();
        List<Integer> white = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();

        for (int num : nums) {
            if (num == 0) {
                red.add(0);
            } else if (num == 1) {
                white.add(1);
            } else {
                blue.add(2);
            }
        }

        for (int i = 0; i < red.size(); i++) {
            nums[i] = 0;
        }

        for (int i = red.size(); i < red.size() + white.size(); i++) {
            nums[i] = 1;
        }

        for (int i = red.size() + white.size(); i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
