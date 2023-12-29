package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solution.trap(height);
        System.out.println(result);
    }

    private static class Solution {

        public int trap(int[] height) {
            Deque<Integer> stack = new LinkedList<>();
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int bottom = height[stack.pop()];
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int right = i;
                    int h = Math.min(height[left], height[right]) - bottom;
                    result += (right - left - 1) * h;
                }
                stack.push(i);
            }
            return result;
        }
    }
}
