/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class CTCI_4_5_ValidateBST {
    public boolean validateBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean validateBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val + 1, max);
    }
}
