import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day9 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("day9input.txt");
        // Path filePath  = Paths.get("day9inputsample.txt"); 
        long answer = 0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                int finalArrIndex = 0;
                int leftPointer = 0;
                int rightPointer = line.length()-1;
                int leftIndex = 0;
                int rightIndex = (line.length())/2;
                int[] parts = line.chars()
                                    .map(c -> c - '0')
                                    .toArray();;
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
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        System.out.println(answer);
    }
}
