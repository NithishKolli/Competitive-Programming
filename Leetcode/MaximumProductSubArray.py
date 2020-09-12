# Leetcode 152 - https://leetcode.com/problems/maximum-product-subarray/


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        small = 1
        big = 1
        maximum = float(-inf)
        for num in nums:
            small_product = small*num
            big_product = big*num
            small = min(small_product,big_product,num)
            big = max(small_product,big_product,num)
            maximum = max(big,maximum)
        return maximum