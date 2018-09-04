/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

import java.util.*;
public class Leetcode_22_GenerateParentheses {
    
}
class Solution32 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        char[] str = new char[n*2];
        addParen(list, str, n, n, 0);
        return list;
    }
    
    public void addParen(ArrayList<String> list, char[] str, int leftRem, int rightRem, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;
        if (leftRem == 0 && rightRem == 0) list.add(String.copyValueOf(str));
        else {
            str[index] = '(';
            addParen(list, str, leftRem - 1, rightRem, index + 1);
            
            str[index] = ')';
            addParen(list, str, leftRem, rightRem - 1, index + 1);
        }
    }
}

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         if (n == 0) return new ArrayList();
        
//         Set<String> set = new HashSet<>();
//         LinkedList<String> queue = new LinkedList<>();
//         queue.add("()");
        
//         while (!queue.isEmpty() && queue.peek().length() >> 1 < n) {
//             String s = queue.remove();
//             set.remove(s);
//             for (int i = 0; i<=s.length(); i++) {
//                 String temp = s.substring(0, i) + "()" + s.substring(i);
//                 if (!set.contains(temp)) {
//                     set.add(temp);
//                     queue.add(temp);
//                 }
//             }
//         }
        
//         return queue;
//     }
// }