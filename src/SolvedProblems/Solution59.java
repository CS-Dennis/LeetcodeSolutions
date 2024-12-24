package SolvedProblems;

public class Solution59 {
    public int[][] generateMatrix(int n) {
//      clock wise spiral
//      0: top right, 1: right down, 2: bottom left, 3: left up
        int direction = 0;

//      1: drop 1 length, 3: drop 1 length
        int currentLength = n;

//      increase on direction == 0
        int numOfCircles = -1;
        int currentVal = 1;

        if (n == 1) {
            return new int[][]{{1}};
        } else {
//            n by n matrix
            int[][] result = new int[n][n];
            boolean stop = false;
            while (!stop) {

//                going top right
                if (direction == 0) {
                    numOfCircles++;
                    for (int i = 0; i < currentLength; i++) {
                        result[numOfCircles][i+numOfCircles] = currentVal;
                        if (currentVal == n * n) {
                            stop = true;
                            break;
                        }
                        currentVal++;
                    }

                    direction++;
                }
//                going right down
                else if (direction == 1) {
                    currentLength--;
                    for (int i = 0; i < currentLength; i++) {
                        result[n - currentLength - numOfCircles + i][n - numOfCircles - 1] = currentVal;
                        if (currentVal == n * n) {
                            stop = true;
                            break;
                        }
                        currentVal++;
                    }
                    direction++;
                }
//                going bottom left
                else if (direction == 2) {
                    for (int i = 0; i < currentLength; i++) {
                        result[n - numOfCircles - 1][n-i-numOfCircles-2] = currentVal;
                        if (currentVal == n * n) {
                            stop = true;
                            break;
                        }
                        currentVal++;
                    }
                    direction++;
                }
//                going left up
                else if (direction == 3) {
                    currentLength--;

                    for (int i = 0; i < currentLength; i++) {
                        result[n-i-numOfCircles-2][numOfCircles] = currentVal;
                        if (currentVal == n * n) {
                            stop = true;
                            break;
                        }
                        currentVal++;
                    }

                    direction = 0;
                }
            }

            return result;
        }
    }
}
