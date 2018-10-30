/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 90. Interleaving String
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
 */
public class Leetcode_97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        
        int s1_len = s1.length();
        int s2_len = s2.length();
        boolean[][] dp = new boolean[s1_len+1][s2_len+1];
        
        for (int i = 0; i <= s1_len; i++) {
            for (int j = 0; j <= s2_len; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0) 
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                else if (j == 0)
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                else
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) ||
                                (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }
        
        return dp[s1_len][s2_len];
    }
}
