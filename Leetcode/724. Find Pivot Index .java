class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        sum -= nums[0];
        int leftSum =0;
        for(int i=1; i< nums.length; i++){
            if (leftSum == sum) {
                return i-1;
            }
            leftSum += nums[i-1];
            sum -= nums[i];
        }
        if (leftSum == 0) {
            return nums.length-1;
        }
        return -1;
    }
}