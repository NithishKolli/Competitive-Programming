import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day8 {
    public static void main(String[] args) {
        Path filePath = Paths.get("day8input.txt");
        // Path filePath = Paths.get("day8inputsample.txt");
        Map<String, List<Map.Entry<Integer, Integer>>> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> set = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> set2 = new HashSet<>();
        int rowCounter = 0;
        int columnSize = 0;
        try {

            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] parts = line.split("");
                for (int i = 0; i < parts.length; i++) {
                    if (!parts[i].equals(".")) {
                        map.computeIfAbsent(parts[i], k -> new ArrayList<Map.Entry<Integer, Integer>>())
                                .add(new AbstractMap.SimpleEntry<>(rowCounter, i));
                    }
                }
                rowCounter++;
            }
            columnSize = lines.get(0).length();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        for (String key : map.keySet()) {
            List<Map.Entry<Integer, Integer>> entryList = map.get(key);
            for (int i = 0; i < entryList.size(); i++) {
                for (int j = i + 1 ; j < entryList.size(); j++) {
                    if (!entryList.get(i).equals(entryList.get(j))) {
                        addAntiNodesForPair(entryList.get(i), entryList.get(j), rowCounter, columnSize, set);
                        addAntiNodesForPairUpdated(entryList.get(i), entryList.get(j), rowCounter, columnSize, set2);
                    }
                }
            }
        }
        System.out.println(set.size());
        System.out.println(set2.size());
    }

    private static void addAntiNodesForPair(Map.Entry<Integer, Integer> pair1, Map.Entry<Integer, Integer> pair2,
            int rowSize, int columnSize, Set<Map.Entry<Integer, Integer>> set) {
        
        int firstX = pair1.getKey()+(pair1.getKey()-pair2.getKey());
        int firstY = pair1.getValue()+(pair1.getValue()-pair2.getValue());
        if(0<=firstX && firstX<rowSize && firstY>=0 && firstY<columnSize){
            set.add(new AbstractMap.SimpleEntry<Integer,Integer>(firstX,firstY));
        }
        int secX = pair2.getKey()+(pair2.getKey()-pair1.getKey());
        int secY = pair2.getValue()+(pair2.getValue()-pair1.getValue());
        if(0<=secX && secX<rowSize && secY>=0 && secY<columnSize){
            set.add(new AbstractMap.SimpleEntry<Integer,Integer>(secX,secY));
        }
    }

    private static void addAntiNodesForPairUpdated(Map.Entry<Integer, Integer> pair1, Map.Entry<Integer, Integer> pair2,
            int rowSize, int columnSize, Set<Map.Entry<Integer, Integer>> set) {
        int i=0;
        int firstX = pair1.getKey()+(pair1.getKey()-pair2.getKey())*i;
        int firstY = pair1.getValue()+(pair1.getValue()-pair2.getValue())*i;
        while(0<=firstX && firstX<rowSize && firstY>=0 && firstY<columnSize){
            set.add(new AbstractMap.SimpleEntry<Integer,Integer>(firstX,firstY));
            i++;
            firstX = pair1.getKey()+(pair1.getKey()-pair2.getKey())*i;
            firstY = pair1.getValue()+(pair1.getValue()-pair2.getValue())*i;
        }
        i=0;
        int secX = pair2.getKey()+(pair2.getKey()-pair1.getKey())*i;
        int secY = pair2.getValue()+(pair2.getValue()-pair1.getValue())*i;
        while(0<=secX && secX<rowSize && secY>=0 && secY<columnSize){
            set.add(new AbstractMap.SimpleEntry<Integer,Integer>(secX,secY));
            i++;
            secX = pair2.getKey()+(pair2.getKey()-pair1.getKey())*i;
            secY = pair2.getValue()+(pair2.getValue()-pair1.getValue())*i;
        }
    }
}
