/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 1.7
 * 
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate
 * the image by 90 degrees. can you do this in place?
 * 
 */
public class CTCI_1_7_Rotate_Matrix {
    public boolean rotate(int[][] matrix){
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++){
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = i;
            }
        }
        return true;
    }
}
