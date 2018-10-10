/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 223. Rectangle Area
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:

Assume that the total area is never beyond the maximum possible value of int.
 */
public class Leetcode_223_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.max(Math.min(C, G), Math.max(A, E)) - Math.max(A, E);
        int y = Math.max(Math.min(D, H), Math.max(B, F)) - Math.max(B, F);
        
        return ((C - A) * (D - B)) + ((G - E) * (H - F)) - (x * y);
    }
}
