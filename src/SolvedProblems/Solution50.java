package SolvedProblems;

public class Solution50 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        double result = 1;

        int newN = n;
        if (newN < 0) {
            if (newN < -50) {
//                very small decimal, just return 0 for double
                return 0;
            } else {
                newN = -newN;
            }
        }
        while (newN > 0) {
            if (newN % 2 == 0) {
//                2* 2^16 =2 * 4^8
                x *= x;
                newN = newN / 2;
            } else {
//                2^17 = 2 * 2^16
                result *= x;
                newN--;
            }
        }
        return n < 0 ? 1 / result : result;
    }
}