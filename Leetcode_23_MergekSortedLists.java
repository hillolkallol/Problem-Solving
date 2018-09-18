/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
import java.util.*;
public class Leetcode_23_MergekSortedLists {
    
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solutionasdw {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        Queue<ListNode> heap = new PriorityQueue(lists.length, new HeapComparator());
        
        for (ListNode list: lists) {
            if (list != null)
                heap.offer(list);
        }
        
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (!heap.isEmpty()) {
            ListNode newNode = heap.poll();
            node.next = newNode;
            node = node.next;
            if (newNode.next != null) heap.offer(newNode.next);
        }
        
        return head.next;
    }
    
    public class HeapComparator implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2) {
            if (l1 != null && l2 != null)
                return l1.val - l2.val;
            return 0;
        }
    }
}

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode node = new ListNode(0);
//         ListNode head = node;
        
//         while (true) {
//             int min = Integer.MAX_VALUE;
//             int min_index = 0;
//             boolean flag = true;
//             for (int i = 0; i < lists.length; i++) {
//                 if (lists[i] != null){
//                     flag = false;
//                     if (lists[i].val < min) {
//                         min = lists[i].val;
//                         min_index = i;
//                     }
//                 }
//             }
            
//             if (flag) break;
            
//             head.next = lists[min_index];
//             head = head.next;
//             lists[min_index] = lists[min_index].next;
//         }
        
//         return node.next;
//     }
// }