/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 221. Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 * 
 */
public class Leetcode_221_MaximalSquare {
    
}
class Solutionaqw {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return 0;
        int[] dp = new int[matrix[0].length+1];
        int max = 0, prev = 0;
        
        for (int row = 1; row <= matrix.length; row++) {
            for (int col = 1; col <= matrix[0].length; col++) {
                int temp = dp[col];
                if (matrix[row-1][col-1] == '1'){
                    dp[col] = Math.min(Math.min(dp[col-1], dp[col]), prev) + 1;
                    max = Math.max(max, dp[col]);
                }
                else dp[col] = 0;
                
                prev = temp;
            }
        }
        
        return max*max;
    }
}

// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return 0;
//         int[][] dp = new int[matrix.length+1][matrix[0].length+1];
//         int max = 0;
        
//         for (int row = 1; row <= matrix.length; row++) {
//             for (int col = 1; col <= matrix[0].length; col++) {
//                 if (matrix[row-1][col-1] == '1'){
//                     dp[row][col] = Math.min(Math.min(dp[row][col-1], dp[row-1][col]), dp[row-1][col-1]) + 1;
//                     max = Math.max(max, dp[row][col]);
//                 }
//             }
//         }
        
//         return max*max;
//     }
// }