/**
 * Created by ddfrancisco on 04/09/2017.
 * https://www.codechef.com/problems/ERROR
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class ChefFeedback {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   static Scanner scanner;
   static final String GOOD_FEEDBACK = "010";
   static final String ANOTHER_GOOD_FEEDBACK = "101";

   public static void main (String[] args) throws Exception {
      scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         String feedback = reader.readLine();
         System.out.println(
           feedback.contains(GOOD_FEEDBACK) || feedback.contains(ANOTHER_GOOD_FEEDBACK) ? "Good" : "Bad"
         );
      }
   }
}