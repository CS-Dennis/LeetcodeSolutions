import java.util.ArrayList;

public class Solution12 {
    public String intToRoman(int num) {
//        1 <= num <= 3999
        int length = 0;
        int temp = num;
        ArrayList<Integer> digits = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        while (temp >= 1) {
            digits.add(temp % 10);
            temp = temp / 10;
            length++;
        }

        for (int i = length - 1; i >= 0; i--) {
//            in 1000s
            if (i == 3) {
                for (int j = 0; j < digits.get(i); j++) {
                    result.append("M");
                }
            }
//            in 100s
            else if (i == 2) {
                if (digits.get(i) == 4) {
                    result.append("CD");
                } else if (digits.get(i) == 9) {
                    result.append("CM");
                } else if (digits.get(i) <= 3) {
                    for (int j = 0; j < digits.get(i); j++) {
                        result.append("C");
                    }
                } else {
                    result.append("D");
                    for (int j = 0; j < digits.get(i) - 5; j++) {
                        result.append("C");
                    }
                }
            }
//            in 10s
            else if (i == 1) {
                if (digits.get(i) == 4) {
                    result.append("XL");
                } else if (digits.get(i) == 9) {
                    result.append("XC");
                } else if (digits.get(i) <= 3) {
                    for (int j = 0; j < digits.get(i); j++) {
                        result.append("X");
                    }
                } else {
                    result.append("L");
                    for (int j = 0; j < digits.get(i) - 5; j++) {
                        result.append("X");
                    }
                }
            }
//            single digit
            else if(i==0) {
                if(digits.get(i)==4){
                    result.append("IV");
                } else if(digits.get(i)==9){
                    result.append("IX");
                } else if(digits.get(i)<=3){
                    for (int j = 0; j < digits.get(i); j++) {
                        result.append("I");
                    }
                } else {
                    result.append("V");
                    for (int j = 0; j < digits.get(i)-5; j++) {
                        result.append("I");
                    }
                }
            }

        }

        return result.toString();
    }
}
