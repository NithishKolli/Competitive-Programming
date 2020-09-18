# https://leetcode.com/problems/symmetric-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.checkTrees(root.left, root.right)
        
    def checkTrees(self, left_node, right_node):
        if (not left_node) != (not right_node):
            return False
        if not left_node and not right_node:
            return True
        if left_node.val != right_node.val:
            return False
        return self.checkTrees(left_node.left, right_node.right) and self.checkTrees(left_node.right, right_node.left)
            
            