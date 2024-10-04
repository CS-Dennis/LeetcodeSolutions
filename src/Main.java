import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        Solution30 abc = new Solution30();
        System.out.println(abc.findSubstring(s, words));
    }
}