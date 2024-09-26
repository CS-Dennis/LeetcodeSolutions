import java.util.ArrayList;

public class Solution9 {
    public boolean isPalindrome(int x) {
        boolean positive = x >= 0;

        if (!positive) {
            return false;
        }

        int temp = x;
        int temp2 = 0;


        int length = 0;
        while (temp >= 1) {
            temp = temp / 10;
            length++;
        }

        int[] list = new int[length];
        temp = x;
        int index = 0;
        while (temp >= 1) {
            list[index] = temp%10;
            temp = temp / 10;
            length++;
            index++;
        }

        int listSize = index;

        for (int i = 0; i < listSize; i++) {
            temp2 += list[i] * ((int) Math.pow(10, listSize - i - 1));
        }

        return temp2 == x;
    }
}
