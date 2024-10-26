public class Solution58 {
    public int lengthOfLastWord(String s) {
        String[] sList = s.split(" ");
        return sList[sList.length-1].length();
    }
}
