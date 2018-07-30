/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class Leetcode_200_NumberofIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int j = 0; j<grid.length; j++) {
            for (int i = 0; i<grid[0].length; i++) {
                if (grid[j][i] == '1') {
                    dfs(grid, j, i);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int j, int i) {
        grid[j][i] = '0';
        
        if (j + 1 < grid.length && grid[j + 1][i] == '1') dfs(grid, j+1, i);
        if (j > 0 && grid[j - 1][i] == '1') dfs(grid, j-1, i);
        if (i + 1 < grid[0].length && grid[j][i + 1] == '1') dfs(grid, j, i + 1);
        if (i > 0 && grid[j][i - 1] == '1') dfs(grid, j, i - 1);
    }
}
