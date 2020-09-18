# https://leetcode.com/problems/reverse-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # def __init__(self):
        # self.answer = 
    def reverseList(self, head: ListNode) -> ListNode:
        #Iterative
        if not head:
            return None
        self.reverseListRecursive(head)
        return self.ans
    
    def reverseListIterative(self, head: ListNode) -> ListNode:
        prev_node = None
        while head:
            next_node = head.next
            head.next = prev_node
            prev_node = head
            head = next_node
        return prev_node
            
    def reverseListRecursive(self, head: ListNode) -> ListNode:
        if not head.next:
            self.ans = head
            return head
        next_node = self.reverseListRecursive(head.next)
        print(next_node)
        print(head)
        head.next = None
        next_node.next = head
        print("HH",next_node)

        return head
        
