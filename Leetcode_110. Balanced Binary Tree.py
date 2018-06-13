'''
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def isBalanced(self, root):
#         """
#         :type root: TreeNode
#         :rtype: bool
#         """
#         if self.DFS(root) > 1:
#             return False
#         return True

#     def DFS(self, root):
#         if not root:
#             return 1

#         countLeft = 1
#         countRight = 1

#         countLeft += self.DFS(root.left)
#         countRight += self.DFS(root.right)

#         return abs(countLeft - countRight)

# from collections import deque
# class Solution:
#     def isBalanced(self, root):
#         """
#         :type root: TreeNode
#         :rtype: bool
#         """
#         visited = []
#         nodeToVisit = deque()
#         nodeToVisit.append(root.right)
#         nodeToVisit.append(root.left)

#         while not nodeToVisit:
#             node = nodeToVisit.popleft()
#             visited.append(node)

#             if node.right:
#                 nodeToVisit.append(node.right)
#             if node.left:
#                 nodeToVisit.append(node.left)

#             if


class Solution:
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if self.DFS(root) == -1: return False
        return True

    def DFS(self, node):
        if not node: return 0

        countLeft = self.DFS(node.left)
        countRight = self.DFS(node.right)

        if countLeft == -1 or countRight == -1 or abs(countLeft - countRight) > 1: return -1
        return max(countLeft, countRight) + 1

