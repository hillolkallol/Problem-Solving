/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
public class CTCI_4_2_MinimalTree {
    public TreeNode minTree(int elements[]){
        return createMinTree(elements, 0, elements.length - 1);
    }
    public TreeNode createMinTree(int elements[], int start, int end) {
        // base condition
        if (end < start) return null; 
        
        int mid = (start + end) / 2;
        
        TreeNode head = new TreeNode(elements[mid]);
        head.left = createMinTree(elements, start, mid - 1);
        head.right = createMinTree(elements, mid + 1, end);
        
        return head;
    }
}
