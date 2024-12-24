package SolvedProblems;

import java.util.regex.Pattern;

public class Solution65 {
    public boolean isNumber(String s) {
        if(validInteger(s) || validDecimal(s)){
            return true;
        } else {
            return false;
        }
    }

    boolean validInteger(String s){
        if(Pattern.matches("[-+]?\\d+", s)){
            return true;
        } else if(Pattern.matches("[-+]?\\d+[eE][-+]?\\d+", s)) {
            return true;
        } else {
            return false;
        }
    }

    boolean validDecimal(String s){
        if(Pattern.matches("[-+]?\\d+\\.",s) || Pattern.matches("[-+]?\\d+\\.\\d+",s) || Pattern.matches("[-+]?\\.\\d+",s)){
            return true;
        } else if (Pattern.matches("[-+]?\\d+\\.[eE][-+]?\\d+",s) || Pattern.matches("[-+]?\\d+\\.\\d+[eE][-+]?\\d+",s) || Pattern.matches("[-+]?\\.\\d+[eE][-+]?\\d+",s)){
            return true;
        } else {
            return false;
        }
    }

//    boolean validExponent(String s){
//        return Pattern.matches("[eE]\\d+", s);
//    }
}
