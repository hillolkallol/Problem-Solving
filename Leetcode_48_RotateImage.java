/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 48. Rotate Image
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class Leetcode_48_RotateImage {
    public void rotate(int[][] matrix) {
        
        for (int f_row = 0, l_row = matrix.length - 1; f_row < l_row; f_row++, l_row--) {
            int[] temp = matrix[f_row];
            matrix[f_row] = matrix[l_row];
            matrix[l_row] = temp;
        }
        
        for (int j = 0; j < matrix.length; j++) {
            for (int i = j+1; i < matrix[0].length; i++) {
                int var = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = var;
            }
        }
        
    }
}
