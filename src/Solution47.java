import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int totalLength = nums.length;

        List<List<Integer>> finalList = new ArrayList<>();

        List<Integer> numsList = new ArrayList<>();
        for (Integer i : nums) {
            numsList.add(i);
        }

        permutateList(finalList, new ArrayList<>(), numsList, totalLength);


        return finalList;
    }

    private void permutateList(List<List<Integer>> finalList, List<Integer> currentList, List<Integer> remainingList, int totalLength) {
        if (currentList != null && currentList.size() == totalLength) {
            finalList.add(currentList);
        } else {
            int i = remainingList.size()-1;
            while (i >=0) {
                List<Integer> copyRemainingList = new ArrayList<>(List.copyOf(remainingList));
                List<Integer> copyCurrentList = new ArrayList<>(List.copyOf(currentList));
                copyCurrentList.add(remainingList.get(i));
                copyRemainingList.remove(i);
                while (i-1>=0 && remainingList.get(i) == remainingList.get(i - 1)) {
                    i--;
                }
                i--;
                permutateList(finalList, copyCurrentList, copyRemainingList, totalLength);
            }
        }
    }
}
