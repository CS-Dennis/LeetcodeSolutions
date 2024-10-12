package SolvedProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        boolean valid = true;

        List<Integer> threeByThrees1 = new ArrayList<>();
        List<Integer> threeByThrees2 = new ArrayList<>();
        List<Integer> threeByThrees3 = new ArrayList<>();
        List<Integer> threeByThrees4 = new ArrayList<>();
        List<Integer> threeByThrees5 = new ArrayList<>();
        List<Integer> threeByThrees6 = new ArrayList<>();
        List<Integer> threeByThrees7 = new ArrayList<>();
        List<Integer> threeByThrees8 = new ArrayList<>();
        List<Integer> threeByThrees9 = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            List<Integer> numsInRow = new ArrayList<>();
            List<Integer> numsInColumn = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                //        get digits in rows
                if (board[i][j] != '.') {
                    numsInRow.add(Integer.valueOf(String.valueOf(board[i][j])));
                }

                //        get digits in columns
                if (board[j][i] != '.') {
                    numsInColumn.add(Integer.valueOf(String.valueOf(board[j][i])));
                }

                // get digits in 3x3
                if (i >= 0 && i <= 2) {
                    if (j >= 0 && j <= 2 && board[i][j]!='.') {
                        threeByThrees1.add(Integer.valueOf(String.valueOf(board[i][j])));
                    } else if (j >= 3 && j <= 5 && board[i][j]!='.') {
                        threeByThrees2.add(Integer.valueOf(String.valueOf(board[i][j])));
                    } else if (j >= 6 && j <= 8 && board[i][j]!='.') {
                        threeByThrees3.add(Integer.valueOf(String.valueOf(board[i][j])));
                    }
                } else if (i >= 3 && i <= 5) {
                    if (j >= 0 && j <= 2 && board[i][j]!='.') {
                        threeByThrees4.add(Integer.valueOf(String.valueOf(board[i][j])));
                    } else if (j >= 3 && j <= 5 && board[i][j]!='.') {
                        threeByThrees5.add(Integer.valueOf(String.valueOf(board[i][j])));
                    } else if (j >= 6 && j <= 8 && board[i][j]!='.') {
                        threeByThrees6.add(Integer.valueOf(String.valueOf(board[i][j])));
                    }
                } else if (i >= 6 && i <= 8) {
                    if (j >= 0 && j <= 2 && board[i][j]!='.') {
                        threeByThrees7.add(Integer.valueOf(String.valueOf(board[i][j])));
                    } else if (j >= 3 && j <= 5 && board[i][j]!='.') {
                        threeByThrees8.add(Integer.valueOf(String.valueOf(board[i][j])));
                    } else if (j >= 6 && j <= 8 && board[i][j]!='.') {
                        threeByThrees9.add(Integer.valueOf(String.valueOf(board[i][j])));
                    }
                }
            }

            //            check rows
            Set<Integer> uniqueNumsInRow = new HashSet<>(numsInRow);
            if (uniqueNumsInRow.size() != numsInRow.size()) {
                valid = false;
            }

            //            check columns
            Set<Integer> uniqueNumsInColumn = new HashSet<>(numsInColumn);
            if (uniqueNumsInColumn.size() != numsInColumn.size()) {
                valid = false;
            }
        }

        //            check all threeByThrees
        Set<Integer> uniqueNumsInThreeByThree1 = new HashSet<>(threeByThrees1);
        if(uniqueNumsInThreeByThree1.size() != threeByThrees1.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree2 = new HashSet<>(threeByThrees2);
        if(uniqueNumsInThreeByThree2.size() != threeByThrees2.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree3 = new HashSet<>(threeByThrees3);
        if(uniqueNumsInThreeByThree3.size() != threeByThrees3.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree4 = new HashSet<>(threeByThrees4);
        if(uniqueNumsInThreeByThree4.size() != threeByThrees4.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree5 = new HashSet<>(threeByThrees5);
        if(uniqueNumsInThreeByThree5.size() != threeByThrees5.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree6 = new HashSet<>(threeByThrees6);
        if(uniqueNumsInThreeByThree6.size() != threeByThrees6.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree7 = new HashSet<>(threeByThrees7);
        if(uniqueNumsInThreeByThree7.size() != threeByThrees7.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree8 = new HashSet<>(threeByThrees8);
        if(uniqueNumsInThreeByThree8.size() != threeByThrees8.size()){
            valid = false;
        }

        Set<Integer> uniqueNumsInThreeByThree9 = new HashSet<>(threeByThrees9);
        if(uniqueNumsInThreeByThree9.size() != threeByThrees9.size()){
            valid = false;
        }

        return valid;
    }
}
