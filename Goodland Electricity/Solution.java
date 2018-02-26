import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int pylons(int k, boolean[] tower) {
        int pylons = 0;
        int currentPylon = 0;
        int pointer = k-1;
        int cities = tower.length;
        boolean nextFound = false;
        boolean complete = false;
        
        while(!nextFound){
            if(pointer == -1){
                pylons = -1;
                return pylons;
            }
            else if(tower[pointer] == true){
                nextFound = true;
                pylons++;
                currentPylon = pointer;
                break;
            }
            pointer--;
        }
        
        while(!complete){
            pointer = currentPylon + (2 * k) -1;
            nextFound = false;
            if(currentPylon + k >= cities) break;

            if(pointer >= cities){
                pointer = cities - 1;
                complete = true;
            }
            while(!nextFound){
                if(pointer == currentPylon){
                    pylons = -1;
                    return pylons;
                }
                else if(tower[pointer] == true){
                    nextFound = true;
                    pylons++;
                    currentPylon = pointer;
                }
                pointer--;
            }
        }
        
        return pylons;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        boolean[] arr = new boolean[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            if ( (in.nextInt() & 1) != 0 ) arr[arr_i] = true;
        }
        int result = pylons(k, arr);
        System.out.println(result);
        in.close();
    }
}
