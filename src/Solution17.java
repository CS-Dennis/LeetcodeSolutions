import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.equals("")){
            return result;
        }

        Map<Integer, String[]> mapping = new HashMap<>();
        mapping.put(2, new String[]{"a", "b", "c"});
        mapping.put(3, new String[]{"d", "e", "f"});
        mapping.put(4, new String[]{"g", "h", "i"});
        mapping.put(5, new String[]{"j", "k", "l"});
        mapping.put(6, new String[]{"m", "n", "o"});
        mapping.put(7, new String[]{"p", "q", "r", "s"});
        mapping.put(8, new String[]{"t", "u", "v"});
        mapping.put(9, new String[]{"w", "x", "y", "z"});

        int length = digits.length();

        List<String[]> comboList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            comboList.add(mapping.get(Integer.valueOf(String.valueOf(digits.charAt(i)))));
        }

        List<String> mixResults = new ArrayList<>();
        mixResults.add("");
        return mixLetters(comboList, 0, mixResults);
    }

    private List<String> mixLetters(List<String[]> lists, int index, List<String> mixedResults){
        if(index< lists.size()){
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < mixedResults.size(); i++) {
                for (int j = 0; j < lists.get(index).length; j++) {
                    String newString = mixedResults.get(i)+lists.get(index)[j];
                    temp.add(newString);
                }
            }
            index++;
            return mixLetters(lists, index, temp);
        } else {
            return mixedResults;
        }
    }
}
