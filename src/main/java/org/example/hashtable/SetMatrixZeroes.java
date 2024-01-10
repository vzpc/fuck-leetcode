package org.example.hashtable;

public class SetMatrixZeroes {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        for (int[] array : matrix) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static class Solution {

        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean flagCol0 = false;
            boolean flagRow0 = false;
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    flagCol0 = true;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    flagRow0 = true;
                    break;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1 ; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                     if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                          matrix[i][j] = 0;
                     }
                }
            }
            if (flagCol0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (flagRow0) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }
        }
    }
}
