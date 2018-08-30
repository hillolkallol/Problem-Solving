/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 347. Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
import java.util.*;
public class Leetcode_347_TopKFrequentElements {
    
}

class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] list = new List[nums.length + 1];
        
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int key: map.keySet()) {
            if (list[map.get(key)] == null) {
                list[map.get(key)] = new ArrayList<>();
            }
            list[map.get(key)].add(key);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && ans.size() < k; i--) {
            if (list[i] != null)
                ans.addAll(list[i]);
        }
        return ans;
    }
}



// class Solution {
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         List<Integer> list = new ArrayList<>();
        
//         for (int num: nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
        
//         while (k > 0) {
//             int max = Integer.MIN_VALUE;
//             int maxIdx = 0;
//             for (int key: map.keySet()) {
//                 if (map.get(key) > max) {
//                     max = map.get(key);
//                     maxIdx = key;
//                 }
//             }
//             list.add(maxIdx);
//             map.remove((Integer) maxIdx);
            
//             k--;
//         }
        
//         return list;
//     }
// }