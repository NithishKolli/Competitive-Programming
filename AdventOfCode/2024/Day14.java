import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day14 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("AdventOfCode/2024/day14input.txt");
        Path filePath2  = Paths.get("AdventOfCode/2024/day14inputsample.txt");
        int[] quadrants = new int[4];
        int answer=1;
        try {
            List<String> lines = Files.readAllLines(filePath2);
            for (String line : lines) {
                calculateQuadrant(line, quadrants, 11, 7);
            }
            for (int i = 0; i < quadrants.length; i++) {
                answer *= quadrants[i];
                
            }
            System.out.println(answer);
            quadrants = new int[4];
            answer=1;
            lines = Files.readAllLines(filePath);
            for (String line : lines) {
                calculateQuadrant(line, quadrants, 101, 103);
            }
            for (int i = 0; i < quadrants.length; i++) {
                answer *= quadrants[i];

            }
            System.out.println(answer);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void calculateQuadrant(String line, int[] quadrants, int width, int height) {
        int x = Integer.parseInt(line.substring(line.indexOf("=")+1,line.indexOf(",")));
        int y = Integer.parseInt(line.substring(line.indexOf(",")+1,line.indexOf(" ")));
        int vX = Integer.parseInt(line.substring(line.indexOf("=",line.indexOf("=")+1)+1,line.indexOf(",",line.indexOf(",")+1)));
        int vY = Integer.parseInt(line.substring(line.indexOf(",",line.indexOf(",")+1)+1));
        int fX = (x + 100 *vX)%width;
        int fY = (y + 100 *vY)%height;
        if (fX<0) {
            fX+=width;
        }
        if(fY<0){
            fY+=height;
        }
        if(fX<width/2) {
            if(fY<height/2) {
                quadrants[0]++;
            } else if (fY>height/2) {
                quadrants[1]++;
            }
        } else if (fX>width/2) {
            if(fY<height/2) {
                quadrants[2]++;
            } else if (fY>height/2) {
                quadrants[3]++;
            }
        }
    }

}
