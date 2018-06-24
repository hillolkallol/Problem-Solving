/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 2.4
 * 
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -) 5 -) 8 -) 5 -) 113 -) 2 -) 1 [partition = 5]
Output: 3 -) 1 -) 2 -) 113 -) 5 -) 5 -) 8
 * 
 * 
 */
public class CTCI_2_4_Partition {
    public void partition(ListNode head, int x){
        ListNode secList = null;
        ListNode prev = head;
        ListNode firList = null;
        while(head != null){
            if (head.val < x){
                if(secList == null) secList = head;
                else secList.next = head;
                if(prev != null) prev.next = head.next;
                head = head.next;
            }
            else if (firList == null) firList = head; 
        }
        
        secList.next = firList;
    }
}
