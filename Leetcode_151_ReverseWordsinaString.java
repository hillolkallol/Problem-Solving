/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 151. Reverse Words in a String
Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
import java.util.*;
public class Leetcode_151_ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
        String[] arr = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        for (int j = arr.length-1; j >= 0; j--) {
                sb.append(arr[j]);
                if(j != 0) sb.append(" ");
        }
        
        return sb.toString();
    }
    
//    public String reverseWords(String s) {
//        if (s == null || s.length() == 0) return s;
//        
//        ArrayList<String> arr = new ArrayList<>();
//        
//        int track = 0, i = 0;
//        for (i=0; i<s.length(); i++) {
//            if(s.charAt(i) == ' ') {
//                arr.add(s.substring(track, i));
//                track = i+1;
//            }
//        }
//        arr.add(s.substring(track, i));
//        
//        StringBuilder sb = new StringBuilder();
//        
//        for (int j = arr.size()-1; j >= 0; j--) {
//            if (arr.get(j) != " ") {
//                sb.append(arr.get(j));
//                sb.append(" ");
//            }
//        }
//        sb.delete(sb.length()-1, sb.length());
//        
//        return sb.toString();
//    }
    
    public static void main(String[] args) {
        Leetcode_151_ReverseWordsinaString obj = new Leetcode_151_ReverseWordsinaString();
        System.out.println(obj.reverseWords("the sky is blue"));
    }
}

