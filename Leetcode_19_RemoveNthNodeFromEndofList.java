/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 19. Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 */
import java.util.*;
public class Leetcode_19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        
        if (list.get(list.size()-n) != head) {
            ListNode desireNode = list.get(list.size()-n);
            ListNode prev = list.get(list.size()-n-1);
            prev.next = desireNode.next;
        }
        else
            head = head.next;
        
        return head;
    }
}
