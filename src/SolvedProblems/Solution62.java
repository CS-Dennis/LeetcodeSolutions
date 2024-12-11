package SolvedProblems;


public class Solution62 {
    public int uniquePaths(int m, int n) {
        Integer[] i = {0};
        findPaths(m, n, i);
        return i[0];
    }

    void findPaths(int m, int n, Integer[] array) {
        if(m==1 || n==1) {
            array[0] = array[0]+1;
            return;
        }
        if (m > 1) {
            findPaths(m - 1, n, array);
        }
        if (n > 1) {
            findPaths(m, n - 1, array);
        }
    }
}
