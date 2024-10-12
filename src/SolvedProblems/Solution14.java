package SolvedProblems;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        StringBuilder prefix = new StringBuilder();
        boolean checkingInProgress = true;
        boolean outboundIndex = false;

        while (checkingInProgress) {
            for (int i = 0; i < strs.length; i++) {
                if (index > strs[i].length() - 1) {
                    checkingInProgress = false;
                    outboundIndex = true;
                    break;
                }
                char currentLetter = strs[0].charAt(index);
                if (currentLetter != strs[i].charAt(index)) {
                    checkingInProgress = false;
                    break;
                }
            }
            if(!outboundIndex && checkingInProgress){
                prefix.append(strs[0].charAt(index));
                index++;
            }
        }
        return prefix.toString();
    }
}
