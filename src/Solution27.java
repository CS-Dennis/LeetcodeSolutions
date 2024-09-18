import java.util.ArrayList;
import java.util.List;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        List<Integer> newList = new ArrayList<>();

        for (int num : nums){
            if(num!=val){
                newList.add(num);
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            nums[i] = newList.get(i);
        }

        return newList.size();
    }
}
