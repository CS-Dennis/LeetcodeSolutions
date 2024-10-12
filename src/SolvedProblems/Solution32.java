package SolvedProblems;

import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        int maxLength = 0;

//        stack approch
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.add(i);
            } else {
                stack.pop();

                if(stack.isEmpty()){
                    stack.add(i);
                } else {
                    if(maxLength< i-stack.peek()){
                        maxLength = i-stack.peek();
                    }
                }
            }
        }

        return maxLength;
    }
}
