class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> removed = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            if(set1.contains(num)) {
                set1.remove(num);
                removed.add(num);
            } else if(removed.contains(num)){
                continue;
            } else {
                set2.add(num);
            }
        }
        answer.add(new ArrayList(set1));
        answer.add(new ArrayList(set2));
        return answer;
    }

}