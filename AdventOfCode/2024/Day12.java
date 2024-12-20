import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Day12 {
    public static void main(String[] args) {
        Path filePath = Paths.get("AdventOfCode/2024/day12input.txt");
        // Path filePath = Paths.get("AdventOfCode/2024/day12inputsample.txt");
        List<List<Character>> grid = new ArrayList<>();
        long answer = 0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                List<Character> newLine = new ArrayList<>();
                for (char ch : line.toCharArray()) {
                    newLine.add(ch);
                }
                grid.add(newLine);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        int rowSize = grid.size();
        int columnSize = grid.get(0).size();
        Set<Map.Entry<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (!set.contains(new AbstractMap.SimpleEntry<>(i, j))) {
                    answer += probeForRegion(grid, set, i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static long probeForRegion(List<List<Character>> grid, Set<Map.Entry<Integer, Integer>> set, int i, int j) {
        long area = 0;
        long perimeter = 0;
        int[] rowKey = { -1, 0, 1, 0 };
        int[] columnKey = { 0, 1, 0, -1 };
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(i, j));
        set.add(new AbstractMap.SimpleEntry<>(i, j));
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            area++;
            for (int k = 0; k < 4; k++) {
                int tx = entry.getKey() + rowKey[k];
                int ty = entry.getValue() + columnKey[k];
                if (tx >= 0 && tx < grid.size() && ty >= 0 && ty < grid.get(0).size()
                        && !set.contains(new AbstractMap.SimpleEntry<>(tx, ty))
                        && grid.get(i).get(j).equals(grid.get(tx).get(ty))) {
                    queue.add(new AbstractMap.SimpleEntry<>(tx, ty));
                    set.add(new AbstractMap.SimpleEntry<>(tx, ty));
                } else if (!set.contains(new AbstractMap.SimpleEntry<>(tx, ty))) {
                    perimeter++;
                } else if (set.contains(new AbstractMap.SimpleEntry<>(tx, ty)) && !grid.get(i).get(j).equals(grid.get(tx).get(ty))) {
                    perimeter++;
                }
            }
        }
        return area * perimeter;
    }
}
