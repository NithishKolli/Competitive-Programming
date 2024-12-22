import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day13 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("AdventOfCode/2024/day13input.txt");
        // Path filePath  = Paths.get("AdventOfCode/2024/day13inputsample.txt");
        long totalTokens = 0;
        long totalTokens2 = 0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            long bAX =  0;
            long bAY =  0;
            long bBX =  0;
            long bBY =  0;
            long prX = 0;
            long prY = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (i%4==0) {
                    bAX = Long.parseLong(lines.get(i).substring(lines.get(i).indexOf("+")+1,lines.get(i).indexOf(",")));
                    bAY = Long.parseLong(lines.get(i).substring(lines.get(i).indexOf("+", lines.get(i).indexOf("+")+1)+1));
                } else if (i%4==1) {
                    bBX = Long.parseLong(lines.get(i).substring(lines.get(i).indexOf("+")+1,lines.get(i).indexOf(",")));
                    bBY = Long.parseLong(lines.get(i).substring(lines.get(i).indexOf("+", lines.get(i).indexOf("+")+1)+1));
                } else if (i%4==2) {
                    
                    prX = Long.parseLong(lines.get(i).substring(lines.get(i).indexOf("=")+1,lines.get(i).indexOf(",")));
                    prY = Long.parseLong(lines.get(i).substring(lines.get(i).indexOf("=", lines.get(i).indexOf("=")+1)+1));
                } else if (i%4==3) {
                    // System.out.println(prX + " " + prY + "----");
                    totalTokens  += getTokens(bAX, bAY, bBX, bBY, prX, prY);
                    totalTokens2  += getTokens(bAX, bAY, bBX, bBY, prX+10000000000000L, prY+10000000000000L);
                    bAX =  0;
                    bAY =  0;
                    bBX =  0;
                    bBY =  0;
                    prX = 0;
                    prY = 0;
                }

            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        System.out.println((int)totalTokens);
        System.out.println((long)totalTokens2);
    }

    private static double getTokens(long bAX, long bAY, long bBX, long bBY, long prX, long prY) {
        // double bTokens = 0;
        double aTokens = 0;
        double bTokens1 = 0;

        // if (bBY>=bBX) {
        //     bTokens = (prX - ((prY/bBY) * bBX)) / (((bBY/bAY) * bAX)-bBX);
        //     bTokens = (prY/bBY)- (prX - ((prY/bBY) * bBX)) / ((bBY/bAY * bAX)-bBX);
        // } else if (bBX>bBY) {
        //     bTokens = (prY - ((prX/bBX) * bBY)) / (((bBX/bAX) * bAY)-bBY);
        //     bTokens = (prX/bBX)- (prY - ((prX/bBX) * bBY)) / (((bBX/bAX) * bAY)-bBY);
        // }
        aTokens = (prX*bBY - prY*bBX)  / (bAX*bBY - bAY*bBX);
        bTokens1 = (prY*bAX - prX*bAY) / (bAX*bBY - bAY*bBX);
        if (bAX*aTokens +  bBX*bTokens1 == prX && bAY*aTokens + bBY*bTokens1 == prY) {
            // if(((prY - (bTokens*bBY))/bAY) == ((prX - (bTokens*bBX))/bAX)) {
            //     aTokens = (prY - (bTokens*bBY))/bAY;
            // } 
            return aTokens*3 + bTokens1;
        }
        return 0;
    }
}
