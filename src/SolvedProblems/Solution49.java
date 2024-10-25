package SolvedProblems;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        HashMap<String, List<String>> hashResult = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars =  strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedChars = String.valueOf(chars);

            if(hashResult.containsKey(sortedChars)){
                hashResult.get(sortedChars).add(strs[i]);
            } else {
                hashResult.put(sortedChars, new ArrayList<>());
                hashResult.get(sortedChars).add(strs[i]);
            }
        }

        Set<String> keys = hashResult.keySet();

        for(String key:keys){
            result.add(hashResult.get(key));
        }

        return result;
    }
}
