/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class Leetcode_5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int s_len = s.length();
        if (s_len < 2 || s == null) return s;
        int start = 0, end = 0;
        boolean[][] dp = new boolean[s_len][s_len];
        
        for (int i = s_len - 1; i>=0; i--) {
            for (int j = i; j < s_len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                
                if(dp[i][j] && j-i > end-start) {
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substring(start, end+1);
    }
}
