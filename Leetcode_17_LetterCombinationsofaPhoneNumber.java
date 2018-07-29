/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 */

import java.util.*;
public class Leetcode_17_LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits.isEmpty()) return list;
        String[] letters = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        int d_len = digits.length();
        
        for (int i = 0; i < d_len; i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            
            while (list.peek().length() == i) {
                String s = list.remove();
                for (char c: letters[num].toCharArray())
                    list.add(s + c);
            }
        }
        return list;
    }
}
