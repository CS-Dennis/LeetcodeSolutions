package SolvedProblems;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int possibleRowIndex = 0;

        if (matrix[rows - 1][0] < target) {
            possibleRowIndex = rows - 1;
        } else {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == target) {
                    return true;
                } else if (matrix[i][0] > target) {
                    if (i == 0) {
                        return false;
                    } else {
                        possibleRowIndex = i - 1;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            if (matrix[possibleRowIndex][i] == target) {
                return true;
            }
        }

        return false;
    }
}
