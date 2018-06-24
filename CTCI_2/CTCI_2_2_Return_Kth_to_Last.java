/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTCI_2;

/**
 *
 * @author KD
 * 
 * cracking the coding interivew 2.2
 * 
 * implement an algorithm to find the kth to last element of a singly linked list.
 * 
 * 
 */


public class CTCI_2_2_Return_Kth_to_Last {
    public ListNode returnKth(ListNode head, int k){
        ListNode l1 = head;
        ListNode l2 = head;
        
        for (int i=0; i<k; i++){
            if (l1 == null) return null;
            l1 = l1.next;
        }
        
        while(l1.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l2;
    }
}
