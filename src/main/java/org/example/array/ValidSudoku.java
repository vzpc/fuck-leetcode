package org.example.array;

import java.util.HashMap;
import java.util.Map;

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
            Map<Integer, Map<Character, Integer>> sudokuMap = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (!(board[i][j] >= '1' && board[i][j] <= '9')) {
                        if (board[i][j] != '.') {
                            return false;
                        } else {
                            continue;
                        }
                    }
                    int rowKey = i;
                    int columnKey = 9 + j;
                    int gridKey = 18 + i / 3 + (j / 3) * 3;
                    if (sudokuMap.containsKey(rowKey)) {
                        Map<Character, Integer> sudokuRowMap = sudokuMap.get(rowKey);
                        if (sudokuRowMap.containsKey(board[i][j])) {
                            return false;
                        } else {
                            sudokuRowMap.put(board[i][j], 1);
                        }
                    } else {
                        Map<Character, Integer> sudokuRowMap = new HashMap<>();
                        sudokuRowMap.put(board[i][j], 1);
                        sudokuMap.put(rowKey, sudokuRowMap);
                    }
                    if (sudokuMap.containsKey(columnKey)) {
                        Map<Character, Integer> sudokuColumnMap = sudokuMap.get(columnKey);
                        if (sudokuColumnMap.containsKey(board[i][j])) {
                            return false;
                        } else {
                            sudokuColumnMap.put(board[i][j], 1);
                        }
                    } else {
                        Map<Character, Integer> sudokuColumnMap = new HashMap<>();
                        sudokuColumnMap.put(board[i][j], 1);
                        sudokuMap.put(columnKey, sudokuColumnMap);
                    }
                    if (sudokuMap.containsKey(gridKey)) {
                        Map<Character, Integer> sudokuGridMap = sudokuMap.get(gridKey);
                        if (sudokuGridMap.containsKey(board[i][j])) {
                            return false;
                        } else {
                            sudokuGridMap.put(board[i][j], 1);
                        }
                    } else {
                        Map<Character, Integer> sudokuGridMap = new HashMap<>();
                        sudokuGridMap.put(board[i][j], 1);
                        sudokuMap.put(gridKey, sudokuGridMap);
                    }
                }
            }
            return true;
        }
    }
}
