/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 561. Array Partition I
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].

 * 
 */
public class Leetcode_561_ArrayPartitionI {
    public int arrayPairSum(int[] sums) {
        int[] arr = new int[20001];
        
        for (int sum: sums) {
            arr[sum + 10000]++;
        }
        
        boolean flag = true;
        int sum = 0;
        for (int i=-10000; i<=10000; i++) {
            if (arr[i+10000] != 0) {
                if (flag) {
                    sum += i;
                    flag = false;
                }
                else flag = true;
                
                if (--arr[i+10000] > 0) i--;
            }
        }
        
        return sum;
    }
    
    
    
//     public int arrayPairSum(int[] nums) {
//         Arrays.sort(nums);
        
//         int sum = 0;
//         for (int i=0; i<nums.length; i += 2) {
//             sum += nums[i];
//         }
        
//         return sum;
//     }
}
