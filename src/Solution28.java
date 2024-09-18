public class Solution28 {
//    Example 1:
//
//    Input: haystack = "sadbutsad", needle = "sad"
//    Output: 0
//    Explanation: "sad" occurs at index 0 and 6.
//    The first occurrence is at index 0, so we return 0.

//    Example 2:
//
//    Input: haystack = "leetcode", needle = "leeto"
//    Output: -1
//    Explanation: "leeto" did not occur in "leetcode", so we return -1.

    public int strStr(String haystack, String needle) {
        int index = -1;
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (needleLength > haystackLength) {
            return -1;
        }
        else if (needleLength == haystackLength) {
            if (needle.equals(haystack)) {
                return 0;
            } else {
                return -1;
            }
        }
        else {
            boolean flag = true;
            for (int i = 0; i <= haystackLength-needleLength; i++) {
                flag = true;
                for (int j = i; j < i+needleLength; j++) {
                    if(haystack.charAt(j)!=needle.charAt(j-i)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    index = i;
                    break;
                }
            }

            return index;
        }


    }
}
