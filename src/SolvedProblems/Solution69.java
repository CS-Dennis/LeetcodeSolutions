package SolvedProblems;

public class Solution69 {
    public int mySqrt(int x) {
        long start = 0;
        long mid = x/2;
        long end = x;
        if(x==0 || x==1){
            return x;
        }

        while(end>start){
            if(mid*mid< x){
                if(end-start<=2){
                    if(end*end==x) {
                        return (int) end;
                    } else {
                        return (int) mid;
                    }
                }
                start = mid;
                mid += (end-mid)/2;
            } else if(mid*mid==x){
                return (int) mid;
            } else {
                if(end-start<=2){
                    return (int) start;
                }
                end = mid;
                mid = start+(mid-start)/2;
            }
        }

        return 0;
    }
}