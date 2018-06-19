'''
141. Linked List Cycle

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
'''


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    # def hasCycle(self, head):
    #     """
    #     :type head: ListNode
    #     :rtype: bool
    #     """
    #
    #     while head:
    #         if head.val == 't':
    #             return True
    #         else:
    #             head.val = 't'
    #             head = head.next
    #     return False

    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head: return False
        fast = head.next
        slow = head

        while fast and fast.next and slow:
            if fast == slow:
                return True
            fast = fast.next.next
            slow = slow.next
        return False



a = ListNode(4)
b = ListNode(2)
b.next = a
c = ListNode(1)
c.next = b
d = ListNode(4)
d.next = c
e = ListNode(3)
e.next = d
f = ListNode(1)
f.next = e

# a.next = f


s = Solution()
print(s.hasCycle(f))