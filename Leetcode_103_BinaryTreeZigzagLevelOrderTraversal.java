/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

 */
import java.util.*;
public class Leetcode_103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Deque<TreeNode> nextToVisit = new ArrayDeque<>();
        nextToVisit.offer(root);
        boolean flag = true; 
        
        Deque<TreeNode> tempDeque = new ArrayDeque<>();
        List<Integer> tempList = new ArrayList<>();
        while (! nextToVisit.isEmpty()) {
            if (flag) {
                TreeNode temp = nextToVisit.removeFirst();
                tempList.add(temp.val);
                if(temp.left != null) tempDeque.offer(temp.left);
                if(temp.right != null) tempDeque.offer(temp.right);
            }
            else {
                TreeNode temp = nextToVisit.removeLast();
                tempList.add(temp.val);
                if(temp.right != null) tempDeque.offerFirst(temp.right);
                if(temp.left != null) tempDeque.offerFirst(temp.left);
            }
            
            if (nextToVisit.isEmpty() && !tempDeque.isEmpty()) {
                nextToVisit = tempDeque;
                ans.add(tempList);
                tempList = new ArrayList<>();
                tempDeque = new ArrayDeque<>();
                flag = (flag) ? false : true;
            }
            else if (nextToVisit.isEmpty() && tempDeque.isEmpty()) 
                ans.add(tempList);
        }
        
        return ans;
    }
}
