# https://leetcode.com/problems/path-sum/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        return self.parseTree(root, sum)
    
    def parseTree(self,root, target):
        if not root:
            return False
        if not root.left and not root.right:
            return target==root.val
        target -= root.val
        return self.parseTree(root.left, target) or self.parseTree(root.right, target)