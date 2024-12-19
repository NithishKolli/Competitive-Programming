import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        String filePath = "day5input.txt";
        // String filePath = "day5inputsample.txt";
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Map<Integer,Set<Integer>> revMap = new HashMap<>();
        int answer = 0 ;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("|")) {
                    String[] parts = line.split("\\|");
                    int key = Integer.parseInt(parts[0]);
                    int value = Integer.parseInt(parts[1]);
                    Set<Integer> set = map.getOrDefault(key, new HashSet<>());
                    Set<Integer> revSet = revMap.getOrDefault(value, new HashSet<>());
                    set.add(value);
                    revSet.add(key);
                    map.put(key, set);
                    revMap.put(value, revSet);
                } else if (line.contains(",")) {
                    String[] parts = line.split(",");
                    boolean flag=true;
                    for(int i=0;i<parts.length;i++){
                        for(int j=i+1;j<parts.length;j++){
                            if(map.containsKey(Integer.parseInt(parts[i]))) {
                                if(!map.get(Integer.parseInt(parts[i])).contains(Integer.parseInt(parts[j]))) {
                                    flag=false;
                                }
                            } else if (map.containsKey(Integer.parseInt(parts[j]))) {
                                if(map.get(Integer.parseInt(parts[j])).contains(Integer.parseInt(parts[i]))) {
                                    flag=false;
                                }
                            }

                        }
                    }
                    if(flag){
                        answer+= Integer.parseInt(parts[(parts.length/2)]);
                    }
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(answer);
    }
}
