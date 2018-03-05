import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int nonDivisibleSubset(int k, int[] arr) {
        int[] remainders = new int[k];
        int result = 0;
        
        for(int i = 0; i < arr.length; i++){
            int remainder = arr[i] % k;
            remainders[remainder]++;
        }
        
        for(int i = 1; i <= (k-1)/2; i++){
            if(remainders[i] > remainders[k-i]) result += remainders[i];
            else result += remainders[k-i];
        }
        if(k%2 == 0){
            if(remainders[k/2] > 0) result++;
        }
        if(remainders[0] > 0) result++;
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = nonDivisibleSubset(k, arr);
        System.out.println(result);
        in.close();
    }
}
