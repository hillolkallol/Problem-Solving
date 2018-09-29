/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 273. Integer to English Words
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class Leetcode_273_IntegertoEnglishWords {
    String[] thousand = {"", "Thousand", "Million", "Billion"};
        String[] greaterThan20 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                               "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String ans = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                ans = helper(num % 1000) + thousand[i] + " " + ans;
            }
            num = num / 1000;
            i++;
        }
        
        return ans.trim();
    }
    
    public String helper(int newNum) {
        if (newNum == 0) return "";
        else if (newNum < 20) return lessThan20[newNum] + " ";
        else if (newNum < 100) return greaterThan20[newNum/10] + " " + helper(newNum % 10);
        else return lessThan20[newNum/100] + " Hundred " + helper(newNum % 100);
    }
}
