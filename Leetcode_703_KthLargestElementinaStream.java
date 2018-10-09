/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 703. Kth Largest Element in a Stream
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note: 
You may assume that nums' length ≥ k-1 and k ≥ 1.


 */
import java.util.*;
public class Leetcode_703_KthLargestElementinaStream {
    
}
class KthLargest {
    PriorityQueue<Integer> pQueue;
    int k_global;

    public KthLargest(int k, int[] nums) {
        k_global = k;
        pQueue = new PriorityQueue<>(k);
        for (int num: nums)
            add(num);
    }
    
    public int add(int val) {
        pQueue.offer(val);
        if (pQueue.size() > k_global) pQueue.poll();
        return pQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */