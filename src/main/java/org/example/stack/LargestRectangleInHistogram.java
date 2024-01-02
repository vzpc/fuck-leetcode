package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] height = new int[]{2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(height);
        System.out.println(result);
    }

    private static class Solution {

        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();

            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
            }
            return result;
        }
    }
}
