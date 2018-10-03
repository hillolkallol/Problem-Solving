/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 79. Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class Leetcode_79_WordSearch {
    
}
class Solutionas {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        for (int row = 0; row < board.length; row++) 
            for (int col = 0; col < board[0].length; col++) 
                if (dfs(board, row, col, letters, 0)) return true;
        return false;
    }
    
    public boolean dfs(char[][] board, int row, int col, char[] letters, int idx) {
        if (idx == letters.length) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (board[row][col] != letters[idx]) return false;
        char temp = board[row][col];
        board[row][col] = ' ';
        boolean result = dfs(board, row-1, col, letters, idx+1) || dfs(board, row+1, col, letters, idx+1) || 
            dfs(board, row, col-1, letters, idx+1) || dfs(board, row, col+1, letters, idx+1);
        board[row][col] = temp;
        return result;
    }
}