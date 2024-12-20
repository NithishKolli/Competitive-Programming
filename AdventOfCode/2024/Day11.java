import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day11 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("AdventOfCode/2024/day11input.txt");
        // Path filePath  = Paths.get("AdventOfCode/2024/day11inputsample.txt");
        String input;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                input = line;
                firstPart(line,25);
                secondPart(line,75);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void secondPart(String line, int loopLength) {
        Map<String,Long> map = new HashMap<>();
        long answer=0;
        for (String part : line.split(" ")) {
            map.put(part, map.getOrDefault(part, 0L)+1);
        }
        for (int i = 0; i < loopLength; i++) {
            Map<String,Long> newMap = new HashMap<>();
            for(String part:map.keySet()){
                if(Long.parseLong(part) == 0 ) {
                    newMap.put("1", newMap.getOrDefault("1", 0L)+map.get(part));
                } else if (part.length()%2==0) {
                    newMap.put(part.substring(0, part.length()/2), newMap.getOrDefault(part.substring(0, part.length()/2), 0L)+map.get(part));
                    newMap.put(String.valueOf(Long.parseLong(part.substring(part.length()/2))), newMap.getOrDefault(String.valueOf(Long.parseLong(part.substring(part.length()/2))), 0L)+map.get(part));
                } else {
                    newMap.put(String.valueOf(Long.parseLong(part)*2024), newMap.getOrDefault(String.valueOf(Long.parseLong(part)*2024), 0L)+map.get(part));
                }
            }
            map = newMap;
        }
        for (Long value : map.values()) {
            answer += value;
        }
        System.out.println(answer);
    }

    private static void firstPart(String line, int loopLength) {
        List<String> parts = Arrays.asList(line.split(" "));
        for (int i = 0; i < loopLength; i++) {
            List<String> newList = new ArrayList<>();
            for(String part:parts){
                if(Long.parseLong(part) == 0 ) {
                    newList.add(new String("1"));
                } else if (part.length()%2==0) {
                    newList.add(part.substring(0, part.length()/2));
                    newList.add(String.valueOf(Long.parseLong(part.substring(part.length()/2))));
                } else {
                    newList.add(String.valueOf(Long.parseLong(part)*2024));
                }
            }
            parts = newList;
        }
        System.out.println(parts.size());
    }
}
