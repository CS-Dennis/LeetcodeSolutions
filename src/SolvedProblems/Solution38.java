package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution38 {
    public String countAndSay(int n) {
        return generateString(n, 1, "1");
    }

    private String generateString(int targetN, int startN, String s) {
        if (targetN == 1) {
            return "1";
        } else if (startN < targetN) {
            List<String> stringList = new ArrayList<>();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i == 0) {
                    temp = new StringBuilder(s.substring(0, 1));
                } else if (s.charAt(i - 1) == s.charAt(i)) {
                    temp.append(s.charAt(i));
                } else if (s.charAt(i - 1) != s.charAt(i)) {
                    stringList.add(temp.toString());
                    temp = new StringBuilder(s.substring(i, i + 1));
                }
            }
            stringList.add(temp.toString());

//            reset temp
            temp = new StringBuilder();
            for (int i = 0; i < stringList.size(); i++) {
                temp.append(stringList.get(i).length()).append(stringList.get(i).charAt(0));
            }
            startN++;
            return generateString(targetN, startN, temp.toString());
        } else if (startN == targetN) {
            return s;
        }

        return "";
    }
}
