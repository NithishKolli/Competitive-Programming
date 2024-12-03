import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class day2 {
    public static void main(String[] args) {
        String filePath = "day2input.txt";
        int safeCount = 0;
        List<List<Integer>> list = new ArrayList<>();

        // Read file and store data into List<List<Integer>>
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Split line by spaces
                List<Integer> partsList = new ArrayList<>();
                for (String part : parts) {
                    partsList.add(Integer.parseInt(part)); // Convert to Integer and add to list
                }
                list.add(partsList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Count safe records
        for (List<Integer> record : list) { 
            if (safeRecord(record)) {
                safeCount++;
            }
        }
        System.out.println("Safe Count: " + safeCount);

        // Count dampened safe records
        int dampenedSafeCount = 0;
        for (List<Integer> record : list) { 
            if (safeRecord(record)) {
                dampenedSafeCount++;
            } else {
                boolean safe = false;
                for (int i = 0; i < record.size(); i++) {
                    List<Integer> newList = new ArrayList<>(record);
                    newList.remove(i);
                    if(safeRecord(newList)) {
                        safe = true;
                    }
                }
                if(safe){
                    dampenedSafeCount++;
                }
            }
        }
        System.out.println("Dampened Safe Count: " + dampenedSafeCount);
    }

    // Check if a record is safe
    public static boolean safeRecord(List<Integer> record) {
        boolean safe = true;
        if (notValid(record.get(0), record.get(1))) {
            safe = false;
        } else {
            int flag = record.get(1) > record.get(0) ? 1 : 2;
            int leftIndex = 1;
            int rightIndex = 2;
            while (rightIndex < record.size()) {
                if ((record.get(rightIndex) > record.get(leftIndex) && flag == 2) ||
                    (record.get(rightIndex) < record.get(leftIndex) && flag == 1) ||
                    notValid(record.get(leftIndex), record.get(rightIndex))) {
                    safe = false;
                    break; // No need to check further
                }
                leftIndex++;
                rightIndex++;
            }
        }
        return safe;
    }

    // Check if two numbers are valid
    public static boolean notValid(int x, int y) {
        return !(Math.abs(x - y) < 4) || !(Math.abs(x - y) > 0);
    }
}
