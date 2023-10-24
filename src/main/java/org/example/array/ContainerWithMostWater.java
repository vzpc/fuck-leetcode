package org.example.array;

public class ContainerWithMostWater {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        System.out.println(result);
    }

    private static class Solution {

        public int maxArea(int[] height) {
            int start = 0;
            int end = height.length - 1;
            int maxArea = 0;
            int width, minHeight, area;
            while (start < end) {
               width = end - start;
               if (height[start] <= height[end]) {
                   minHeight = height[start];
                   start++;
               } else {
                   minHeight = height[end];
                   end--;
               }
                area = width * minHeight;
                if (maxArea < area) {
                    maxArea = area;
                }
            }
            return maxArea;
        }
    }
}
