/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 11. Container With Most Water
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 



The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class Leetcode_11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int maxVal = 0;
        
        while(low < high) {
            int temp = 0;
            if (height[low] > height[high]) {
                temp = height[high] * (high-low);
                high--;
            }
            else {
                temp = height[low] * (high-low);
                low++;
            }
            
            if (temp > maxVal) maxVal = temp;
        }
        
        return maxVal;
    }
}
