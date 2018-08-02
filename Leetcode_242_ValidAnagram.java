/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 242. Valid Anagram
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
* 
 */
public class Leetcode_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        
        for (char c: s.toCharArray()) {
            alphabets[c - 'a']++;
        }
        
        for (char ct: t.toCharArray()) {
            alphabets[ct - 'a']--;
        }
        
        for (int a: alphabets) {
            if (a != 0) return false;
        }
        return true;
    }
}
