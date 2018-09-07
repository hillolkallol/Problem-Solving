/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 54. Spiral Matrix
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
import java.util.*;
public class Leetcode_54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        
        int r_low = 0;
        int r_high = matrix.length - 1;
        int c_low = 0;
        int c_high = matrix[0].length - 1;
        
        while (r_low <= r_high && c_low <= c_high) {
            for (int i = c_low; i <= c_high; i++) list.add(matrix[r_low][i]);
            for (int j = r_low+1; j <= r_high; j++) list.add(matrix[j][c_high]);
            
            if (c_low < c_high && r_low < r_high) {
                for (int k = c_high-1; k > c_low; k--) list.add(matrix[r_high][k]);
                for (int l = r_high; l > r_low; l--) list.add(matrix[l][c_low]);
            }
            
            r_low++;
            r_high--;
            c_low++;
            c_high--;
        }
        
        return list;
    }
}
