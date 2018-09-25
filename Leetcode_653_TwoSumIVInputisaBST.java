/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 653. Two Sum IV - Input is a BST

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
import java.util.*;
public class Leetcode_653_TwoSumIVInputisaBST {
    Set<Integer> store = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (store.contains(k-root.val)) return true;
        store.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
