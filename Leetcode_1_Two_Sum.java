/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
import java.util.*;
public class Leetcode_1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if (hashmap.containsKey(target-nums[i])){
                int[] arr = {hashmap.get(target-nums[i]), i};
                return arr;
            }
            hashmap.put(nums[i], i);
        }
        return null;
    }
}
