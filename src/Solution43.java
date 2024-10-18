public class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int[] resultArray = new int[num1.length()+num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int product = Integer.parseInt(String.valueOf(num1.charAt(i))) * Integer.parseInt(String.valueOf(num2.charAt(j)));

                int firstDigit = product%10;
                int secondDigit = product/10;

                resultArray[i+j+1] += firstDigit;
                resultArray[i+j] += secondDigit;

            }
        }

        int promotion = 0;
        for (int i = resultArray.length-1; i >=0 ; i--) {
            if(promotion>0){
                resultArray[i] += promotion;
                promotion=0;
            }

            if(resultArray[i]/10>0){
                promotion = resultArray[i]/10;
                resultArray[i] = resultArray[i]%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i: resultArray){
            sb.append(i);
        }

        if(sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}