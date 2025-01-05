package SolvedProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> remainingNums = new ArrayList<>();
        for (int i : nums) {
            remainingNums.add(i);
        }

        remainingNums.sort(Comparator.naturalOrder());

        for (int i = 0; i <= nums.length; i++) {
            createSubsets(remainingNums, i, 0, new ArrayList<>(), result);
        }

        return result;
    }

    void createSubsets(List<Integer> remainingNums, int totalNumOfSubset, int currentNumOfSubset, List<Integer> currentSubset, List<List<Integer>> result) {
        int numLeftForSubset = totalNumOfSubset - currentNumOfSubset;
        if (numLeftForSubset == 0) {
            result.add(currentSubset);
        } else if (numLeftForSubset <= remainingNums.size()) {
            for (int i = 0; i < remainingNums.size(); i++) {
                if(i==0 || (!remainingNums.get(i).equals(remainingNums.get(i-1)) )) {
                    List<Integer> newRemainingNums = new ArrayList<>(remainingNums);
                    List<Integer> newCurrentSubset = new ArrayList<>(currentSubset);

                    for (int j = 0; j <= i; j++) {
                        newRemainingNums.remove(0);
                    }
                    newCurrentSubset.add(remainingNums.get(i));
                    createSubsets(newRemainingNums, totalNumOfSubset, currentNumOfSubset + 1, newCurrentSubset, result);
                }
            }

        }
    }
}
