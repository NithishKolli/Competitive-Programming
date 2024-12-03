import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day3{
    public static void main(String[] args) {
        String filePath = "day3input.txt";
        // String filePath = "day3inputsample.txt";

        String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        String fullLine = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int matchCount = 0;
            while ((line = br.readLine()) != null) {
                fullLine += line;
                
            }

            String[] splits =  fullLine.split("do\\(\\)");
            for(int i = 0; i<splits.length; i++) {
                String[] result = splits[i].split("don't\\(\\)");
                Matcher matcher = pattern.matcher(result[0]);
                while (matcher.find()) {
                    matchCount += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2)) ;
                }
            }

            System.out.println(matchCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
class Day3{
    public static void main(String[] args) {
        String filePath = "day3input.txt";
        // String filePath = "day3inputsample.txt";

        String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int matchCount = 0;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    matchCount += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2)) ;
                }
            }
            System.out.println(matchCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
*/