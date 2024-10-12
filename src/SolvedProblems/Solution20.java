package SolvedProblems;

public class Solution20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                sb.append(s.charAt(i));
            } else {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    sb.append(s.charAt(i));
                } else {
                    if (!sb.isEmpty() && ((sb.charAt(sb.length() - 1) == '(' && s.charAt(i) == ')') || (sb.charAt(sb.length() - 1) == '[' && s.charAt(i) == ']') || (sb.charAt(sb.length() - 1) == '{' && s.charAt(i) == '}'))) {
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        return false;
                    }
                }

            }
        }

        return sb.isEmpty();
    }
}
