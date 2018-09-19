/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 239. Sliding Window Maximum
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */
import java.util.*;
public class Leetcode_239_SlidingWindowMaximum {
    
}

class Solutionwwq {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        
        for (int i=0; i < nums.length; i++) {
            if(!deque.isEmpty() && deque.peek() < i - k + 1) 
                deque.poll();
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) 
                deque.pollLast();
            
            deque.offer(i);
            
            if (i >= k - 1) 
                result[idx++] = nums[deque.peek()];
        }
        
        return result;
    }
}



// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (nums == null || nums.length == 0) return new int[0];
        
//         Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
//         int[] result = new int[nums.length - k + 1];
        
//         for (int i = 0; i < k; i++) {
//             queue.offer(nums[i]);
//         }
//         result[0] = queue.peek();
//         queue.remove(nums[0]);
        
//         for (int i = k; i < nums.length; i++) {
//             queue.offer(nums[i]);
//             result[i-k+1] = queue.peek();
//             queue.remove(nums[i-k+1]);
//         }
        
//         return result;
//     }
// }