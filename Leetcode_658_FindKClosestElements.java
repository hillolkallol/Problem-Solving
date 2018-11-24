/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 658. Find K Closest Elements
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
UPDATE (2017/9/19):
The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code definition to get the latest changes.
 */
import java.util.*;
public class Leetcode_658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int arrlen = arr.length;
        
        if (x <= arr[0]) return returnList(arr, 0, k);
        else if (x >= arr[arrlen-1]) return returnList(arr, arrlen-k, arrlen);
        else {
            int idx = Arrays.binarySearch(arr, x);
            if (idx < 0) idx = - idx - 1;
            int start = Math.max(0, idx - k - 1);
            int end = Math.min(arrlen-1, idx + k - 1);
            
            while (end - start > k - 1) {
                if (start < 0 || x - arr[start] <= arr[end] - x) end--;
                else if (end > arrlen - 1 || x - arr[start] > arr[end] - x) start++;
            }
            
            return returnList(arr, start, end+1);
        }
    }
    
    public List<Integer> returnList(int[] arr, int start, int end) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = start; i < end; i++) {
            list.add(arr[i]);
        }
        
        return list;
    }
}
