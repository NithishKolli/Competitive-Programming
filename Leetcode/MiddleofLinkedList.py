# https://leetcode.com/problems/middle-of-the-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        fast_p = head
        slow_p = head
        while fast_p.next:
            slow_p = slow_p.next
            if fast_p.next.next:
                fast_p = fast_p.next.next
            else:
                break
        return slow_p