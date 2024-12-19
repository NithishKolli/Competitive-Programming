import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day7 {
    public static void main(String[] args) {
        Path filePath  = Paths.get("day7input.txt");
        // Path filePath  = Paths.get("day7inputsample.txt");
        long answer = 0;
        int count =0;
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                String[] parts = line.split(":");
                long target = Long.parseLong(parts[0]);
                String[] numbers = parts[1].substring(1).split(" ");
                if(checkTarget(target, numbers, Long.parseLong(numbers[0]),0)){
                    // System.out.println(target);
                    count++;
                    answer += target;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        System.out.println(count);
        System.out.println(answer);
    }

    private static boolean checkTarget(long target, String[] numbers, long value, int index){
        // if (value==target) {
        //     System.out.println(index==numbers.length-1);
        //     // System.out.println(numbers.length);
        //     return true;
        // } 
        // else if (value>target) {
        //     return false;
        // }
        if(index==numbers.length-1) {
            return value==target;
        }
        if(checkTarget(target, numbers, value + Long.parseLong(numbers[index+1]), index+1)) {
            return true;
        }
        if(checkTarget(target, numbers, value * Long.parseLong(numbers[index+1]), index+1)) {
            return true;
        }
        return false;
    }

    private static boolean checkTarget2(long target, String[] numbers, long value, int index){
        if(index==numbers.length-1) {
            return value==target;
        }
        if(checkTarget(target, numbers, value + Long.parseLong(numbers[index+1]), index+1)) {
            return true;
        }
        if(checkTarget(target, numbers, value * Long.parseLong(numbers[index+1]), index+1)) {
            return true;
        }
        return false;
    }
}
