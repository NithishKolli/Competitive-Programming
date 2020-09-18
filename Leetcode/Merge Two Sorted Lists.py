# https://leetcode.com/problems/merge-two-sorted-lists/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode()
        prev_head = dummy
        while l1 or l2:
            val1 = l1.val if l1 else float(inf)
            val2 = l2.val if l2 else float(inf)
            if val1 <= val2:
                dummy.next = l1
                dummy = l1
                l1 = l1.next
            else:
                dummy.next = l2
                dummy = l2
                l2 = l2.next
        return prev_head.next