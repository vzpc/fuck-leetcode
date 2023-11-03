package org.example.array;

public class ValidSudoku {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = solution.isValidSudoku(board);
        System.out.println(result);
        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result2 = solution.isValidSudoku(board2);
        System.out.println(result2);
    }

    private static class Solution {

        public boolean isValidSudoku(char[][] board) {
            int[][] sudokuMap = new int[27][9];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (!(board[i][j] >= '1' && board[i][j] <= '9')) {
                        return false;
                    }
                    int rowKey = i;
                    int columnKey = 9 + j;
                    int gridKey = 18 + i / 3 + (j / 3) * 3;
                    int index = board[i][j] - '1';
                    sudokuMap[rowKey][index]++;
                    sudokuMap[columnKey][index]++;
                    sudokuMap[gridKey][index]++;
                    if (sudokuMap[rowKey][index] > 1 || sudokuMap[columnKey][index] > 1 || sudokuMap[gridKey][index] > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
