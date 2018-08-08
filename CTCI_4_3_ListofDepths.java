/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
import java.util.*;
public class CTCI_4_3_ListofDepths {
    public ArrayList<LinkedList<TreeNode>> createLinkedLists(TreeNode head) {
        ArrayList<LinkedList<TreeNode>> finalResult = new ArrayList<>();
        LinkedList<TreeNode> nodeToVisit = new LinkedList();
        nodeToVisit.add(head);
        
        while (!nodeToVisit.isEmpty()) {
            finalResult.add(nodeToVisit);
            LinkedList<TreeNode> current = nodeToVisit;
            nodeToVisit = new LinkedList<TreeNode>();
            
            for (TreeNode t: current) {
                if (t.left != null) nodeToVisit.add(t.left);
                if (t.right != null) nodeToVisit.add(t.right);
            }
        }
        return finalResult;
    }
}
