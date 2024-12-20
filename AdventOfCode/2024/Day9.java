import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day9 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("AdventOfCode/2024/day9input.txt");
        // Path filePath  = Paths.get("AdventOfCode/2024/day9inputsample.txt"); 
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(blockFragmentation(line));
                System.out.println(fileFragmentation(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

    }

    private static long blockFragmentation(String line) {
        long answer =0;
        int finalArrIndex = 0;
        int leftPointer = 0;
        int rightPointer = line.length()-1;
        int leftIndex = 0;
        int rightIndex = (line.length())/2;
        int[] parts = line.chars()
                            .map(c -> c - '0')
                            .toArray();
        while(leftPointer<line.length()-1 && rightPointer>0){
            if(leftPointer%2==0) { // even, so integ
                if(parts[leftPointer] ==  0){
                    leftPointer++;
                } else {
                    answer+= finalArrIndex*leftIndex;
                    parts[leftPointer]--;
                    finalArrIndex++;
                }
            } else {
                if(parts[leftPointer] ==  0){ //
                    leftPointer++;
                    leftIndex++;
                } else if(parts[rightPointer]==0) {
                    rightPointer -= 2;
                    rightIndex--;
                } else {
                    parts[leftPointer]--;
                    parts[rightPointer]--;
                    answer += finalArrIndex*rightIndex;
                    finalArrIndex++;
                }
            }
        }
        return answer;
    }

    private static long fileFragmentation(String line) {
        long answer =0;
        int[] parts = line.chars()
                            .map(c -> c - '0')
                            .toArray();
        int[] prefix = new int[parts.length+1];
        int leftPointer = 0;
        int rightPointer = line.length()-1;
        prefix[0] = 0;
        for(int i=1;i<parts.length+1;i++) {
            prefix[i] = prefix[i-1] + parts[i-1];
        }
        while (rightPointer>0) {
            int placePointer = 1;
            while (placePointer<rightPointer) {
                if(parts[placePointer]>=parts[rightPointer]){
                    while(parts[rightPointer]>0){
                        answer+=(rightPointer/2)*(prefix[placePointer+1]-parts[placePointer]);
                        parts[placePointer]--;
                        parts[rightPointer]--;
                    }
                    break;
                }
                placePointer += 2;
            }
            rightPointer-=2;
        }

        while (leftPointer<line.length()) {
            while(parts[leftPointer]>0) {
                answer += (leftPointer/2)*(prefix[leftPointer+1]-parts[leftPointer]);
                parts[leftPointer]--;
            }
            leftPointer += 2;
        }

        return answer;
    }
}
