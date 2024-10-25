package SolvedProblems;

import java.util.*;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int result = -1;

//        get nums into HashSet
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

//        loops from 1 to the size of the HashSet to find out the missing smallest int
        for (int i = 1; i <= set.size(); i++) {
            if(!set.contains(i)){
                result = i;
                break;
            }
        }

        if(result==-1){
            result = set.size()+1;
        }

        return result;
    }
}
