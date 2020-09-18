# https://leetcode.com/problems/move-zeroes/

from queue import Queue
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        q = Queue()
        for i in range(len(nums)):
            if nums[i]==0:
                q.put(i)
            else:
                if q.empty():
                    continue
                else:
                    new_index = q.get()
                    nums[new_index], nums[i] = nums[i], nums[new_index]
                    q.put(i)
        