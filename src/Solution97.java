import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        List<Boolean> result = new ArrayList<>();
        result.add(false);

        if (s1.isEmpty() && s2.equals(s3)) {
            return true;
        } else if (s2.isEmpty() && s1.equals(s3)) {
            return true;
        } else if (s3.length() != s1.length() + s2.length()) {
            return false;
        } else {
            findInterLeave(s1, s2, s3, result);
            return result.get(0);
        }
    }

    private void findInterLeave(String remainingS1, String remainingS2, String remainingS3, List<Boolean> result) {
        if(result.get(0)){
            return;
        }

        if (remainingS1.isEmpty() && remainingS2.isEmpty() && remainingS3.isEmpty()) {
            result.set(0, true);
            return;
        }

        if (!remainingS1.isEmpty() && remainingS1.charAt(0) == remainingS3.charAt(0)) {
            findInterLeave(remainingS1.substring(1), remainingS2.substring(0), remainingS3.substring(1), result);
        }

        if (!remainingS2.isEmpty() && remainingS2.charAt(0) == remainingS3.charAt(0)) {
            findInterLeave(remainingS1.substring(0), remainingS2.substring(1), remainingS3.substring(1), result);
        }
    }
}


