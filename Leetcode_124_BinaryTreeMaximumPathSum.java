/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class Leetcode_124_BinaryTreeMaximumPathSum {
    int result = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return result;
    }
    
    public int maxPathSum2(TreeNode root) {
        if (root == null) return 0;
        
        int left = Math.max(0, maxPathSum2(root.left));
        int right = Math.max(0, maxPathSum2(root.right));
        
        result = Math.max(result, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}
