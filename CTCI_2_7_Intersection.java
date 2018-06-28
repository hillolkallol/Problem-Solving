/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 2.7
 * 
 * 2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.
 * 
 * 
 */
public class CTCI_2_7_Intersection {
    public boolean isIntersects(ListNode head1, ListNode head2){
        int size1 = 0;
        int size2 = 0;
        
        while(head1 != null) size1++;
        while(head2 != null) size2++; 
        
        if (size1 > size2){
            int i = 0;
            while(i < size1-size2){
                ListNode newhead = new ListNode(0);
                newhead.next = head2;
                head2 = newhead;
                i++;
            }
        }
        else if (size1 < size2){
            int i = 0;
            while(i < size2-size1){
                ListNode newhead = new ListNode(0);
                newhead.next = head1;
                head1 = newhead;
                i++;
            }
        }
        
        while(head1 != null)
            if(head1 == head2) return true; 
        
        return false;
    }
}
