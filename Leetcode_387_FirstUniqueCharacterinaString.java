/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 387. First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class Leetcode_387_FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (char c: s.toCharArray()) arr[c - 'a']++;
        int s_len = s.length();
        for (int i = 0; i < s_len; i++) {
            if (arr[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
