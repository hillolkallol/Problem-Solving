/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
import java.util.*;
public class Leetcode_230_KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, k);
        return list.get(k-1);
    }
    
    public void helper(TreeNode root, List<Integer> list, int k) {
        if (root == null || list.size() == k) return;
        helper(root.left, list, k);
        list.add(root.val);
        helper(root.right, list, k);
    }
}
