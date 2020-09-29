// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int right_pointer = nums.length-1;
        int left_pointer = 0;
        while(left_pointer<=right_pointer){
            int mid = left_pointer + (right_pointer-left_pointer)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[left_pointer]){ // no rotation in left portion. so if target is smaller normal binary search
                if(target<nums[mid] && target>=nums[left_pointer]){
                    right_pointer = mid-1;
                }
                else{
                    left_pointer = mid+1;
                }
            }
            else{ //if(nums[mid]<nums[right_pointer]){
                if(target>nums[mid] && target<=nums[right_pointer]){
                    left_pointer = mid+1;
                }
                else{
                    right_pointer = mid-1;
                }
            }
        }
        return -1;
    }
}