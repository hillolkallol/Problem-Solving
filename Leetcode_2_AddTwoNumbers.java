/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class Leetcode_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        
        int reminder = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(l1 != null || l2 != null){
            int value = reminder;
            if (l1 != null) value += l1.val;
            if (l2 != null) value += l2.val;
            
            node.next = new ListNode(value % 10);
            reminder = (int) value / 10;
            
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            node = node.next;
        }
        if (reminder != 0) node.next = new ListNode(reminder);

        return head.next;
    }
    
    
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         return considerCarry(l1, l2, 0);
//     }
    
//     public ListNode considerCarry(ListNode l1, ListNode l2, int carry) {
//         if (l1 == null && l2 == null && carry == 0) return null;
        
//         ListNode node = new ListNode(0);
//         int value = carry;
//         if (l1 != null) value += l1.val;
//         if (l2 != null) value += l2.val;
//         node.val = value % 10;
        
//         if(l1 != null || l2 != null) {
//             node.next = considerCarry(l1 == null ? null : l1.next, l2 == null ? null : l2.next, (int) value/10);
//         }
        
//         return node;
//     }
}
