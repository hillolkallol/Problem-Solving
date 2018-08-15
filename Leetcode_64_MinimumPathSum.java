/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Leetcode_64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        //boundary conditions
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) continue;
                if (row > 0 && col > 0) dp[row][col] = Math.min(grid[row][col] + dp[row-1][col], grid[row][col] + dp[row][col-1]);
                else if (row > 0) dp[row][col] = grid[row][col] + dp[row-1][col];
                else if (col > 0) dp[row][col] = grid[row][col] + dp[row][col-1];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
