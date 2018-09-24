/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 652. Find Duplicate Subtrees
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 */
import java.util.*;
public class Leetcode_652_FindDuplicateSubtrees {
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, Integer> counts = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    int t = 1;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return ans;
    }
    
    public int find(TreeNode root) {
        if (root == null) return 0;
        String serial = root.val + "," + find(root.left) + "," + find(root.right);
        int uid = map.computeIfAbsent(serial, x-> t++);
        counts.put(uid, counts.getOrDefault(uid, 0) + 1);
        if (counts.get(uid) == 2)
            ans.add(root);
        return uid;
    }
}
