import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);

        return getPascalRow(temp, 2, rowIndex);
    }

    private List<Integer> getPascalRow(List<Integer> lastPascalRow, int currentRowIndex, int targetRowIndex){
        List<Integer> temp = new ArrayList<>();
        if(targetRowIndex==0){
            temp.add(1);
            return temp;
        } else if(targetRowIndex==1) {
            temp.add(1);
            temp.add(1);
            return temp;
        } else if(targetRowIndex>=2) {
            temp.add(1);
            for (int i = 0; i <= lastPascalRow.size()-2; i++) {
                temp.add(lastPascalRow.get(i)+lastPascalRow.get(i+1));
            }
            temp.add(1);

            if(currentRowIndex==targetRowIndex){
                return temp;
            } else {
                return getPascalRow(temp, currentRowIndex+1, targetRowIndex);
            }
        }

        return null;
    }
}
