# Leetcode 216 - https://leetcode.com/problems/combination-sum-iii/

from copy import deepcopy
class Solution:
    
    def __init__(self):
        self.solution_list = []
        
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        for index in range(1,10):
            self.addNumberProceed(k-1, index, n-index, [index])
        return self.solution_list
    
    def addNumberProceed(self,k,index,target,curr_list):
        if k==1:
            if target>index and target<10:
                curr_list.append(target)
                self.solution_list.append(curr_list)
            return
        
        for new_index in range(index+1, 10):
            new_list = deepcopy(curr_list)
            new_list.append(new_index)
            self.addNumberProceed(k-1,new_index, target-new_index,new_list)
        
        