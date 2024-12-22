import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day15 {
    public static void main(String[] args) {
        // Path filePath  = Paths.get("AdventOfCode/2024/day15input.txt");
        Path filePath  = Paths.get("AdventOfCode/2024/day15inputsample.txt");
        List<List<Character>> grid = new ArrayList<>();
        int currX=0,currY=0,rowCounter=0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                if (line.charAt(0) != ' ' && line.charAt(0) != '>' && line.charAt(0) != '<' && line.charAt(0) != '^' &&  line.charAt(0) != 'v'){
                    List<Character> row = new ArrayList<>();
                    int columnCounter=0;
                    for(char ch: line.toCharArray()){
                        row.add(ch);
                        if(ch=='@'){
                            currX=rowCounter;
                            currY=columnCounter;
                        }
                        columnCounter++;
                    }
                    rowCounter++;
                    grid.add(row);
                }
                else if (line.charAt(0) == '>' || line.charAt(0) == '<' || line.charAt(0) == '^' ||  line.charAt(0) == 'v') {
                    for (char ch : line.toCharArray()) {
                        
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
