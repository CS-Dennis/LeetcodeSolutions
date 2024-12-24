package SolvedProblems;

import java.util.*;

public class Solution60 {
    public int count = 0;
    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        List<Integer> currentDigits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            currentDigits.add(i);
        }
        permutate(list, "", currentDigits, n, k);
//        System.out.println(list.size());
        return list.get(0);
    }
    
    void permutate(List<String> list, String currentString, List<Integer> currentDigits, int n, int k){
        if(n==0){
//            System.out.println(count);
            count++;
            if(count==k){
                list.add(currentString);
            }
        } else {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> currentDigitsCopy = new ArrayList<>(currentDigits);
                Integer currentDigit = currentDigitsCopy.get(i);
                currentDigitsCopy.remove(currentDigit);
                String newString = currentString+currentDigit.toString();
                if(count+1<=k){
                    permutate(list, newString, currentDigitsCopy, n-1, k);
                }
            }
        }
    }
}
