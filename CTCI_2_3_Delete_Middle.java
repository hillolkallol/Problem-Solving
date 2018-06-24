/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 2.3
 * 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (Le., any node but
the fi rst and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
Input: the node c from the linked list a - >b- >c - >d - >e- >f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f
* 
* 
 */
public class CTCI_2_3_Delete_Middle {
    public boolean deleteMiddle(ListNode node){
        if (node == null || node.next == null) return false;
        node.val = node.next.val;
        node.next = node.next.next;
        return true;
    }
}
