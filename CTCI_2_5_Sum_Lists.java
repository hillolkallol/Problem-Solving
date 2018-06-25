/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * Cracking the coding interview 2.5
 * 
 * 2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.
Output: 2 - > 1 - > 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
Output: 9 - > 1 - > 2. That is, 912.
 * 
 * 
 * 
 */
public class CTCI_2_5_Sum_Lists {
    public ListNode sumLists(ListNode list1, ListNode list2, int carry){
        if (list1 == null && list2 == null && carry == 0){
            return null;
        }
        
        ListNode result = new ListNode(0);
        int value = carry;
        if (list1 != null){
            value += list1.val;
        }
        if (list2 != null){
            value += list2.val;
        }
        result.val = value % 10;
        
        if (list1 != null || list2 != null){
            ListNode node = sumLists(list1 == null? null:list1.next, list2 == null? null:list2.next, (int)(value/10));
            result.next = node;
        }
        return result;
    }
}
