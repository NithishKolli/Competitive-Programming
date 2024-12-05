import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        String filePath = "day4input.txt";
        // String filePath = "day4inputsample.txt";
        List<List<Character>> wordSearch = new ArrayList<>();
        int answer = 0 ;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Character> newLine = new ArrayList<>();
                for(char ch: line.toCharArray()){
                    newLine.add(ch);
                }
                wordSearch.add(newLine);
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i =0;i <wordSearch.size();i++){
            for(int j=0;j<wordSearch.get(i).size();j++){
                if(wordSearch.get(i).get(j)=='X') {
                    answer += countXMAS(wordSearch, i, j);
                }                
            }
        }
        System.out.println(answer);
        int answer2 = 0;
        for(int i =0;i <wordSearch.size();i++){
            for(int j=0;j<wordSearch.get(i).size();j++){
                if(wordSearch.get(i).get(j)=='A') {
                    answer2 += countMAS(wordSearch, i, j);
                }                
            }
        }
        System.out.println(answer2/2);
    }

    private static int countMAS(List<List<Character>> wordSearch, int i, int j){
        int count=0;
        if ((i+1<wordSearch.size()) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i+1).get(j+1)=='M') { // right  down
            if ((i-1>=0) && (j-1>=0) && wordSearch.get(i-1).get(j-1)=='S') { 
                if ((i-1>=0) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i-1).get(j+1)=='M') {
                    if((i+1<wordSearch.size()) && (j-1>=0) && wordSearch.get(i+1).get(j-1)=='S') {
                        count++;
                    }                    
                }
                if ((i-1>=0) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i-1).get(j+1)=='S') {
                    if((i+1<wordSearch.size()) && (j-1>=0) && wordSearch.get(i+1).get(j-1)=='M') {
                        count++;
                    }                    
                }
            }
        }

        if ((i+1<wordSearch.size()) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i+1).get(j+1)=='S') { // left up
            if ((i-1>=0) && (j-1>=0) && wordSearch.get(i-1).get(j-1)=='M') { 
                if ((i-1>=0) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i-1).get(j+1)=='M') {
                    if((i+1<wordSearch.size()) && (j-1>=0) && wordSearch.get(i+1).get(j-1)=='S') {
                        count++;
                    }                    
                }
                if ((i-1>=0) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i-1).get(j+1)=='S') {
                    if((i+1<wordSearch.size()) && (j-1>=0) && wordSearch.get(i+1).get(j-1)=='M') {
                        count++;
                    }                    
                }
            }
        }

        if ((i-1>=0) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i-1).get(j+1)=='M') {
            if((i+1<wordSearch.size()) && (j-1>=0) && wordSearch.get(i+1).get(j-1)=='S') {
                if ((i+1<wordSearch.size()) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i+1).get(j+1)=='M') { // right  down
                    if ((i-1>=0) && (j-1>=0) && wordSearch.get(i-1).get(j-1)=='S') { 
                        count++;
                    }                    
                }
                if ((i+1<wordSearch.size()) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i+1).get(j+1)=='S') { // left up
                    if ((i-1>=0) && (j-1>=0) && wordSearch.get(i-1).get(j-1)=='M') {
                        count++;
                    }                    
                }
            }
        }
        if ((i-1>=0) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i-1).get(j+1)=='S') {
            if((i+1<wordSearch.size()) && (j-1>=0) && wordSearch.get(i+1).get(j-1)=='M') {
                if ((i+1<wordSearch.size()) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i+1).get(j+1)=='M') { // right  down
                    if ((i-1>=0) && (j-1>=0) && wordSearch.get(i-1).get(j-1)=='S') { 
                        count++;
                    }                    
                }
                if ((i+1<wordSearch.size()) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i+1).get(j+1)=='S') { // left up
                    if ((i-1>=0) && (j-1>=0) && wordSearch.get(i-1).get(j-1)=='M') {
                        count++;
                    }                    
                }
            }
        }
        
        
        return count;
    }

    private static int countXMAS(List<List<Character>> wordSearch, int i, int j){
        int count=0;
        if((j+1<wordSearch.get(i).size()) && wordSearch.get(i).get(j+1)=='M' ) { // right
            if((j+2<wordSearch.get(i).size()) && wordSearch.get(i).get(j+2)=='A' ) {
                if((j+3<wordSearch.get(i).size()) && wordSearch.get(i).get(j+3)=='S' ) {
                    count++;
                }
            }
        }
        if ((i+1<wordSearch.size()) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i+1).get(j+1)=='M') { // right  down
            if ((i+2<wordSearch.size()) && (j+2<wordSearch.get(i).size()) && wordSearch.get(i+2).get(j+2)=='A') { 
                if ((i+3<wordSearch.size()) && (j+3<wordSearch.get(i).size()) && wordSearch.get(i+3).get(j+3)=='S') { 
                    count++;
                }
            }
        }
        if ((i+1<wordSearch.size()) && wordSearch.get(i+1).get(j)=='M') { //down
            if ((i+2<wordSearch.size()) && wordSearch.get(i+2).get(j)=='A') {
                if ((i+3<wordSearch.size()) && wordSearch.get(i+3).get(j)=='S') {
                    count++;
                }
            }
        }
        if ((i+1<wordSearch.size()) && (j-1>=0) && wordSearch.get(i+1).get(j-1)=='M'){ //down left
            if ((i+2<wordSearch.size()) && (j-2>=0) && wordSearch.get(i+2).get(j-2)=='A'){
                if ((i+3<wordSearch.size()) && (j-3>=0) && wordSearch.get(i+3).get(j-3)=='S'){ 
                    count++;
                }
            }
        }
        if ((j-1>=0) && wordSearch.get(i).get(j-1)=='M' ) { // left
            if ((j-2>=0) && wordSearch.get(i).get(j-2)=='A' ) {
                if ((j-3>=0) && wordSearch.get(i).get(j-3)=='S' ) {
                    count++;
                }
            }
        }
        if ((i-1>=0) && (j-1>=0) && wordSearch.get(i-1).get(j-1)=='M') { // left up
            if ((i-2>=0) && (j-2>=0) && wordSearch.get(i-2).get(j-2)=='A') {
                if ((i-3>=0) && (j-3>=0) && wordSearch.get(i-3).get(j-3)=='S') {
                    count++;
                }
            }
        }
        if ((i-1>=0) && wordSearch.get(i-1).get(j)=='M') { // up
            if ((i-2>=0) && wordSearch.get(i-2).get(j)=='A') {
                if ((i-3>=0) && wordSearch.get(i-3).get(j)=='S') {
                    count++;
                }
            }
        }
        if ((i-1>=0) && (j+1<wordSearch.get(i).size()) && wordSearch.get(i-1).get(j+1)=='M') { // up right
            if ((i-2>=0) && (j+2<wordSearch.get(i).size()) && wordSearch.get(i-2).get(j+2)=='A') {
                if ((i-3>=0) && (j+3<wordSearch.get(i).size()) && wordSearch.get(i-3).get(j+3)=='S') {
                    count++;
                }
            }
        }
        return count;
    }
}
