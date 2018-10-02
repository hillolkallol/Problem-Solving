/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Leetcode_76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        int begin = 0, end = 0, head = 0, distance = Integer.MAX_VALUE, count = t.length();
        
        for (char c: t.toCharArray()) arr[c]++;
        
        while (end < s.length()) {
            if (arr[s.charAt(end++)]-- > 0) count--;
            
            while (count == 0) {
                if (end - begin < distance) {
                    distance = end - begin;
                    head = begin;
                }
                if (arr[s.charAt(begin++)]++ == 0) count++;
            }
        }
        
        return distance == Integer.MAX_VALUE ? "" : s.substring(head, head+distance);
    }
}
