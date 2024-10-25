package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> remainingList = new ArrayList<>();
        for (Integer i : nums) {
            remainingList.add(i);
        }

        permutateList(result, null, remainingList, nums.length);

        return result;
    }

    private void permutateList(List<List<Integer>> result, List<Integer> currentList, List<Integer> remainingList, int totalLength) {
        if (currentList != null && currentList.size() == totalLength) {
            result.add(currentList);
        } else {
            int i = remainingList.size() - 1;
            while (i >= 0) {
                List<Integer> tempList = new ArrayList<>();
                if (currentList != null) {
                    for (Integer num : currentList) {
                        tempList.add(num);
                    }
                }

                tempList.add(remainingList.get(i));
                List<Integer> newRemainingList = new ArrayList<>();
                for (Integer digit : remainingList) {
                    newRemainingList.add(digit);
                }
                newRemainingList.remove(i);
                permutateList(result, tempList, newRemainingList, totalLength);
                i--;
            }
        }
    }
}
