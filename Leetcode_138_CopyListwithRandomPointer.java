/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class Leetcode_138_CopyListwithRandomPointer {
    
}
//Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
class Solutionasad {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode node = head;
        
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next  = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        
        node = head;
        while (node != null) {
            node.next.random = (node.random != null) ? node.random.next : null;
            node = node.next.next;
        }
        
        node = head;
        RandomListNode newHead = head.next;
        RandomListNode newNode = newHead;
        while (node != null) {
            node.next = node.next.next;
            newNode.next = (newNode.next != null) ? newNode.next.next : null;
            node = node.next;
            newNode = newNode.next;
        }
            
            
        return newHead;
    }
}


// public class Solution {
//     public RandomListNode copyRandomList(RandomListNode head) {
//         if (head == null) return null;
        
//         Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
//         RandomListNode node = head;
//         RandomListNode newHead = new RandomListNode(head.label);
//         map.put(head, newHead);
//         RandomListNode newNode = newHead;
        
        
//         while (node != null) {
//             if (map.containsKey(node.next)) {
//                 newNode.next = map.get(node.next);
//             }
//             else {
//                 if (node.next != null){
//                     RandomListNode newNext = new RandomListNode(node.next.label);
//                     newNode.next = newNext;
//                     map.put(node.next, newNext);
//                 }
//                 else {
//                     RandomListNode newNext = null;
//                     newNode.next = newNext;
//                 }
//             }
            
//             if (map.containsKey(node.random)) {
//                 newNode.random = map.get(node.random);
//             }
//             else {
//                 if (node.random != null) {
//                     RandomListNode newRandom = new RandomListNode(node.random.label);
//                     newNode.random = newRandom;
//                     map.put(node.random, newRandom);
//                 }
//                 else {
//                     RandomListNode newRandom = null;
//                     newNode.random = newRandom;
//                 }
//             }
            
//             node = node.next;
//             newNode = newNode.next;
//         }
        
//         return newHead;
//     }
// }