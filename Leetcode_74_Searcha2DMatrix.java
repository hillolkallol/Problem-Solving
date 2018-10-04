/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
public class Leetcode_74_Searcha2DMatrix {
    
}
class Solutionhg {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length, col = matrix[0].length, start = 0, end = row*col-1;
        while (start <= end) {
            int mid = (start + end)/2;
            int midVal = matrix[mid/col][mid%col];
            if (midVal == target) return true;
            else if (midVal < target) start = mid+1;
            else if (midVal > target) end = mid-1;
        }
        return false;
    }
}

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix.length == 0 || matrix[0].length == 0) return false;
//         int row = 0;
//         int col = matrix[0].length - 1;
//         while (row < matrix.length && col >= 0) {
//             if (matrix[row][col] == target) return true;
//             else if (matrix[row][col] < target) row++;
//             else if (matrix[row][col] > target) col--;
//         }
//         return false;
//     }
// }

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if (matrix.length == 0 || matrix[0].length == 0) return false;
//         return searchMatrix(matrix, 0, matrix[0].length-1, target);
//     }
    
//     public boolean searchMatrix(int[][] matrix, int row, int col, int target) {
//         if (col < 0 || row >= matrix.length) return false;
//         if (matrix[row][col] == target) return true;
//         if (matrix[row][col] < target) return searchMatrix(matrix, row+1, col, target);
//         if (matrix[row][col] > target) return searchMatrix(matrix, row, col-1, target);
//         return false;
//     }
// }

