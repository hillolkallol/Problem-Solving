/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 289. Game of Life
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class Leetcode_289_GameofLife {
    
}

class Solution35 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        
        int row_len = board.length;
        int col_len = board[0].length;
        
        for (int row = 0; row < row_len; row++) {
            for (int col = 0; col < col_len; col++) {
                int count = countNeighbors(board, row, col, row_len, col_len);
                
                if (board[row][col] == 1 && count >=2 && count <=3)
                    board[row][col] = 3;
                if (board[row][col] == 0 && count == 3) 
                    board[row][col] = 2;
            }
        }
        
        for (int row = 0; row < row_len; row++) {
            for (int col = 0; col < col_len; col++) {
                board[row][col] >>= 1;
            }
        }
    }
    
    public int countNeighbors(int[][] board, int row, int col, int row_len, int col_len) {
        int count = 0;
        for (int j = Math.max(row-1, 0); j <= Math.min(row+1, row_len-1); j++) {
            for (int i = Math.max(col-1, 0); i <= Math.min(col+1, col_len-1); i++) {
                count += board[j][i] & 1;
            }
        }
        count -= board[row][col] & 1;
        return count;
    }
}

// class Solution {
//     public void gameOfLife(int[][] board) {
//         int[][] newBoard = new int[board.length][];
//         for(int i = 0; i < board.length; i++)
//             newBoard[i] = board[i].clone();
        
//         System.out.println(3 & 1);
//         for (int row = 0; row < board.length; row++) {
//             for (int col = 0; col < board[0].length; col++) {
//                 checkNeighborsAndUpdate(board, newBoard, row, col);
//             }
//         }
//     }
    
//     public void checkNeighborsAndUpdate(int[][] board, int[][] newBoard, int row, int col) {
//         int count = 0;
//         if (row > 0 && col > 0 && newBoard[row-1][col-1] == 1) 
//             count++;
//         if (row > 0 && newBoard[row-1][col] == 1) 
//             count++;
//         if (row > 0 && col < board[0].length-1 && newBoard[row-1][col+1] == 1) 
//             count++;
//         if (col < board[0].length-1 && newBoard[row][col+1] == 1) 
//             count++;
//         if (row < board.length-1 && col < board[0].length-1 && newBoard[row+1][col+1] == 1) 
//             count++;
//         if (row < board.length-1 && newBoard[row+1][col] == 1) 
//             count++;
//         if (row < board.length-1 && col > 0 && newBoard[row+1][col-1] == 1) 
//             count++;
//         if (col > 0 && newBoard[row][col-1] == 1) 
//             count++;
        
//         if (count < 2) board[row][col] = 0;
//         else if (count == 3) board[row][col] = 1;
//         else if (count > 3) board[row][col] = 0;
        
//     }
// }


