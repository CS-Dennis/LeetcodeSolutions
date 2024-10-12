package SolvedProblems;

public class Solution6 {
    public String convert(String s, int numRows) {
        StringBuilder[] sbList = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbList[i] = new StringBuilder();
        }
        StringBuilder result = new StringBuilder();

        boolean downWard = true;

        for (int i = 0; i < s.length(); ) {
            if(downWard){
                for (int j = 0; j < numRows; j++) {
                    if (i >= s.length()){
                        break;
                    }
                    sbList[j].append(s.charAt(i));
                    i++;
                }
                downWard = false;
            } else {
                for (int j = 0; j < numRows-2; j++) {
                    if (i >= s.length()){
                        break;
                    }
                    sbList[numRows-2-j].append(s.charAt(i));
                    i++;
                }
                downWard = true;
            }
        }

        for (int i = 0; i < sbList.length; i++) {
            result.append(sbList[i].toString());
        }

        return result.toString();
    }
}
