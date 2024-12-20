import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day11 {
    public static void main(String[] args) {
        // Path filePath  = Paths.get("AdventOfCode/2024/day11input.txt");
        Path filePath  = Paths.get("AdventOfCode/2024/day11inputsample.txt");
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
