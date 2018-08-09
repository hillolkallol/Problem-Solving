/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class CTCI_4_4_CheckedBalanced {
    public boolean checkBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
    
    public int checkHeight(TreeNode root) {
        if (root == null) return -1;
        
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return Integer.MIN_VALUE;
        else return Math.max(leftHeight, leftHeight) + 1;
    } 
}
