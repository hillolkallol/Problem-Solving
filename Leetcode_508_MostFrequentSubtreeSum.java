/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 
 * 508. Most Frequent Subtree Sum
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
import java.util.*;
public class Leetcode_508_MostFrequentSubtreeSum {
    
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solutionhkjh {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};
        helper(root);
        int[] ans = new int[res.size()];
        for (int r = 0; r < res.size(); r++) 
            ans[r] = res.get(r);
        return ans;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int val = root.val + helper(root.left) + helper(root.right);
        int counter = map.getOrDefault(val, 0) + 1;
        map.put(val, counter);
        if (counter == max) {
            res.add(val);
        }
        else if (counter > max) {
            res = new ArrayList<>();
            res.add(val);
            max = counter;
        }
        return val;
    }
}