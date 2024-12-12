public class Solution64 {
    public int minPathSum(int[][] grid) {
        Integer[] array = new Integer[]{-1};
        int rows = grid.length;
        int cols = grid[0].length;
        int currentSum = grid[0][0];
        findPath(rows, cols, currentSum, array, grid, rows, cols);
//        System.out.println(list);
        return array[0];
    }

    void findPath(int m, int n, int currentSum, Integer[] array, int[][] grid, int rows, int cols) {
        if (m == 1 && n == 1) {
            if (array[0] == -1) {
                array[0] = currentSum;
            } else if (array[0] > currentSum) {
                array[0] = currentSum;
            }
            return;
        }

        if (m > 1) {
            findPath(m - 1, n, currentSum + grid[rows - m + 1][cols - n], array, grid, rows, cols);
        }

        if (n > 1) {
            findPath(m, n - 1, currentSum + grid[rows - m][cols - n + 1], array, grid, rows, cols);
        }
    }
}
