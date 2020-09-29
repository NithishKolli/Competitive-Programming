// https://leetcode.com/problems/minimum-index-sum-of-two-lists/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> hashMap = new HashMap<>();
        List<String> favoriteRestaurants = new ArrayList<>();
        for(int i=0 ; i<list1.length ; i++){
            hashMap.put(list1[i],i);
        }
        
        int leastSum = Integer.MAX_VALUE;
        for(int i=0 ; i<list2.length ; i++){
            if (hashMap.containsKey(list2[i])){
                int prevIndex = hashMap.get(list2[i]);
                if((prevIndex+i)<leastSum){
                    favoriteRestaurants.clear();                        
                    favoriteRestaurants.add(list2[i]);   
                    leastSum = prevIndex+i;
                    }
                else if ((prevIndex+i) == leastSum){
                    favoriteRestaurants.add(list2[i]);   
                }
            }
        }
                
        return favoriteRestaurants.toArray(new String[favoriteRestaurants.size()]);
    }
}