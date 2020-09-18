# https://leetcode.com/problems/two-sum/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = collections.defaultdict(int)
        for i in range(len(nums)):
            if target-nums[i] in num_map:
                return [i,num_map[target-nums[i]]]
            else:
                num_map[nums[i]] = i
