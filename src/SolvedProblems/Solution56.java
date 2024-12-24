package SolvedProblems;

import java.util.*;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        // sort 2d array by the first int in each sub array
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        List<int[]> resultList = new ArrayList<>();
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];

        resultList.add(temp.clone());

        for (int i = 1; i < intervals.length; i++) {
            int[] mergedArray = new int[2];
            if (intervals[i][0] <= temp[1]) {
                mergedArray[0] = Math.min(temp[0], intervals[i][0]);
                mergedArray[1] = Math.max(temp[1], intervals[i][1]);
                resultList.remove(resultList.size()-1);
                resultList.add(mergedArray);
                temp = mergedArray.clone();
            } else {
                mergedArray[0] = intervals[i][0];
                mergedArray[1] = intervals[i][1];
                resultList.add(mergedArray);
                temp = mergedArray.clone();
            }

        }

        int[][] result = new int[resultList.size()][2];

        for (int i = 0; i < resultList.size(); i++) {
            for (int j = 0; j < resultList.get(i).length; j++) {
                temp[j] = resultList.get(i)[j];
            }

            result[i] = temp.clone();
        }

        return result;
    }
}
