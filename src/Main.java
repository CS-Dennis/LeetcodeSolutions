import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        Solution1 s = new Solution1();

        int[] result = s.twoSum(a, 9);
        System.out.println(result[0]+", "+result[1]);

    }
}