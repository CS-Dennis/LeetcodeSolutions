public class Solution10 {
    public boolean isMatch(String s, String p) {
//        using regex to solve regex problems; not reinventing the wheel
        return s.matches(p);
    }
}
