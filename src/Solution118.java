import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();

            if(i==1){
                temp.add(i);
                result.add(temp);
            } else {
                temp.add(1);
                for (int j = 0; j <= result.get(i-2).size()-2; j++) {
                    temp.add(result.get(i-2).get(j)+result.get(i-2).get(j+1));
                }
                temp.add(1);
                result.add(temp);
            }
        }

        return result;
    }
}
