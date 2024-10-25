package SolvedProblems;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }


        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix[0].length-1; j >=0; j--) {
                newMatrix[i][matrix[0].length-1-j] = matrix[j][i];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}
