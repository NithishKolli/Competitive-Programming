class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        Map<Integer,Integer> countMap1 = new HashMap<>();
        Map<Integer,Integer> countMap2 = new HashMap<>();
        for(int i=0;i< word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i),0)+1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i),0)+1);
        }
        if(!map1.keySet().equals(map2.keySet()))
        {
            System.out.println("diff keys");
            return false;
        }
    
        Iterator<Integer> iterator1 = map1.values().iterator();
        Iterator<Integer> iterator2 = map2.values().iterator();
        while(iterator1.hasNext()) {
            Integer int1 = iterator1.next();
            Integer int2 = iterator2.next();
            countMap1.put(int1, countMap1.getOrDefault(int1,0)+1);
            countMap2.put(int2, countMap2.getOrDefault(int2,0)+1);
        }
        
        for(int count : countMap1.keySet()) {
            if(!countMap2.containsKey(count)){
                return false;    
            } else if(countMap1.get(count) != countMap2.get(count)){
                return false;
            }
        }
        return true;
    }
}