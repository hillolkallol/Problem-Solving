/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?


 */
public class Leetcode_234_PalindromeLinkedList {
        public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        
        int ll_length = 0;
        ListNode node = head;
        while (node != null) {
            ll_length++;
            node = node.next;
        }
        
        node = head;
        ListNode prev_n = null;
        ListNode next_n = null;
        int i = 0;
        while (i < (int) ll_length/2) {
            next_n = node.next;
            node.next = prev_n;
            prev_n = node;
            node = next_n;
            i++;
        }
        
        if (ll_length % 2 != 0) node = node.next;
        
        while (prev_n != null) {
            if (prev_n.val != node.val) return false;
            prev_n = prev_n.next;
            node = node.next;
        }
        
        return true;
    }
}
