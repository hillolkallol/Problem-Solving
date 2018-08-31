/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 227. Basic Calculator II
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */

import java.util.*;
public class Leetcode_227_BasicCalculatorII {
    public int calculate(String s) {
        int s_len = s.length();
        if (s== null || s_len == 0) return 0;
        
        int num = 0;
        int sign = '+';
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<s_len; i++) {
            if (Character.isDigit(s.charAt(i)))
                num = num*10 + Character.getNumericValue(s.charAt(i));
            
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || s_len - 1 == i) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop()*num);
                if (sign == '/') stack.push(stack.pop()/num);
                
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int ans = 0;
        for (int st: stack) ans += st;
        
        return ans;
    }
}
