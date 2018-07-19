/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 21. Merge Two Sorted Lists
 * 
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 * 

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// class Solution{
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//         if (l1 == null) return l2;
//         if (l2 == null) return l1;
        
//         if(l1.val < l2.val) {
//             l1.next = mergeTwoLists(l1.next, l2);
//             return l1;
//         }
//         else {
//             l2.next = mergeTwoLists(l1, l2.next);
//             return l2;
//         }
//     }
// }


public class Leetcode_21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode head = new ListNode(0);
        ListNode ls = head;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ls.next = l1;
                l1 = l1.next;
            }
            else {
                ls.next = l2;
                l2 = l2.next;
            }
            ls = ls.next;
        }
        
        if(l1 != null) ls.next = l1;
        if(l2 != null) ls.next = l2;
        
        return head.next;
    }
    
    
}
