/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 1.8
 * 
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * 
 */
public class CTCI_1_8_Zero_Matrix {
    public int[][] setZeros(int[][] matrix){
        boolean rowHasZero = false;
        boolean colHasZero = false;
        
        for (int j=0; j<matrix[0].length; j++){
            if (matrix[0][j] == 0){
                rowHasZero = true;
                break;
            }
        }
        
        for (int i=0; i<matrix.length; i++){
            if (matrix[i][0] == 0){
                colHasZero = true;
                break;
            }
        }
        
        for (int i=1; i<matrix.length; i++){
            for (int j=1; j<matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i=1; i<matrix.length; i++)
            if (matrix[i][0]==0)
                nullifyRow(matrix, i);
        
        for (int j=1; j<matrix.length; j++)
            if (matrix[0][j]==0)
                nullifyColumn(matrix, j);
        
        if (rowHasZero) nullifyRow(matrix, 0);
        if (colHasZero) nullifyColumn(matrix, 0);
        
        return matrix;
    }
    
    public void nullifyRow(int[][] matrix, int row){
        for (int i=0; i<matrix.length; i++)
            matrix[row][i] = 0;
    }
    
    public void nullifyColumn(int[][] matrix, int col){
        for (int i=0; i<matrix.length; i++)
            matrix[i][col] = 0;
    }
}
