package StackDemo;

import java.util.Stack;

public class NC49 {
    public int longestValidParentheses (String s) {
        // write code here
        int maxAns = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else {
                    maxAns = Math.max(maxAns,i - stack.peek());
                }
            }
        }

        return maxAns;
    }

    public static void main(String[] args) {
        String s = "(())";
        NC49 nc49 = new NC49();
        int i = nc49.longestValidParentheses(s);
        System.out.println(i);
    }
}
