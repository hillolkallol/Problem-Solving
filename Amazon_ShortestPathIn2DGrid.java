/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Given a 2 dimensional matrix where some of the elements are filled with 1 and rest of the elements 
are filled. Here X means you cannot traverse to that particular points. From a cell you can either traverse to left, right, up or down 
Given two points in the matrix find the shortest path 
between these points 

For example if the matrix is 
1 1 1 1 1 
S 1 X 1 1 
1 1 1 1 1 
X 1 1 E 1 
1 1 1 1 X 

Here S is the starting point and E is the Ending point
 */
import java.util.*;
public class Amazon_ShortestPathIn2DGrid {
    public int shortestPath(char[][] matrix) {
        int s_row = 0, s_col = 0;
        for (s_row = 0; s_row < matrix.length; s_row++)
            for (s_col = 0; s_col < matrix[0].length; s_col++)
                if (matrix[s_row][s_col] == 'S') 
                    return shortestPath(matrix, s_row, s_col);

        return 0;
    }
    
    public int shortestPath(char[][] matrix, int s_row, int s_col) {
        int count = 0;
        Queue<int[]> nextToVisit = new LinkedList<>();
        nextToVisit.offer(new int[]{s_row, s_col});
        Set<String> visited = new HashSet<>();
        Queue<int[]> temp = new LinkedList<>();
        
        while (!nextToVisit.isEmpty()) {
            int[] position = nextToVisit.poll();
            int row = position[0];
            int col = position[1];
            visited.add(row + "-" + col);
            
            if (matrix[row][col] == 'E') 
                return count;
            if (row > 0 && !visited.contains((row-1) + "-" + col) && matrix[row-1][col] != 'X') 
                temp.offer(new int[]{row-1, col});
            if (row < matrix.length-1 && !visited.contains((row+1) + "-" + col) && matrix[row+1][col] != 'X') 
                temp.offer(new int[]{row+1, col});
            if (col > 0 && !visited.contains(row + "-" + (col-1)) && matrix[row][col-1] != 'X') 
                temp.offer(new int[]{row, col-1});
            if (col < matrix[0].length-1 && !visited.contains(row + "-" + (col+1)) && matrix[row][col+1] != 'X') 
                temp.offer(new int[]{row, col+1});
            
            if (nextToVisit.isEmpty() && !temp.isEmpty()) {
                nextToVisit = temp;
                temp = new LinkedList<>();
                count++;
            }
            System.out.println(visited);
        }
        
        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix =  {{'1','X','S','1','1'},
                            {'1','X','X','X','1'},
                            {'1','1','1','1','1'},
                            {'X','1','1','1','1'},
                            {'1','1','1','1','E'}};
        
        
        Amazon_ShortestPathIn2DGrid ama = new Amazon_ShortestPathIn2DGrid();
        System.out.println(ama.shortestPath(matrix));
    }

}
