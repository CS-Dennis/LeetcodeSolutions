package SolvedProblems;

public class Solution91 {
    public int numDecodings(String s) {
//        using DP. Example:
// string index      0 1 2 3 4 5 6
// string           "1 2 0 1 2 3 4"
//dp[]             1 1 2 1 1 2 3 3,
//dp[] index       0 1 2 3 4 5 6 7
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) != '0') {
                dp[i + 1] = 1;
            } else if ((i == 0 && s.charAt(i) == '0') || (i >= 1 && s.charAt(i - 1) >= '3' && s.charAt(i) == '0')) {
//                0 case scenario: e.g., 12304
                dp[i + 1] = 0;
                return dp[i + 1];
            } else if (i >= 1 && s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
//                0 case scenario: e.g., 1200
                dp[i + 1] = 0;
                return dp[i + 1];
            } else if (i >= 1 && (s.charAt(i - 1) == '1' && s.charAt(i) >= '1') || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else if (i >= 2 && s.charAt(i) == '0') {
                dp[i + 1] = dp[i - 1];
            } else if (i >= 3 && s.charAt(i - 1) == '0') {
                dp[i + 1] = dp[i - 2];
            } else {
                dp[i + 1] = dp[i];
            }
        }

//        for(int i:dp){
//            System.out.print(i+", ");
//        }
//        System.out.println();

        return dp[n];
    }
}
