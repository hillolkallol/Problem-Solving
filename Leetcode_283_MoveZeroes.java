/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class Leetcode_283_MoveZeroes {
    
}

class Solution {
    public void moveZeroes(int[] nums) {
        for (int lastNonZero = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) swap(nums, lastNonZero++, i);
        }
    }
    
    public void swap (int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}


// class Solution {
//     public void moveZeroes(int[] nums) {
//         int i = nums.length - 2;
//         while (i >= 0) {
//             if (nums[i] == 0)
//                 placeZero(nums, i);
//             i--;
//         }
//     }
    
//     public void placeZero (int[] nums, int i) {
//         while(i < nums.length-1 && nums[i+1] != 0) {
//             swap(nums, i, i+1);
//             i++;
//         }
//     }
    
//     public void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }
