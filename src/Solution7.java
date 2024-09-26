public class Solution7 {
    public int reverse(int x) {
        return method2(x);
    }

//    method1 is logically simpler, but string and integer conversion is more costly than math operation of method2
    public int method1(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        String[] digits = s.split("");
        long result = 0;
        try {
            if(x<0){
                for (int i = length-1; i >=1 ; i--) {
                    result += Long.valueOf(String.valueOf(s.charAt(i))) * ((int) Math.pow(10, i-1));;
                    if(result> Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                        return 0;
                    }
                }
                result = result*(-1);
            } else {
                for (int i = length-1; i >=0 ; i--) {
                    result += Long.valueOf(String.valueOf(s.charAt(i))) * ((int) Math.pow(10, i));
                    if(result> Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                        return 0;
                    }
                }
            }

            return (int) result;
        } catch (Exception ex){
            return 0;
        }
    }

//    using mods to get each digit and calculate the result, faster than method1
    private int method2(int x){
        boolean positive = true;
        if(x<0){
            positive = false;
            x = -1*x;
        }
        int length = 1;
        int temp = x;
        while(temp>0){
            temp = temp/10;
            if(temp>=1){
                length = length*10;
            }
        }


        long result = 0;
        temp = x;
        while(temp>0){
            long digit = temp%10;
            temp = temp/10;
            result += digit*length;
            length = length/10;
            if(result> Integer.MAX_VALUE || result<Integer.MIN_VALUE){
                return 0;
            }
        }

        if(!positive){
            result = result*(-1);
        }

        return (int) result;
    }
}
