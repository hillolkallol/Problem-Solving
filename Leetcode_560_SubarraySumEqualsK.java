/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 560. Subarray Sum Equals K
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class Leetcode_560_SubarraySumEqualsK {
    
}
class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        
        return count;
    }
}

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int[][] dp = new int[nums.length][nums.length];
//         int count = 0;
        
//         for (int row = 0; row < nums.length; row++) {
//             for (int col = row; col < nums.length; col++) {
//                 if (row == col) 
//                     dp[row][col] = nums[row];
//                 else 
//                     dp[row][col] = nums[col] + dp[row][col-1];
                
//                 if (dp[row][col] == k) 
//                     count++;
//             }
//         }
        
//         return count;
//     }
// }