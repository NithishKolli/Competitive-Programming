# https://leetcode.com/problems/path-sum-iii/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from copy import deepcopy
class Solution:
    def __init__(self):
        self.solution = 0
        self.target = 0
        
    def pathSum(self, root: TreeNode, sum: int) -> int:
        self.target = sum
        initial_dict = collections.defaultdict(int)
        initial_dict[0] += 1
        self.parseTree(root, initial_dict, 0)
        return self.solution
    
    def parseTree(self, root:TreeNode, sum_dict: dict, current_sum):
        '''
            sum_dict - dictionary whose key is the sum of all the elements from
             root to that node. Value is the number of such nodes.
        '''
        if not root: #end of our dfs path.
            return
        if current_sum+root.val - self.target in sum_dict:
            self.solution += sum_dict[current_sum+root.val - self.target]
        if root.left:
            left_node_dict = deepcopy(sum_dict)
            left_node_dict[current_sum+root.val] += 1
            self.parseTree(root.left, left_node_dict, current_sum+root.val)
        if root.right:
            right_node_dict = deepcopy(sum_dict)
            right_node_dict[current_sum+root.val] += 1
            self.parseTree(root.right, right_node_dict, current_sum+root.val)
            
            
            

            
# right_node_dict[current_sum+root.val] = right_node_dict.get(current_sum+root.val,0) + 1