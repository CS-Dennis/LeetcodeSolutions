import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int cols = matrix[0].length;
        int rows = matrix.length;

        int topRowIndex = 0;
        int bottomRowIndex = rows - 1;

        boolean readRowNow = true;
        boolean topRowOn = true;
        boolean rightColOn = true;

        int widthDeduction = 0;

        while (topRowIndex <= bottomRowIndex) {
//            if reading row
            if (readRowNow) {
//                if reading top row -> left to right
                if (topRowOn) {
                    int count = 0;
                    for (int i = widthDeduction / 2; i <=(matrix[topRowIndex].length - 1 - widthDeduction / 2); i++) {
                        result.add(matrix[topRowIndex][i]);
                        count++;
                    }
                    if(count==0){
                        break;
                    }
                    widthDeduction++;
                    readRowNow = false;
                    rightColOn = true;
                    topRowIndex++;
                }
//              if reading bottom row -> right to left
                else {
                    if(widthDeduction/2+1 < cols){
                        int count = 0;
                        for (int i = cols - 1 - widthDeduction / 2 - 1; i >= widthDeduction / 2; i--) {
                            result.add(matrix[bottomRowIndex][i]);
                            count++;
                        }
                        if(count==0){
                            break;
                        }
                        widthDeduction++;
                        readRowNow = false;
                        rightColOn = false;
                        bottomRowIndex--;
                    } else {
                        break;
                    }
                }
            }
//            if reading col
            else {
//                if reading right col -> top to bottom
                if (rightColOn && widthDeduction / 2 + 1 <= cols) {
                    for (int i = widthDeduction / 2 + 1; i <= (matrix.length - 1 - widthDeduction / 2); i++) {

                        result.add(matrix[i][cols - 1 - widthDeduction / 2]);
                    }
                    readRowNow = true;
                    topRowOn = false;
                }
//                if reading left col -> bottom to top
                else {
                    for (int i = rows - 1 - widthDeduction / 2; i >= widthDeduction / 2; i--) {

                        result.add(matrix[i][widthDeduction / 2 - 1]);
                    }
                    readRowNow = true;
                    topRowOn = true;
                }
            }
        }

        return result;
    }
}
