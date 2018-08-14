/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 102. Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
import java.util.*;
public class Leetcode_102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        
        LinkedList<TreeNode> nextToVisit = new LinkedList<>();
        nextToVisit.add(root);
        
        while (!nextToVisit.isEmpty()) {
            LinkedList<TreeNode> nodeCopy = nextToVisit;
            nextToVisit = new LinkedList<>();
            
            List<Integer> result = new ArrayList<>();
            while(!nodeCopy.isEmpty()) {
                TreeNode t = nodeCopy.remove();
                result.add(t.val);
                if (t.left != null) nextToVisit.add(t.left);
                if (t.right != null) nextToVisit.add(t.right);
            }
            results.add(result);
        }
        return results;
    }
}
