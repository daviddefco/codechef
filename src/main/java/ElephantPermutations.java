/**
 * Created by ddfrancisco on 04/09/2017.
 * https://www.codechef.com/problems/LEPERMUT
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class ElephantPermutations {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   static Scanner scanner;
   int[] permutation;

   public ElephantPermutations() throws Exception {
      scanner = new Scanner(reader.readLine());
      this.permutation = new int[scanner.nextInt()];
      int remainingPermutationElements = this.permutation.length;
      scanner = new Scanner(reader.readLine());
      while( remainingPermutationElements > 0 ) {
         this.permutation[ this.permutation.length - remainingPermutationElements ] = scanner.nextInt();
         remainingPermutationElements--;
      }
   }

   private int inversions() {
      int invertions = 0;
      for ( int i=0; i < this.permutation.length - 1; i++ ) {
         for ( int j=i+1; j < this.permutation.length; j++) {
            if( this.permutation[i] > this.permutation[j] ) {
               invertions++;
            }
         }
      }
      return invertions;
   }

   private int localInversions() {
      int localInversions = 0;
      for ( int i=0; i < this.permutation.length - 1; i++ ) {
         if( this.permutation[i] > this.permutation[i+1]) {
            localInversions++;
         }
      }
      return localInversions;
   }

   public static void main (String[] args) throws Exception {
      scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         ElephantPermutations permutation = new ElephantPermutations();
         System.out.println(permutation.inversions() == permutation.localInversions() ? "YES" : "NO");
      }
   }
}