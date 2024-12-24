package SolvedProblems;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[] array = {0};
        findPaths(m, n, array, obstacleGrid);
        return array[0];
    }

    void findPaths(int m, int n, Integer[] array, int[][] grid){

        if(m==1 && n==1 && grid[grid.length-1][grid[0].length-1]==0){
            array[0] += 1;
            return;
        }

        if(m>1){
            if(grid[m-2][n-1]==0){
                findPaths(m-1, n, array, grid);
            }
        }

        if(n>1){
            if(grid[m-1][n-2]==0){
                findPaths(m, n-1, array, grid);
            }
        }
    }
}
