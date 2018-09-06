/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 16. 3Sum Closest
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
import java.util.*;
public class Leetcode_16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int finalDiff = Integer.MAX_VALUE;
        int finalValue = 0;
        
        for (int i=0; i<nums.length-2; i++) {
            if (i == 0 || nums[i] > nums[i-1]) {
                int low = i + 1;
                int high = nums.length-1;
                int diff = Integer.MAX_VALUE;
                int value = 0;
                
                while (low < high) {
                    if (Math.abs(target - (nums[i] + nums[low] + nums[high])) < diff) {
                        diff = Math.abs(target - (nums[i] + nums[low] + nums[high]));
                        value = (nums[i] + nums[low] + nums[high]);
                    }
                    
                    if ((nums[i] + nums[low] + nums[high]) < target) low++;
                    else if ((nums[i] + nums[low] + nums[high]) >= target) high--;
                }
                
                if (diff < finalDiff) {
                    finalDiff = diff;
                    finalValue = value;
                }
            }
        }
        
        return finalValue;
                
    }
}
