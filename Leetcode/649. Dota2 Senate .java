class Solution {
    public String predictPartyVictory(String senate) {
        Map<Character, Queue<Integer>> map = new HashMap<>();
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();
        Set<Integer> removed = new HashSet<>();
        map.put('R', queueR);
        map.put('D', queueD);
        for(int i=0;i<senate.length();i++){
            map.get(senate.charAt(i)).offer(i);
        }
        int round =0;
        while(!map.get('R').isEmpty() || !map.get('D').isEmpty()) {
            round++;
            for(int i=0; i<senate.length(); i++){
                if(!removed.contains(i)) {
                    if(senate.charAt(i) == 'R'){
                        if (map.get('D').isEmpty()) {
                            return "Radiant";
                        } else{
                            removed.add(map.get('D').poll());
                            int curr = map.get('R').poll();
                            map.get('R').offer(curr);
                        }                        
                    }
                    if(senate.charAt(i) == 'D'){
                        if (map.get('R').isEmpty()) {
                            return "Dire";
                        } else{
                            removed.add(map.get('R').poll());
                            int curr = map.get('D').poll();
                            map.get('D').offer(curr);
                        }                        
                    }
                }
            }
        }
        return "";
    }
}

// Queue can be used like a cyclical list by poll and offer on same val