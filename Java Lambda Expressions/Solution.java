import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }
 
 
 public static PerformOperation isOdd() {
  return (int num) -> num % 2 != 0;
 }
 
 public static PerformOperation isPrime() {
  return (int num) -> {
   if(num < 2) return false; // Not prime if negative, 0 or 1.
   for(int i = 2; i * i <= num; i++){ // Loop as long as i smaller than square root of num.
    if(num % i == 0) return false; // Not prime if divisible by any number.
   }
   return true;
  };
 }
 
 public static PerformOperation isPalindrome() {
  return (int num) -> {
   char[] digits = Integer.toString(num).toCharArray();
   int length = digits.length;
   int loops = length / 2;
   for(int i = 0; i < loops; i++){
    char startChar = digits[i];
    char endChar = digits[length - i - 1];
    if(startChar != endChar) return false;
   }
   return true;
  };
 }
}
public class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}
