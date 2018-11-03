/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 4. Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class Leetcode_4_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int len_nums1 = nums1.length;
        int len_nums2 = nums2.length;
        
        int low = 0;
        int high = len_nums1;
        
        while (low <= high) {
            int mid_nums1 = (low + high) / 2;
            int mid_nums2 = (len_nums1 + len_nums2 + 1) / 2 - mid_nums1;
            
            int maxLeftNums1 = (mid_nums1 == 0) ? Integer.MIN_VALUE : nums1[mid_nums1-1];
            int minRightNums1 = (mid_nums1 == len_nums1) ? Integer.MAX_VALUE : nums1[mid_nums1];
            
            int maxLeftNums2 = (mid_nums2 == 0) ? Integer.MIN_VALUE : nums2[mid_nums2-1];
            int minRightNums2 = (mid_nums2 == len_nums2) ? Integer.MAX_VALUE : nums2[mid_nums2];
            
            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                if ((len_nums1 + len_nums2) % 2 == 0)
                    return (double) (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2;
                else
                    return (double) Math.max(maxLeftNums1, maxLeftNums2);
            }
            else if (maxLeftNums1 > minRightNums2) {
                high = mid_nums1 - 1;
            }
            else {
                low = mid_nums1 + 1;
            }
        }
        
        return 0.0;
    }
}
