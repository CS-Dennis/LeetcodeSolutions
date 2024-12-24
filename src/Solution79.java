import java.util.ArrayList;
import java.util.List;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        char initChar = word.charAt(0);
        List<Boolean> results = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == initChar) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(row);
                    temp.add(col);
                    List<List<Integer>> usedCells = new ArrayList<>();
                    usedCells.add(temp);
                    findWord(board, col, row, "", word, usedCells, results);
                    if (!results.isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void findWord(char[][] board, int indexCol, int indexRow, String currentString, String word, List<List<Integer>> usedCells, List<Boolean> results) {
        currentString += String.valueOf(board[indexRow][indexCol]);

        if (currentString.equals(word)) {
            results.add(true);
        } else {
            char nextChar = word.charAt(currentString.length());
            List<Integer> rightCell = new ArrayList<>();
            rightCell.add(indexRow);
            rightCell.add(indexCol + 1);

            List<Integer> leftCell = new ArrayList<>();
            leftCell.add(indexRow);
            leftCell.add(indexCol - 1);

            List<Integer> upCell = new ArrayList<>();
            upCell.add(indexRow - 1);
            upCell.add(indexCol);

            List<Integer> downCell = new ArrayList<>();
            downCell.add(indexRow + 1);
            downCell.add(indexCol);

            if (indexCol + 1 <= board[0].length - 1 && board[indexRow][indexCol + 1] == nextChar && !usedCells.contains(rightCell)) {
                List<List<Integer>> newUsedCells = new ArrayList<>(usedCells);
                newUsedCells.add(rightCell);
                findWord(board, indexCol + 1, indexRow, currentString, word, newUsedCells, results);
            }

            if (indexCol - 1 >= 0 && board[indexRow][indexCol - 1] == nextChar && !usedCells.contains(leftCell)) {
                List<List<Integer>> newUsedCells = new ArrayList<>(usedCells);
                newUsedCells.add(leftCell);
                findWord(board, indexCol - 1, indexRow, currentString, word, newUsedCells, results);
            }

            if (indexRow + 1 <= board.length - 1 && board[indexRow + 1][indexCol] == nextChar && !usedCells.contains(downCell)) {
                List<List<Integer>> newUsedCells = new ArrayList<>(usedCells);
                newUsedCells.add(downCell);
                findWord(board, indexCol, indexRow + 1, currentString, word, newUsedCells, results);
            }

            if (indexRow - 1 >= 0 && board[indexRow - 1][indexCol] == nextChar && !usedCells.contains(upCell)) {
                List<List<Integer>> newUsedCells = new ArrayList<>(usedCells);
                newUsedCells.add(upCell);
                findWord(board, indexCol, indexRow - 1, currentString, word, newUsedCells, results);
            }
        }
    }
}
