import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class day2{
    public static void main(String[] args) {
        String filePath = "day2input.txt";
        // String filePath = "day2inputsample.txt";
        int safeCount = 0;
        List<int[]> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by spaces or any delimiter (assuming space-separated numbers)
                String[] parts = line.split("\\s+");
                int[] partsInt = new int[parts.length];
                for(int i=0;i<parts.length;i++) {
                    // Convert the strings to integers
                    partsInt[i] = Integer.parseInt(parts[i]);
                }
                list.add(partsInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int[] record: list){ 
            if(safeRecord(record)){
                safeCount++;
            }
        }
        System.out.println(safeCount);
    }

    public static boolean safeRecord(int[] record) {
        boolean safe = true;
        if(notValid(record[0], record[1])) {
            safe = false;
        } else{
            int flag = record[1]>record[0]? 1:2;
            int leftIndex=1;
            int rightIndex=2;
            while(rightIndex<record.length){
                if((record[rightIndex]>record[leftIndex] && flag==2) || (record[rightIndex]<record[leftIndex] && flag==1) || notValid(record[leftIndex], record[rightIndex])) {
                    safe = false;
                }
                leftIndex++;
                rightIndex++;
            }
        }
        return safe;
    }

    public static boolean notValid(int x, int y) {
        return !(Math.abs(x-y) < 4) || !(Math.abs(x-y) > 0);
    }
}