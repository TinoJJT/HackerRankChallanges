import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getMinimumCost(int n, int k, int[] c){
        int totalCost = 0;
        int flowersPurchached = 0;
        int multiplier = 1;
        Arrays.sort(c);
        
        while(flowersPurchached != n){
            for(int i = 0; i < k; i++){
                if(flowersPurchached == n) break;
                totalCost += c[n-1-flowersPurchached] * multiplier;
                flowersPurchached++;
            }
            multiplier++;
        }
        
        
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int minimumCost = getMinimumCost(n, k, c);
        System.out.println(minimumCost);
    }
}
