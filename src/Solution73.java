import java.util.ArrayList;
import java.util.List;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> identifiedRows = new ArrayList<>();
        List<Integer> identifiedCols = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    identifiedRows.add(i);
                    identifiedCols.add(j);
                }
            }
        }

        if (!identifiedRows.isEmpty()) {
            for (Integer row : identifiedRows) {
                for (int i = 0; i < cols; i++) {
                    matrix[row][i] = 0;
                }
            }
        }

        if (!identifiedCols.isEmpty()) {
            for (Integer col : identifiedCols) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
    }
}
