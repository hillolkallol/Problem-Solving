/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?  
 */
import java.util.*;
public class Leetcode_268_MissingNumber {
    
}

class Solutionww {
//     public int missingNumber(int[] nums) {
//         int[] hashmap = new int[nums.length+1];
//         for (int num: nums) {
//             hashmap[num]++;
//         }
        
//         for (int i = 0; i < hashmap.length; i++) {
//             if (hashmap[i] == 0)
//                 return i;
//         }
        
//         return 0;
//     }
    
//     public int missingNumber(int[] nums) {
//         int ans = nums.length;
//         for (int i = 0; i < nums.length; i++) {
//             ans ^= nums[i] ^ i;
//         }
        
//         return ans;
//     }
    
    public int missingNumber(int[] nums) {
        int desireVal = nums.length * (nums.length+1) / 2;
        int totalVal = 0;
        for (int i = 0; i < nums.length; i++) {
            totalVal += nums[i];
        }
        
        return desireVal - totalVal;
    }
}