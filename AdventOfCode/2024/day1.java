import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class day1 {
    public static void main(String[] args) {
        String filePath = "day1input.txt";        
        List<Integer> locations1 = new ArrayList<>();
        List<Integer> locations2 = new ArrayList<>();
        int answer = 0 ;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by spaces or any delimiter (assuming space-separated numbers)
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    // Convert the strings to integers
                    int num1 = Integer.parseInt(parts[0]);
                    int num2 = Integer.parseInt(parts[1]);

                    locations1.add(num1);
                    locations2.add(num2);
                } else {
                    // Handle the case if the line doesn't have exactly 2 numbers
                    System.out.println("Invalid line: " + line);
                }
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(locations1);
        Collections.sort(locations2);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<locations1.size();i++){
            answer += Math.abs(locations1.get(i)-locations2.get(i));
            map.put(locations2.get(i), map.getOrDefault(locations2.get(i), 0)+1);
        }
        System.out.println(answer);
        int answer2 = 0;
        for(int i=0;i<locations1.size();i++){
            answer2 += locations1.get(i) * map.getOrDefault(locations1.get(i), 0);
        }
        System.out.println(answer2);

    }
}