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
        int[] rowKey = {-1,0,1,0};
        int[] columnKey = {0,1,0,-1} ;
        int dirKey = 0;
        int posX=0, posY=0;
        Set<String> visited = new HashSet<>();
        Set<String> visitedWithDir = new HashSet<>();
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
        int rowCount = grid.size();
        int columnCount = grid.get(0).size();
        String key = posX + "x" + posY;
        String keyWD = posX + "x" + posY+"k"+dirKey;
        visited.add(key);
        visitedWithDir.add(keyWD);
        do {
            if(grid.get(posX+rowKey[dirKey]).get(posY+columnKey[dirKey]).equals("#")) {
                dirKey++;
                dirKey = dirKey%4;
            }
            if(grid.get(posX+rowKey[dirKey]).get(posY+columnKey[dirKey]).equals(".") || grid.get(posX+rowKey[dirKey]).get(posY+columnKey[dirKey]).equals("^")) {                
                posX += rowKey[dirKey];
                posY += columnKey[dirKey];
                key = posX + "x" + posY;
                keyWD = posX + "x" + posY+"k"+dirKey;
                int probeX = posX;
                int probeY = posY;
                while((probeX>=0 && probeX<rowCount) && probeY>=0 && probeY<columnCount) {
                    probeX += rowKey[(dirKey+1)%4];
                    probeY += columnKey[(dirKey+1)%4];
                    String keyWD1 = probeX + "x" + probeY +"k"+(dirKey+1)%4;
                    if(visitedWithDir.contains(keyWD1)) {
                        loops++;
                        // System.out.print(posX+rowKey[dirKey] + " ");
                        // System.out.println(posY+columnKey[dirKey]);
                        break;
                    }
                }
                visited.add(key);
                visitedWithDir.add(keyWD);
            }
            
        } while((posX+rowKey[dirKey]>=0 && posX+rowKey[dirKey]<rowCount) && (posY+columnKey[dirKey])>=0 && posY+columnKey[dirKey]<columnCount);

        System.out.println(visited.size());
        System.out.println(loops);
    }
}
