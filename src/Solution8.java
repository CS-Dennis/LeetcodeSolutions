public class Solution8 {
    public int myAtoi(String s) {
//        sanitization of String s
        s = s.stripLeading();
        if (s.isEmpty()) {
            return 0;
        }
        boolean positive = true;
        if (s.charAt(0) == '-') {
            positive = false;
            s = s.substring(1);
        } else if(s.charAt(0) == '+'){
            s = s.substring(1);
        }

        boolean initZero = true;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && initZero) {
                continue;
            } else if (!String.valueOf(s.charAt(i)).matches("\\d")) {
                break;
            } else {
                initZero = false;
                result.append(s.charAt(i));
            }
        }

        int length = result.length();
        long resultInt = 0;

        if(length>10){
            if(positive){
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }


        if (result.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i< length; i++) {
                long temp = Long.valueOf(String.valueOf(result.charAt(i))) * ((long) Math.pow(10, length-i-1));
                resultInt += temp;

                if(resultInt> Integer.MAX_VALUE){
                    if(positive){
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            }

            if(!positive){
                resultInt = resultInt*(-1);
            }

            return (int) resultInt;
        }
    }
}
