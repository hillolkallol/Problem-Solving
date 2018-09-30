/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 224. Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */
import java.util.*;
public class Leetcode_224_BasicCalculator {
    public int calculate(String s) {
        int s_len = s.length(), sign = 1, result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s_len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i+1 < s_len && Character.isDigit(s.charAt(i+1))) {
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                result += sum * sign;
            }
            else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '-') sign = -1;
            else if (s.charAt(i) == '(') {
                stack.offerLast(result);
                stack.offerLast(sign);
                result = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                result = result * stack.pollLast() + stack.pollLast();
            }
        }
        
        return result;
    }
}
