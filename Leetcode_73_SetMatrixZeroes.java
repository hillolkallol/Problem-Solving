/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

 */
public class Leetcode_73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean f_row = false, f_col = false;
        
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 0) {
                    if (y == 0) f_row = true;
                    if (x == 0) f_col = true;
                    matrix[y][0] = matrix[0][x] = 0;
                }
            }
        }
        
        for (int y = 1; y < matrix.length; y++) {
            for (int x = 1; x < matrix[0].length; x++) {
                if (matrix[y][0] == 0 || matrix[0][x] == 0) matrix[y][x] = 0;
            }
        }
        
        if (f_row)
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        
        if (f_col)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
    }
}
