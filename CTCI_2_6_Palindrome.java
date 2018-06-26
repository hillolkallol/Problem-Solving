/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 2.6
 * 
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 * 
 * 
 */
import java.util.*;
public class CTCI_2_6_Palindrome {
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null){
            slow = slow.next;
        }
        
        while(slow != null){
            if(stack.pop() != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }
}
