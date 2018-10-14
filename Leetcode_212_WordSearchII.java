/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 212. Word Search II
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.


 */
import java.util.*;
public class Leetcode_212_WordSearchII {
    
}
class Solution56 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == word.charAt(0)) {
                        dfs(board, row, col, word, 1, res, set); 
                    }
                }
            }
        }
        
        return res;
    }
    
    public void dfs(char[][] board, int row, int col, String word, int idx, List<String> res, Set<String> set) {        
        if (idx >= word.length()) {
            if (!set.contains(word)) {
                set.add(word);
                res.add(word);
            }
            return;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        
        if (row > 0 && board[row-1][col] == word.charAt(idx)) 
            dfs(board, row-1, col, word, idx+1, res, set);
        if (col > 0 && board[row][col-1] == word.charAt(idx)) 
            dfs(board, row, col-1, word, idx+1, res, set);
        if (row < board.length-1 && board[row+1][col] == word.charAt(idx)) 
            dfs(board, row+1, col, word, idx+1, res, set);
        if (col < board[0].length-1 && board[row][col+1] == word.charAt(idx)) 
            dfs(board, row, col+1, word, idx+1, res, set);
        
        board[row][col] = temp;
    }
}