package SolvedProblems;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxCounter = 0;
        int length = s.length();

        StringBuilder sb = new StringBuilder();


        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        for (int i = 0; i < length; i++) {
//            current char not in subString
            if (sb.indexOf(String.valueOf(s.charAt(i)))==-1){
                sb.append(s.charAt(i));
            }
//            current char found in subString
            else {
                if(sb.length()>maxCounter){
                    maxCounter = sb.length();
                }

                String temp = sb.substring(sb.indexOf(String.valueOf(s.charAt(i)))+1);
                sb.delete(0, sb.length());
                sb.append(temp);
                sb.append(s.charAt(i));
            }
        }

        if(sb.length()>maxCounter){
            maxCounter = sb.length();
        }

        return maxCounter;
    }
}
