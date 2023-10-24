package org.example.array;

public class MedianOfTwoSortedArrays {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums1 = new int[2];
        nums1[0] = 1;
        nums1[1] = 2;
        int[] nums2 = new int[2];
        nums2[0] = 3;
        nums2[1] = 4;
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    private static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length <= nums2.length) {
                int length1 = nums1.length;
                int length2 = nums2.length;
                int start = 0;
                int end = length1;
                int pointer1;
                int pointer2;
                int leftMax1;
                int rightMin1;
                int leftMax2;
                int rightMin2;
                while (true) {
                    pointer1 = (start + end) / 2;
                    pointer2 = (length1 + length2 + 1) / 2 - pointer1;
                    if (pointer1 == 0) {
                        leftMax1 = Integer.MIN_VALUE;
                    } else {
                        leftMax1 = nums1[pointer1 - 1];
                    }
                    if (pointer2 == 0) {
                        leftMax2 = Integer.MIN_VALUE;
                    } else {
                        leftMax2 = nums2[pointer2 - 1];
                    }
                    if (pointer1 == length1) {
                        rightMin1 = Integer.MAX_VALUE;
                    } else {
                        rightMin1 = nums1[pointer1];
                    }
                    if (pointer2 == length2) {
                        rightMin2 = Integer.MAX_VALUE;
                    } else {
                        rightMin2 = nums2[pointer2];
                    }
                    if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                        if ((length1 + length2) % 2 == 1) {
                            return Math.max(leftMax1, leftMax2);
                        } else {
                            return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                        }
                    } else {
                        if (leftMax1 > rightMin2) {
                            end = pointer1 - 1;
                        } else if (leftMax2 > rightMin1) {
                            start = pointer1 + 1;
                        }
                    }
                }
            } else {
                return findMedianSortedArrays(nums2, nums1);
            }
        }
    }
}
