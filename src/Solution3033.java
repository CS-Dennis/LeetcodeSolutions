import java.util.ArrayList;

public class Solution3033 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        ArrayList<Integer> matrixColMax = new ArrayList<>();

        for (int i = 0; i < cols; i++) {

            int max = -1;
            for (int j = 0; j <rows; j++) {
                if(matrix[j][i] > max){
                    max = matrix[j][i];
                }

            }
            matrixColMax.add(max);

        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if(matrix[j][i]==-1){
                    matrix[j][i] = matrixColMax.get(i);
                }
            }
        }


        return matrix;
    }
}
