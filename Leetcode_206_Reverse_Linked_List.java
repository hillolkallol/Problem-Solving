/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class Leetcode_206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head){
        ListNode node = head;
        ListNode prev = null;
        while(node != null){
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }
}
