import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("day6input.txt");
        // Path filePath  = Paths.get("day6inputsample.txt");
        List<List<String>> grid = new ArrayList<>();
        int posX=0, posY=0;
        Set<String> visited = new HashSet<>();
        int loops =0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                if(line.contains("^")){
                    posX = grid.size();
                    posY = line.indexOf("^");
                }
                List<String> row = Arrays.asList(line.split(""));
                grid.add(row);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        visited = traverseMap(grid,posX,posY,0,-1,-1);
        for(String visitedString:visited) {
            int x = Integer.parseInt(visitedString.substring(0, visitedString.indexOf("x")));
            int y = Integer.parseInt(visitedString.substring(visitedString.indexOf("x")+1));
            if(traverseMap(grid, posX, posY, 0, x, y) == null) {
                loops++;
            }
        }
        // for(int i=0;i<grid.size();i++){
        //     for(int j=0;j<grid.get(0).size();j++) {
        //         if(traverseMap(grid, posX, posY, 0, i, j) == null) {
        //             loops++;
        //         }
        //     }
        // }
        System.out.println(visited.size());
        System.out.println(loops);
    }

    public static Set<String> traverseMap(List<List<String>> grid, int posX, int posY, int dirKey,int tempX, int tempY) {
        Set<String> visited = new HashSet<>();
        Set<String> visitedWithDir = new HashSet<>();
        int rowCount = grid.size();
        int columnCount = grid.get(0).size();
        int[] rowKey = {-1,0,1,0};
        int[] columnKey = {0,1,0,-1} ;
        String key = posX + "x" + posY;
        String keyWD = posX + "x" + posY+"k"+dirKey;
        visited.add(key);
        visitedWithDir.add(keyWD);
        do {
            if(grid.get(posX+rowKey[dirKey]).get(posY+columnKey[dirKey]).equals("#") || (posX+rowKey[dirKey]  == tempX && posY+columnKey[dirKey] == tempY)) {
                dirKey++;
                dirKey = dirKey%4;
            } else if(grid.get(posX+rowKey[dirKey]).get(posY+columnKey[dirKey]).equals(".") || grid.get(posX+rowKey[dirKey]).get(posY+columnKey[dirKey]).equals("^")) {                
                posX += rowKey[dirKey];
                posY += columnKey[dirKey];
                key = posX + "x" + posY;
                keyWD = posX + "x" + posY+"k"+dirKey;
                if(visitedWithDir.contains(keyWD)) {
                    return null;
                }
                visited.add(key);
                visitedWithDir.add(keyWD);
                
            }
            
        } while((posX+rowKey[dirKey]>=0 && posX+rowKey[dirKey]<rowCount) && (posY+columnKey[dirKey])>=0 && posY+columnKey[dirKey]<columnCount);
        return visited;
    }
}
