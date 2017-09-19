/**
 * Created by ddfrancisco on 08/09/2017.
 * https://www.codechef.com/problems/CHEFFED
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class ChefNumbers {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   static Scanner scanner;
   final long N;
   static final int MAX_TRIES = 99 +9;

   public ChefNumbers() throws Exception {
      scanner = new Scanner(reader.readLine());
      N = scanner.nextInt();
   }

   int sumOfDigits(long number) {
      int sum = 0;
      String[] digits = String.valueOf(number).split("");
      for(int i=0; i<digits.length; i++) {
         sum += Integer.parseInt(digits[i]);
      }
      return sum;
   }


   public static void main (String[] args) throws Exception {
      ChefNumbers testCase = new ChefNumbers();
      long currentTry = testCase.N;
      int remainingTries = MAX_TRIES;
      int numberOfSolutions = 0;
      while( currentTry > 0 && remainingTries-- > 0 ) {
         long equationSolution = currentTry;
         int secondEquationTerm = testCase.sumOfDigits(equationSolution);
         equationSolution += secondEquationTerm;
         int thirdEquationTerm = testCase.sumOfDigits(secondEquationTerm);
         equationSolution += thirdEquationTerm;
         if(equationSolution == testCase.N) {
            numberOfSolutions++;
         }
         currentTry--;
      }
      System.out.println(numberOfSolutions);
   }
}