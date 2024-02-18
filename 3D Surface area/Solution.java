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
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
    // Write your code here
        int h = A.size();
        int w = A.get(0).size();
        
        // Bottom and top sides are always h * w 
        int bottomSurfaceArea = h * w;
        int topSurfaceArea = bottomSurfaceArea;
        
        // Sum all sides exposed, by going through every cube, and look all 4 side sides.
        int frontExposed = 0;
        int backExposed = 0;
        int leftExposed = 0;
        int rigthExposed = 0;
        
        int sidesExposed = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                int stackHeight = A.get(i).get(j);
                System.out.println("Handling stack " + stackHeight);
                for(int k = 0; k < stackHeight; k++){
                    if(frontExposed(i, j, k, h, A)) sidesExposed++;
                    if(backExposed(i, j, k, h, A)) sidesExposed++;
                    if(leftExposed(i, j, k, w, A)) sidesExposed++;
                    if(rigthExposed(i, j, k, w, A)) sidesExposed++;
                }
            }
        }
        
        return bottomSurfaceArea + topSurfaceArea + sidesExposed;
    }

    private static boolean frontExposed(int i, int j, int k, int h, List<List<Integer>> A){
        // Front stack always exposed
        if(i == 0) return true;
        
        //Get stack in front of current cube stack
        int heightOfOtherStack = A.get(i - 1).get(j);
        if(k + 1 > heightOfOtherStack) return true;
        
        return false;
    }
    
    private static boolean backExposed(int i, int j, int k, int h, List<List<Integer>> A){
        if(i == h - 1) return true;
        int heightOfOtherStack = A.get(i + 1).get(j);
        if(k + 1 > heightOfOtherStack) return true;
        return false;
    }
    
    private static boolean leftExposed(int i, int j, int k, int w, List<List<Integer>> A){
        if(j == 0) return true;
        int heightOfOtherStack = A.get(i).get(j - 1);
        if(k + 1 > heightOfOtherStack) return true;
        return false;
    }
    
    private static boolean rigthExposed(int i, int j, int k, int w, List<List<Integer>> A){
        if(j == w - 1) return true;
        int heightOfOtherStack = A.get(i).get(j + 1);
        if(k + 1 > heightOfOtherStack) return true;
        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
