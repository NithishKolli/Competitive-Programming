# https://leetcode.com/problems/sort-colors/

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        last_zero = -1
        last_one = -1
        
        i = 0
        while i < len(nums):
            if nums[i] == 2:
                i += 1
                continue
            elif nums[i] == 0:
                if i != last_zero+1: # >
                    nums[i], nums[last_zero+1] = nums[last_zero+1], nums[i]
                else:
                    i += 1
                last_zero += 1
                if last_one < last_zero:
                    last_one += 1
                    
            elif nums[i] == 1:
                nums[i], nums[last_one + 1] = nums[last_one + 1], nums[i]
                i += 1
                last_one += 1