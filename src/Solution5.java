public class Solution5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        int palindromeLength = length;

        if (length == 1) {
            return s;
        }
//        when s has two or more letters
        else {
            StringBuilder result = new StringBuilder();
            while (palindromeLength > 1) {
                for (int i = 0; i <= length - palindromeLength; i++) {
                    String temp = s.substring(i, palindromeLength + i);
                    if (checkPalindrome(temp, 0, palindromeLength - 1)) {
                        if (result.length() < temp.length()) {
                            result = new StringBuilder(temp);
                        }
                    }
                }

                if(palindromeLength<=result.length()){
                    break;
                }

                palindromeLength--;
            }

            if(result.isEmpty()){
                return s.substring(0, 1);
            }

            return result.toString();
        }
    }

    public boolean checkPalindrome(String string, int leftIndex, int rightIndex) {
        if (string.charAt(leftIndex) == string.charAt(rightIndex)) {
            if ((leftIndex == rightIndex - 1) || leftIndex == rightIndex - 2) {
                return true;
            } else {
                return checkPalindrome(string, leftIndex + 1, rightIndex - 1);
            }
        } else {
            return false;
        }
    }
}
