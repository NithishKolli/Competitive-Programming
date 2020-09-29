# https://leetcode.com/problems/path-sum-ii/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from copy import deepcopy

class Solution:
    def __init__(self):
        self.solution = []
        
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.parseTree(root, [], sum)
        return self.solution
    
    def parseTree(self, root:TreeNode, node_list: list, target: int):
        if not root:
            return
        node_list.append(root.val)
        if not root.left and not root.right:
            if target==root.val:
                self.solution.append(node_list)
            else:
                return
        target -= root.val
        
        passing_list1 = deepcopy(node_list)
        passing_list2 = deepcopy(node_list)
        self.parseTree(root.left, passing_list1, target)
        self.parseTree(root.right, passing_list2, target)