/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

 */
import java.util.*;
public class Leetcode_139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int s_len = s.length();
        boolean[] bool = new boolean[s_len + 1];
        bool[0] = true;
        
        for (int i = 1; i <= s_len; i++) {
            for (String str: wordDict) {
                int str_len = str.length();
                if (str_len <= i && bool[i-str_len] && s.substring(i-str_len, i).equals(str)) {
                    bool[i] = true;
                    break;
                }
            }
        }
        return bool[s_len];
    }
}
