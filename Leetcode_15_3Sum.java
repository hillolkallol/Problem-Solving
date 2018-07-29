/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 
 * 15. 3Sum

 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
import java.util.*;

public class Leetcode_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // [-4, -1, -1, 0, 1, 2]
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i-1]) {
                int low = i + 1;
                int high = nums.length - 1;
                
                while (low < high) {
                    if (nums[i] + nums[low] + nums[high] == 0) {
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));
                    }
                    
                    if (nums[i] + nums[low] + nums[high] < 0) {
                        int oldLow = low;
                        while (nums[low] == nums[oldLow] && low < high) low++;
                    }
                    else {
                        int oldHigh = high;
                        while (nums[high] == nums[oldHigh] && low < high) high--;
                    }
                }
            }
        }
        
        return list;
    }
}
