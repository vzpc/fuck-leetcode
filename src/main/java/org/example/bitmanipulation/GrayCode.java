package org.example.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        List<Integer> result = solution.grayCode(3);
        for (Integer i: result) {
            System.out.println(i);
        }
    }

    private static class Solution {

        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < 1 << n; i++) {
                result.add(i ^ i >> 1);
            }
            return result;
        }

    }
}
