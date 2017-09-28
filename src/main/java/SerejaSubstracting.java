/**
 * Created by ddfrancisco on 08/09/2017.
 * https://www.codechef.com/problems/CHEFFED
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class SerejaSubstracting {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   static Scanner scanner;
   int n;
   int gcd;

   public SerejaSubstracting() throws Exception {
      scanner = new Scanner(reader.readLine());
      this.n = scanner.nextInt();

      scanner = new Scanner(reader.readLine());
      this.gcd = scanner.nextInt();
      int remainingNumbers = n -1;
      while( remainingNumbers-- > 0 ) {
         this.gcd = gcd(this.gcd, scanner.nextInt());
      }
   }

   int gcd(int a, int b) {
      if(b == 0) {
         return a;
      }
      return gcd(b, a%b);
   }


   public static void main (String[] args) throws Exception {
      scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();
      while ( numberOfCases-- > 0 ) {
         SerejaSubstracting testCase = new SerejaSubstracting();
         System.out.println( testCase.gcd * testCase.n );
      }
   }
}