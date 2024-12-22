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
        // Path filePath = Paths.get("AdventOfCode/2024/day12input.txt");
        Path filePath = Paths.get("AdventOfCode/2024/day12inputsample.txt");
        List<List<Character>> grid = new ArrayList<>();
        long answer = 0;
        long answer2 = 0;
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
        set = new HashSet<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (!set.contains(new AbstractMap.SimpleEntry<>(i, j))) {
                    answer2 += probeForRegion2(grid, set, i, j);
                }
            }
        }
        System.out.println(answer2);
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
                } else if (set.contains(new AbstractMap.SimpleEntry<>(tx, ty))
                        && !grid.get(i).get(j).equals(grid.get(tx).get(ty))) {
                    perimeter++;
                }
            }
        }
        return area * perimeter;
    }

    private static long probeForRegion2(List<List<Character>> grid, Set<Map.Entry<Integer, Integer>> set, int i,
            int j) {
        long area = 0;
        long perimeter = 0;
        int[] rowKey = { -1, 0, 1, 0 };
        int[] columnKey = { 0, 1, 0, -1 };
        int[] incRowKey = { 0, 1, 0, 1 };
        int[] incColumnKey = { 1, 0, 1, 0 };
        Set<Map.Entry<Map.Entry<Integer, Integer>, Integer>> dirSet = new HashSet<>();
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(i, j));
        set.add(new AbstractMap.SimpleEntry<>(i, j));
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            area++;
            int currX = entry.getKey();
            int currY = entry.getValue();
            for (int k = 0; k < 4; k++) {
                int forwardX = currX + rowKey[k];
                int forwardY = currY + columnKey[k];
                int leftX = currX - incRowKey[k];
                int leftY = currY - incColumnKey[k];
                int rightX = currX + incRowKey[k];
                int rightY = currY + incColumnKey[k];
                if (isOutOfBounds(forwardX, forwardY, grid)
                        && !set.contains(new AbstractMap.SimpleEntry<>(forwardX, forwardY))
                        && grid.get(i).get(j).equals(grid.get(forwardX).get(forwardY))) {
                    queue.add(new AbstractMap.SimpleEntry<>(forwardX, forwardY));
                    set.add(new AbstractMap.SimpleEntry<>(forwardX, forwardY));
                } else if (!set.contains(new AbstractMap.SimpleEntry<>(forwardX, forwardY))) {
                    if (!dirSet.contains(
                            new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k))
                            && !dirSet.contains(
                                    new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k))
                            && !dirSet.contains(new AbstractMap.SimpleEntry<>(
                                    new AbstractMap.SimpleEntry<>(rightX, rightY), k))) {
                        dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k));
                        perimeter++;
                        if (isOutOfBounds(rightX, rightY, grid)) {
                            dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(rightX, rightY), k));
                        }
                        if (isOutOfBounds(leftX, leftY, grid)) {
                            dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k));
                        }
                    } else if (dirSet.contains(
                        new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k))) {
                            if (!dirSet.contains(
                                new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k))) {
                                    dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k));
                                    perimeter++;
                                }
                            
                            if (isOutOfBounds(rightX, rightY, grid)) {
                                dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(rightX, rightY), k));
                            }
                    } else if (dirSet.contains(new AbstractMap.SimpleEntry<>(
                        new AbstractMap.SimpleEntry<>(rightX, rightY), k))) {
                            if (!dirSet.contains(
                                new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k))) {
                                    dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k));
                                    perimeter++;
                                }
                            
                            if (isOutOfBounds(leftX, leftY, grid)) {
                                dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k));
                            }
                    }

                } else if (set.contains(new AbstractMap.SimpleEntry<>(forwardX, forwardY))
                        && !grid.get(i).get(j).equals(grid.get(forwardX).get(forwardY))) {
                            if (!dirSet.contains(
                                new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k))
                                && !dirSet.contains(
                                        new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k))
                                && !dirSet.contains(new AbstractMap.SimpleEntry<>(
                                        new AbstractMap.SimpleEntry<>(rightX, rightY), k))) {
                            dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k));
                            perimeter++;
                            if (isOutOfBounds(rightX, rightY, grid)) {
                                dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(rightX, rightY), k));
                            }
                            if (isOutOfBounds(leftX, leftY, grid)) {
                                dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k));
                            }
                        } else if (dirSet.contains(
                            new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k))) {
                                if (!dirSet.contains(
                                    new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k))) {
                                        dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k));
                                        perimeter++;
                                    }
                                
                                if (isOutOfBounds(rightX, rightY, grid)) {
                                    dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(rightX, rightY), k));
                                }
                        } else if (dirSet.contains(new AbstractMap.SimpleEntry<>(
                            new AbstractMap.SimpleEntry<>(rightX, rightY), k))) {
                                if (!dirSet.contains(
                                    new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k))) {
                                        dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(currX, currY), k));
                                        perimeter++;
                                    }
                                
                                if (isOutOfBounds(leftX, leftY, grid)) {
                                    dirSet.add(new AbstractMap.SimpleEntry<>(new AbstractMap.SimpleEntry<>(leftX, leftY), k));
                                }
                        }
                }
            }
        }
        // System.out.println(grid.get(i).get(j) + " " + area + " " + perimeter + " " + area*perimeter);
        return area * perimeter;
    }

    private static boolean isOutOfBounds(int x, int y, List<List<Character>> grid) {
        return x >= 0 && x < grid.size() && y >= 0 && y < grid.get(0).size();
    }
}
