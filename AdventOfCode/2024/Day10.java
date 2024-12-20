import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Day10 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("AdventOfCode/2024/day10input.txt");
        // Path filePath  = Paths.get("AdventOfCode/2024/day10inputsample.txt");
        List<List<Integer>> grid = new ArrayList<>();
        int answer=0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                List<Integer> newLine = new ArrayList<>();
                for(String ch: line.split("")){
                    newLine.add(Integer.parseInt(ch));
                }
                grid.add(newLine);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if(grid.get(i).get(j)==0) {
                    answer += calculateTrailHeadScore(grid, i, j);
                }
            }
            
        }
        System.out.println(answer);
    }

    private static int calculateTrailHeadScore(List<List<Integer>> grid, int x, int y) {
        int[] rowKey = {-1,0,1,0};
        int[] columnKey = {0,1,0,-1} ;
        int score = 0;
        Set<Map.Entry<Integer,Integer>> set = new HashSet<>();
        Stack<Map.Entry<Integer,Integer>> stack = new Stack<>();
        stack.add(new AbstractMap.SimpleEntry<>(x,y));
        while (!stack.isEmpty()) {
            Map.Entry<Integer,Integer> entry = stack.pop();
            if(grid.get(entry.getKey()).get(entry.getValue()) == 9) {
                score++;
                set.add(entry);
            }
            for (int index = 0; index < 4; index++) {
                int tx = entry.getKey()+rowKey[index];
                int ty = entry.getValue()+columnKey[index];
                if (tx>=0 && tx<grid.size() && ty>=0 && ty<grid.get(0).size()) {
                    if(grid.get(tx).get(ty)-grid.get(entry.getKey()).get(entry.getValue()) == 1) {
                        stack.add(new AbstractMap.SimpleEntry<>(tx,ty));
                    }
                }
            }
        }
        return set.size();
    }
}
