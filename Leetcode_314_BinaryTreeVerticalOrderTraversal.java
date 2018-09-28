/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 * 
 * 314. Binary Tree Vertical Order Traversal
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */
import java.util.*;
public class Leetcode_314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        queue.add(root);
        count.add(0);
        
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            Integer val = count.poll();
            
            if (!map.containsKey(val))
                map.put(val, new ArrayList<>());
            map.get(val).add(temp.val);
            
            if (temp.left != null) {
                count.add(val - 1);
                queue.add(temp.left);
                min = Math.min(min, val-1);
            }
            
            if (temp.right != null) {
                count.add(val + 1);
                queue.add(temp.right);
                max = Math.max(max, val+1);
            }
        }
        
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        
        return ans;
    }
}
