package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        boolean promote = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i]++;
            }

            if (promote) {
                digits[i]++;
            }
            promote = false;

            if (digits[i] == 10) {
                digits[i] = 0;
                promote = true;
            }
            list.add(digits[i]);
        }

        if (promote) {
            list.add(1);
        }

        int[] result = new int[list.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[result.length - i - 1] = list.get(i);
        }

        return result;
    }
}
