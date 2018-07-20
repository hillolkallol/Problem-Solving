/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Leetcode_617_Merge_Two_Binary_Trees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        t1.val += t2.val;
        
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        return t1;
    }
    
    
    
//     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//         TreeNode head = new TreeNode(0);
//         if (t1 != null && t2 != null) {
//             head.val = t1.val + t2.val;
//             if(t1.left != null && t2.left != null)
//                 head.left = mergeTrees(t1.left, t2.left);
//             else if (t1.left != null) 
//                 head.left = t1.left;
//             else if (t2.left != null) 
//                 head.left = t2.left;
            
//             if(t1.right != null && t2.right != null)
//                 head.right = mergeTrees(t1.right, t2.right);
//             else if (t1.right != null) 
//                 head.right = t1.right;
//             else if (t2.right != null) 
//                 head.right = t2.right;
//         }
//         else if (t1 == null)
//             head = t2;
//         else if (t2 == null)
//             head = t1;
        
//         return head;
//     }
}
