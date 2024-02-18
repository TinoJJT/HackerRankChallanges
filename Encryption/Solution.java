import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Remove spaces
        s = s.replace(" ", "");
        
        // Get variables for loop
        int length = s.length();
        double sqrt = Math.sqrt(length);
        int columns = (int) Math.ceil(sqrt);
        
        // Build encrypted string
        char[] charArray = s.toCharArray();
        // Each string builder represents a column in the character grid
        List<StringBuilder> grid = new ArrayList<>();
        for(int i = 0; i < length; i++){
            int curentColum = i % columns;
            StringBuilder stringBuilder;
            if(i < columns) {
              stringBuilder = new StringBuilder();
              grid.add(stringBuilder);  
            } 
            else stringBuilder = grid.get(curentColum);
            stringBuilder.append(charArray[i]);
        }
        String encrypted = grid.stream()
            .map(StringBuilder::toString)
            .collect(Collectors.joining(" "));
        return encrypted;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
