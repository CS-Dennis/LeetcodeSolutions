package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {

        List<String> results = new ArrayList<>();
        createParenthesis(results, "", n, 0,0);

        return results;
    }

    private void createParenthesis(List<String> list, String currentString, int target, int openingParenthesis, int closingParenthesis) {
        if (currentString.length() < target * 2) {
            if (openingParenthesis == closingParenthesis) {
                createParenthesis(list, currentString+"(", target, openingParenthesis+1, closingParenthesis);
            }

            if (openingParenthesis > closingParenthesis) {
                if (openingParenthesis == target) {
                    createParenthesis(list, currentString+")", target, openingParenthesis, closingParenthesis+1);
                } else if (openingParenthesis < target) {
                    createParenthesis(list, currentString + "(", target, openingParenthesis+1, closingParenthesis);
                    createParenthesis(list, currentString + ")", target, openingParenthesis, closingParenthesis+1);
                }
            }
        } else if (currentString.length() == target * 2){
            list.add(currentString);
        }
    }
}
