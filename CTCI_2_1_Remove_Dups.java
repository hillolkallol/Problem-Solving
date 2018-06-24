/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * cracking the coding interview 2.1
 * 
 * write code to remove duplicates from an unsorted linked list
 */

import java.util.*;
public class CTCI_2_1_Remove_Dups {
    
    public ListNode delDuplicates(ListNode n){
        HashSet<Integer> hashSet = new HashSet<Integer>();
        ListNode head = n;
        ListNode prev = null;
        
        while(n != null) {
            if (hashSet.contains(n.val)){
                prev.next = n.next;
            }
            else{
                hashSet.add(n.val);
                prev = n;
            }
            n = n.next;
        }
        return head;
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
