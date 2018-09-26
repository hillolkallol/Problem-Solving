/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
import java.util.*;
public class Leetcode_694_NumberofDistinctIslands {
    public static void main(String[] args) {
        Solution43 s = new Solution43();
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(s.numDistinctIslands(grid));
    }
}

class Solution43 {
    public int numDistinctIslands(int[][] grid) {
        Set<Integer> island;
        Set<Set<Integer>> islands = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) { 
                island = new HashSet<>();
                dfs(grid, row, col, row, col, visited, island);
                if (!island.isEmpty()) {
                    System.out.println(island);
                    islands.add(island);}
            }
        }
        
        return islands.size();
    }
    
    public void dfs(int[][] grid, int row, int col, int row0, int col0, boolean[][] visited, Set<Integer> island) {
        if (grid[row][col] == 1 && !visited[row][col]) {
            visited[row][col] = true;
            island.add((row-row0) * 2 * grid[0].length + (col-col0)); //dont understand why
            if (row > 0) dfs(grid, row-1, col, row0, col0, visited, island);
            if (row < grid.length-1) dfs(grid, row+1, col, row0, col0, visited, island);
            if (col > 0) dfs(grid, row, col-1, row0, col0, visited, island);
            if (col < grid[0].length-1) dfs(grid, row, col+1, row0, col0, visited, island);
        }
    }
}



// class Solution {
//     public int numDistinctIslands(int[][] grid) {
//         List<Integer> island;
//         Set<List<Integer>> islands = new HashSet<>();
//         boolean[][] visited = new boolean[grid.length][grid[0].length];
        
//         for (int row = 0; row < grid.length; row++) {
//             for (int col = 0; col < grid[0].length; col++) { 
//                 island = new ArrayList<>();
//                 dfs(grid, row, col, 0, visited, island);
//                 if (!island.isEmpty()) {
//                     islands.add(island);}
//             }
//         }
        
//         return islands.size();
//     }
    
//     public void dfs(int[][] grid, int row, int col, int id, boolean[][] visited, List<Integer> island) {
//         if (grid[row][col] == 1 && !visited[row][col]) {
            
//             visited[row][col] = true;
//             island.add(id);
//             if (row > 0) dfs(grid, row-1, col, 1, visited, island);
//             if (row < grid.length-1) dfs(grid, row+1, col, 2, visited, island);
//             if (col > 0) dfs(grid, row, col-1, 3, visited, island);
//             if (col < grid[0].length-1) dfs(grid, row, col+1, 4, visited, island);
//             island.add(0);
//         }
//     }
// }