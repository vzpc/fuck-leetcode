package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        int result = solution.evalRPN(tokens);
        System.out.println(result);
    }

    private static class Solution {

        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for (String token : tokens) {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int result = 0;
                    switch (token) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                    }
                    stack.push(result);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
}
