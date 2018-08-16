/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  * 
 */
import java.util.*;
public class Leetcode_199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideView(root, list, 0);
        return list;
    }
    
    public void rightSideView(TreeNode root, List<Integer> list, int height) {
        if (root == null) return;
        if (height < list.size()) list.set(height, root.val);
        else list.add(root.val);
        rightSideView(root.left, list, height+1);
        rightSideView(root.right, list, height+1);
    }
}
