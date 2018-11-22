/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 202. Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class Leetcode_202_HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        
        do {
            slow = findSum(slow);
            fast = findSum(fast);
            fast = findSum(fast);
        } while (slow != fast);
        
        if (slow == 1) return true;
        return false;
    }
    
    public int findSum(int n) {
        int sum = 0, temp;
        
        while (n != 0) {
            temp = n % 10;
            sum += temp * temp;
            n = n/ 10;
        }
        
        return sum;
    }
}
