/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 253. Meeting Rooms II
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1

 */
import java.util.*;
public class Leetcode_253_MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int s_pointer = 0, e_pointer = 0, minRooms = 0;
        
        while (s_pointer < intervals.length) {
            if (start[s_pointer] >= end[e_pointer]) {
                minRooms--;
                e_pointer++;
            }
            minRooms++;
            s_pointer++;
        }
        
        return minRooms;
    }
}
