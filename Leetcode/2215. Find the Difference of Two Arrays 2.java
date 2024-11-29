class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int num : nums1) {
            map.put(num, true);
        }
        for(int num : nums2) {
            if(map.containsKey(num)) {
                map.put(num, false);
            } else {
                set2.add(num);
            }
        }
        map.entrySet().removeIf(entry -> !entry.getValue());
        answer.add(new ArrayList(map.keySet()));
        answer.add(new ArrayList(set2));
        return answer;
    }

}