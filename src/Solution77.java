import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> numsLeft = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numsLeft.add(i + 1);
        }
        permutateList(k, numsLeft, new ArrayList<>(), finalList);
        return finalList;
    }

    public void permutateList(int k, List<Integer> numsLeft, List<Integer> subList, List<List<Integer>> list) {
        if (subList.size() == k) {
            list.add(new ArrayList<>(subList));
        } else {
            for (int i = 0; i < numsLeft.size(); i++) {
                if (subList.isEmpty() || numsLeft.get(i) > subList.get(subList.size() - 1)) {
                    List<Integer> newSubList = new ArrayList<>(subList);
                    newSubList.add(numsLeft.get(i));
                    List<Integer> newNumsLeft = new ArrayList<>(numsLeft);
                    newNumsLeft.remove(i);
                    permutateList(k, newNumsLeft, newSubList, list);
                }
            }
        }
    }
}
