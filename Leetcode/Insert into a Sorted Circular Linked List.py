# https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        newNode = Node(insertVal)
        if not head:
            newNode.next = newNode
            return newNode
        prevNode = head
        currNode = head.next
        while(currNode!=head):
            if currNode.val >= prevNode.val:
                if prevNode.val<=insertVal<=currNode.val:
                    break
            else:
                if prevNode.val < insertVal or insertVal<= currNode.val:
                    break
            prevNode = currNode
            currNode = currNode.next
        prevNode.next = newNode
        newNode.next = currNode
        return head
                    
                   
                    
        
