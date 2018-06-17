
'''
160. Intersection of Two Linked Lists


Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
'''

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# class Solution(object):
#     def getIntersectionNode(self, headA, headB):
#         """
#         :type head1, head1: ListNode
#         :rtype: ListNode
#         """
#         if not headA or not headB: return None
#         A, B, A2, B2 = headA, headB, headA, headB
#         countA, countB = 0, 0
#
#         while A:
#             A = A.next
#             countA += 1
#         while B:
#             B = B.next
#             countB += 1
#
#         if countA > countB:
#             i = 0
#             while i < countA-countB:
#                 A2 = A2.next
#                 i += 1
#
#         elif countB > countA:
#             i = 0
#             while i < countB-countA:
#                 B2 = B2.next
#                 i += 1
#
#         while A2 != B2:
#             A2 = A2.next
#             B2 = B2.next
#
#         return A2

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        A , B = headA, headB
        while A is not B:
            A = headB if not A else A.next
            B = headA if not B else B.next
        return A

d = ListNode(4)
a = ListNode(4)
a.next = d

b = ListNode(2)
b.next = a
# c = ListNode(1)
# c.next = b

e = ListNode(3)
e.next = a
f = ListNode(1)
f.next = e

s = Solution()
print(s.getIntersectionNode(b, f).val)