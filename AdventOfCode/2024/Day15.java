import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day15 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("AdventOfCode/2024/day15input.txt");
        // Path filePath  = Paths.get("AdventOfCode/2024/day15inputsample.txt");
        List<List<Character>> grid = new ArrayList<>();
        int currX=0,currY=0,rowCounter=0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                if (line.length()>0 && line.charAt(0) != ' ' && line.charAt(0) != '>' && line.charAt(0) != '<' && line.charAt(0) != '^' &&  line.charAt(0) != 'v'){
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
                else if (line.length()>0 && (line.charAt(0) == '>' || line.charAt(0) == '<' || line.charAt(0) == '^' ||  line.charAt(0) == 'v')) {
                    for (char ch : line.toCharArray()) {
                        if (ch=='>') {
                            if(moveRobot(grid, currX, currY, 0, 1)){
                                currY++;
                            }
                        } else if (ch=='v') {
                            if(moveRobot(grid, currX, currY, 1, 0))
                            {
                                currX++;
                            }
                        } else if (ch=='<') {
                            if(moveRobot(grid, currX, currY, 0, -1)){
                                currY--;
                            }
                        } else if (ch=='^') {
                            if(moveRobot(grid, currX, currY, -1, 0)){
                                currX--;
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        int answer=0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if(grid.get(i).get(j) == 'O') {
                    answer += (100*i + j);
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean moveRobot(List<List<Character>> grid, int x, int y,int dirX, int dirY){
        if(grid.get(x+dirX).get(y+dirY)=='#'){
            return false;
        } else if(grid.get(x+dirX).get(y+dirY)=='.'){
            grid.get(x+dirX).set(y+dirY,'@');
            grid.get(x).set(y,'.');
            return true;
        } else if(grid.get(x+dirX).get(y+dirY)=='O'){
            int i = 2;
            while (grid.get(x+(i*dirX)).get(y+(i*dirY))=='O') {
                i++;
            }
            if(grid.get(x+(i*dirX)).get(y+(i*dirY))=='#'){
                return false;
            } else if(grid.get(x+(i*dirX)).get(y+(i*dirY))=='.'){
                grid.get(x+dirX).set(y+dirY,'@');
                grid.get(x+(i*dirX)).set(y+(i*dirY),'O');
                grid.get(x).set(y,'.');
                return true;
            }
        }
        return false;
    }
}
