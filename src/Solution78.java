import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> remainingNums = new ArrayList<>();
        for (int i: nums){
            remainingNums.add(i);
        }
        for (int i = 0; i <= nums.length; i++) {
            permutate(remainingNums, i, new ArrayList<>(), list);
        }
        return list;
    }

    public void permutate(List<Integer>remainingNums, int numOfPicks, List<Integer> currentList, List<List<Integer>> list) {
        if(numOfPicks==0){
            list.add(currentList);
        } else  {
            for (int i = 0; i < remainingNums.size(); i++) {
                List<Integer> newRemainingNums = new ArrayList<>(remainingNums);
                List<Integer> newCurrentList = new ArrayList<>(currentList);
                newCurrentList.add(remainingNums.get(i));
                for (int j = 0; j <= i; j++) {
                    newRemainingNums.remove(0);
                }
                permutate(newRemainingNums,numOfPicks-1, newCurrentList, list );
            }
        }
    }
}
