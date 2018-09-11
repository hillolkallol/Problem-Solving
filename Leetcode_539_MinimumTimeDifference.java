/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 539. Minimum Time Difference
Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
 */
import java.util.*;
public class Leetcode_539_MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean[] arr = new boolean[24*60];
        
        for (String time: timePoints) {
            String[] s = time.split(":");
            int h = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            
            if (arr[h*60+m]) return 0;
            arr[h*60+m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i-prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, 24*60-last+first);
        return min;
    }
}
