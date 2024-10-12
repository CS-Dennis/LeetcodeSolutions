import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(candidates);

        getIntsForTarget(resultList, null, candidates, target, 0);
        return resultList;
    }

    private void getIntsForTarget(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int target, int index) {
        if (target == 0) {
            list.add(tempList);
        } else if (target > 0) {
            if (tempList == null) {
                tempList = new ArrayList<>();
            }
            if (index < candidates.length && candidates[index]<=target ) {
                tempList.add(candidates[index]);

                if (index + 1 <= candidates.length) {
                    getIntsForTarget(list, new ArrayList<>(tempList), candidates, target - candidates[index], index + 1);

                    while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
                        index++;
                    }
                    tempList.remove(tempList.size() - 1);
                    getIntsForTarget(list, new ArrayList<>(tempList), candidates, target, index + 1);
                }
            }

        }
    }
}
