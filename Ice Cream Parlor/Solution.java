import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] icecreamParlor(int m, int[] arr) {
        int[] ids = new int[2];
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] + arr[j] == m){
                    ids[0] = i + 1;
                    ids[1] = j + 1;
                    return ids;
                }
            }
        }
        
        return ids;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
