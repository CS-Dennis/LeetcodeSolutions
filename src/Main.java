import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[][] nums = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//                {17, 18, 19, 20},
//                {21, 22, 23, 24}
//
//        };

        int[][] nums = {
                {2, 3, 4},
                {5, 6, 7},
                {8, 9, 10},
                {11,12,13},
                {14,15,16},
        };
        Solution54 s = new Solution54();

        System.out.println(s.spiralOrder(nums));
    }
}