/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 186. Reverse Words in a String II
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */
public class Leetcode_186_ReverseWordsinaStringII {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
        
        int start = 0;
        int end = 0;
        
        while (end < str.length-1) {
            if (str[end] == ' ') {
                reverse(str, start, end-1);
                start = end + 1;
            }
            end++;
        }
        reverse(str, start, end);
    }
    
    public void reverse(char[] str, int low, int high) {
        char temp = '#';
        
        while (low < high) {
            temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }
}
