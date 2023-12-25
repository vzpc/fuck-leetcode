package org.example.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        List<String> result = solution.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static class Solution {

        private static final String LEFT = "(";
        private static final String RIGHT = ")";

        public List<String> generateParenthesis(int n) {
            return generateParenthesis(n, n);
        }

        public List<String> generateParenthesis(int leftCount, int rightCount) {
            List<String> result = new ArrayList<>();
            if (leftCount == 0 && rightCount == 0) {
                return result;
            }
            if (leftCount == 0) {
                StringBuffer parenthesis = new StringBuffer();
                for (int i = 0; i < rightCount; i++) {
                    parenthesis.append(RIGHT);
                }
                result.add(parenthesis.toString());
                return result;
            }
            if (leftCount == rightCount) {
                List<String> subResult = generateParenthesis(leftCount - 1, rightCount);
                for (String s : subResult) {
                    result.add(LEFT + s);
                }
            } else {
                List<String> subResult = generateParenthesis(leftCount - 1, rightCount);
                for (String s : subResult) {
                    result.add(LEFT + s);
                }
                subResult = generateParenthesis(leftCount, rightCount - 1);
                for (String s : subResult) {
                    result.add(RIGHT + s);
                }
            }
            return result;
        }
    }
}
