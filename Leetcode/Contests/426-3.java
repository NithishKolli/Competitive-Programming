class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        
        Map<Integer,List<Integer>> map1 = new HashMap<>();
        Map<Integer,List<Integer>> map2 = new HashMap<>();
        for(int[] edge: edges1) {
            map1.computeIfAbsent(edge[0], kv -> new ArrayList<>()).add(edge[1]);
            map1.computeIfAbsent(edge[1], kv -> new ArrayList<>()).add(edge[0]);
            // map1.put(edge[1], map1.getOrDefault(edge[1], new ArrayList<Integer>()).add(edge[0]));
        }
        for(int[] edge: edges2) {
            map2.computeIfAbsent(edge[0], kc -> new ArrayList<>()).add(edge[1]);
            map2.computeIfAbsent(edge[1], kc -> new ArrayList<>()).add(edge[0]);
            // map2.put(edge[0], map2.getOrDefault(edge[0], new ArrayList<Integer>()).add(edge[1]));
            // map2.put(edge[1], map2.getOrDefault(edge[1], new ArrayList<Integer>()).add(edge[0]));
        }
        int[] tree1 = new int[map1.size()];
        int[] tree2 = new int[map2.size()];
        tree1 = bfsAndFillArray(map1, k);
        tree2 = bfsAndFillArray(map2, k-1);
        Arrays.sort(tree2);
        int maxfromTree2 = tree2[map2.size()-1];
        for (int i=0;i<tree1.length;i++){
            tree1[i] += maxfromTree2;
        }
        return tree1;
    }

    int[] bfsAndFillArray(Map<Integer,List<Integer>> map, int target) {
        int[] tree = new int[map.size()];
        for(Integer key: map.keySet()) {
            tree[(int) key] = bfs(map, key, target);
        }
        return tree;
    }

    int bfs (Map<Integer,List<Integer>> map, int key, int target) {
        int count = 0;
        Map<Integer,Integer> mapc = new HashMap<>();
        mapc.put(key,0);
        Queue<Map<Integer,Integer>> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        seen.add(key);
        queue.add(mapc);
        while (queue.size()>0) {
            mapc = queue.poll();
            int value = mapc.keySet().iterator().next();
            
            int depth = mapc.values().iterator().next();
            if (depth<=target) {
                count++;
            }
            for(int connection: map.get(value) ) {
                if(connection != key && !seen.contains(connection)) {
                    Map<Integer,Integer> mapc1 = new HashMap<>();
                    mapc1.put(connection, depth+1);
                    queue.add(mapc1);   
                    seen.add(connection);
                }
                
            }
        }
        return count;
    }
}