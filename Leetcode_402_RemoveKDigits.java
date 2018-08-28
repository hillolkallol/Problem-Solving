/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 402. Remove K Digits
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 */
public class Leetcode_402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int numlen = num.length();
        int newlen = numlen - k;
        char[] newStr = new char[numlen];
        int index = 0;
        
        for (int i = 0; i < numlen; i++) {
            char c = num.charAt(i);
            while (index > 0 && newStr[index-1] > c && k > 0) {
                index--;
                k--;
            }
            newStr[index++] = c;
        }
        
        int idx = 0;
        while(idx < newlen && newStr[idx] == '0') idx++;
        return idx == newlen ? "0": new String(newStr, idx, newlen - idx);
    }
}
