import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] combinedIntervals = new int[intervals.length+1][2];

        for (int i = 0; i < intervals.length; i++) {
            combinedIntervals[i] = intervals[i];
        }
        combinedIntervals[combinedIntervals.length-1] = newInterval;
        
        Arrays.sort(combinedIntervals, (a,b)->a[0]-b[0]);

        List<int[]> resultList = new ArrayList<>();
        
        resultList.add(combinedIntervals[0]);
        int[] temp = combinedIntervals[0];

        for (int i = 1; i < combinedIntervals.length ; i++) {
            if(combinedIntervals[i][0]<=temp[1]){
                resultList.remove(resultList.size()-1);
                temp[0] = Math.min(temp[0], combinedIntervals[i][0]);
                temp[1] = Math.max(temp[1], combinedIntervals[i][1]);
                resultList.add(temp.clone());
            } else {
                temp = combinedIntervals[i];
                resultList.add(combinedIntervals[i]);
            }
        }
        
        int[][] result = new int[resultList.size()][2];

        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
