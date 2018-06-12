'''
107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root: return []

        nextToVisit = deque()
        nextToVisit.append(root)
        arrList = [[root.val]]
        tempList = []
        i, j = 0, 0
        while nextToVisit:
            node = nextToVisit.popleft()
            if node.left and node.right:
                j += 2
                nextToVisit.append(node.left)
                nextToVisit.append(node.right)
                tempList.append(node.left.val)
                tempList.append(node.right.val)
            elif node.left:
                j += 1
                nextToVisit.append(node.left)
                tempList.append(node.left.val)
            elif node.right:
                j += 1
                nextToVisit.append(node.right)
                tempList.append(node.right.val)
            if i == 0 and j != 0:
                arrList.append(tempList)
                tempList = []
                i = j
                j = 0
            i -= 1
        arrList.reverse()
        return arrList
