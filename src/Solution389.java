public class Solution389 {
    public char findTheDifference(String s, String t) {
        if (s.isEmpty()) {
            return t.toCharArray()[0];
        }
        char result;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int sChars = 0;
        int tChars = 0;
        for (char c : sArray) {
            sChars += c;
        }

        for(char c: tArray){
            tChars+=c;
        }

        result  = (char) (tChars-sChars);

        return result;
    }
}
