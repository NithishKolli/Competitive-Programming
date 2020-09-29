# https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3475/
# https://leetcode.com/problems/subarray-product-less-than-k/

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int
        leftPointer = 0 
        rightPointer = 0
        count = 0
        currProduct = 1
        while rightPointer<len(nums):
            if nums[rightPointer] < k:
                count += 1
                currProduct *= nums[rightPointer]
                while currProduct>=k:
                    currProduct = currProduct / nums[leftPointer]
                    leftPointer += 1
                count += rightPointer - leftPointer
                rightPointer += 1
            else:
                rightPointer += 1
                leftPointer = rightPointer
        return count