# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.solution = 0
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        self.parseTreeRecursion(root, k)
        return self.solution
    
    def parseTreeRecursion(self, root: TreeNode, target: int)-> bool:
        if root.left:
            target = self.parseTreeRecursion(root.left, target)
        target -= 1
        if target==0:
            self.solution = root.val
        if root.right:
            target = self.parseTreeRecursion(root.right, target)
        return target
            