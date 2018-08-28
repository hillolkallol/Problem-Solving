/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 695. Max Area of Island
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Leetcode_695_MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        
        for (int row = 0; row < grid.length; row++) 
            for (int col = 0; col < grid[0].length; col++) 
                if(grid[row][col] == 1) 
                    maxCount = Math.max(gcd(grid, row, col, 1), maxCount);
        
        return maxCount;
    }
    
    public int gcd(int[][] grid, int row, int col, int count) {
        grid[row][col] = 0;
        
        if (row < grid.length-1 && grid[row + 1][col] == 1) 
            count += gcd(grid, row+1, col, 1);
        if (col < grid[0].length-1 && grid[row][col + 1] == 1) 
            count += gcd(grid, row, col+1, 1);
        if (row > 0 && grid[row - 1][col] == 1) 
            count += gcd(grid, row-1, col, 1);
        if (col > 0 && grid[row][col - 1] == 1) 
            count += gcd(grid, row, col-1, 1);
            
        return count;
    }
}
