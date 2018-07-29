/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 238. Product of Array Except Self
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
* 
* 
 */
public class Leetcode_238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        result[0] = 1;
        int temp = 1;
        
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        } 
        
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        
        return result;
    }
}
