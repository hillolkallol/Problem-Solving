/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 863. All Nodes Distance K in Binary Tree
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
 */
import java.util.*;
public class Leetcode_863_AllNodesDistanceKinBinaryTree {
    
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
class Solutionasa {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        
        dfs(root, null, parent);
        queue.offer(null);
        queue.offer(target);
        seen.add(target);
        seen.add(null);
        
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (count == K) {
                    for (TreeNode n: queue) {
                        res.add(n.val);
                    }
                    return res;
                }
                queue.offer(null);
                count++;
            }
            else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode tn = parent.get(node);
                if (!seen.contains(tn)) {
                    seen.add(tn);
                    queue.offer(tn);
                }
            }
        }
        return new ArrayList<Integer>();
    }
    
    public void dfs(TreeNode root, TreeNode pNode, Map<TreeNode, TreeNode> parent) {
        if (root == null) return;
        parent.put(root, pNode);
        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }
}