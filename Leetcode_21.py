'''
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
'''


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        if not l1 or not l2:
            return l1 or l2

        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

# class Solution:
#     def mergeTwoLists(self, l1, l2):
#         if not l1 or not l2:
#             return l1 or l2
#         list = ListNode(0)
#         while l1 and l2:
#             if l1.val < l2.val:
#                 list.next, l1 = l1.val, l1.next
#             else:
#                 list.next, l2 = l2.val, l2.next
#             list = list.next
#         return list.next
#
# a = ListNode(4)
# b = ListNode(2)
# b.next = a
# c = ListNode(1)
# c.next = b
#
# d = ListNode(4)
# e = ListNode(3)
# e.next = d
# f = ListNode(1)
# f.next = e
#
# s = Solution()
# print(s.mergeTwoLists(c, f).val)
