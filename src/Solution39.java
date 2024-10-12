import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultList = new ArrayList<>();

        getIntsForTarget(resultList, null, candidates, target, 0);

        return resultList;
    }

    private void getIntsForTarget(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(tempList);
        } else if (target > 0 && candidates[index] <= target) {
            if (tempList == null) {
                tempList = new ArrayList<>();
            }
            tempList.add(candidates[index]);
            getIntsForTarget(result, new ArrayList<>(tempList), candidates, target - candidates[index], index);

            if (index + 1 < candidates.length && candidates[index + 1] <= target) {
                tempList.remove(tempList.size() - 1);
                getIntsForTarget(result, new ArrayList<>(tempList), candidates, target, index + 1);
            }
        }
    }
}
