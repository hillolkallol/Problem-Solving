/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 128. Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

import java.util.*;
public class Leetcode_128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        
        int finalResult = 0;
        
        for (int s: set) {
            if (!set.contains(s-1)) {
                int tempResult = 1;
                int curr = s;
                
                while (set.contains(curr+1)) {
                    curr++;
                    tempResult++;
                }
                
                finalResult = Math.max(finalResult, tempResult);
            }
        }
        
        return finalResult;
    }
}
