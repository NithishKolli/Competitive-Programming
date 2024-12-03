class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int outlier = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            sum += num;
        }
        for(int num: nums) {
            int otherSum = sum - num;
            if(map.containsKey(otherSum/2) && otherSum%2==0) {
                if(otherSum/2 == num && (map.get(otherSum/2) < 2)) {
                    System.out.println(num);
                    continue;
                } else {
                    
                    outlier = Math.max(outlier, num);    
                }
            }
        }
        return outlier;
    }
}