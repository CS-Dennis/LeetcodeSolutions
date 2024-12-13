public class Solution70 {
    public int climbStairs(int n) {
        Integer[] ways = new Integer[]{0};
        findUniqueWays(n, ways);
        return ways[0];
    }

    void findUniqueWays(int currentStairs, Integer[] ways) {
        if (currentStairs <= 1) {
            ways[0] = ways[0] + 1;
        } else {
            findUniqueWays(currentStairs - 1, ways);
            findUniqueWays(currentStairs - 2, ways);
        }
    }
}
