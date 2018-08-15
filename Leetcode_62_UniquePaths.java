/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
 */
public class Leetcode_62_UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for (int row=0; row < n; row++) {
            for (int col=0; col < m; col++) {
                if (row == 0 && col == 0) continue;
                int temp_sum = 0;
                if (col > 0) temp_sum += dp[row][col-1];
                if (row > 0) temp_sum += dp[row-1][col];
                dp[row][col] = temp_sum;
            }
        }
        return dp[n-1][m-1];
    }
}
