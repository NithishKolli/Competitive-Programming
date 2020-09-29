// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3475/
// https://leetcode.com/problems/subarray-product-less-than-k/


class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int leftPointer = 0;
        int rightPointer = 0;
        int count = 0;
        int currProduct = 1;
        while(rightPointer<nums.length){
            if(nums[rightPointer]<k){
                count++;
                currProduct *= nums[rightPointer];
                while(currProduct>=k){
                    currProduct = currProduct / nums[leftPointer];
                    leftPointer++;
                }
                count += rightPointer - leftPointer;
                rightPointer++;
            }
            else{
                rightPointer++;
                leftPointer = rightPointer;
            }
        }
        return count;
    }
}