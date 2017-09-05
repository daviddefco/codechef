/**
 * Created by ddfrancisco on 01/09/2017.
 * https://www.codechef.com/problems/BUYING2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class BuyingSweets {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   int sweetPrize;
   int moneyGiven = 0;
   int minimumNoteGiven = Integer.MAX_VALUE;

   public BuyingSweets () throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int notesGiven = scanner.nextInt();
      this.sweetPrize = scanner.nextInt();

      scanner = new Scanner(reader.readLine());
      while(  notesGiven-- > 0 ) {
         int currentNote = scanner.nextInt();
         if( minimumNoteGiven > currentNote ) {
            minimumNoteGiven = currentNote;
         }
         moneyGiven += currentNote;
      }
   }

   private boolean isInadequateCustomer() {
      return this.minimumNoteGiven <= this.moneyGiven % this.sweetPrize;
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         BuyingSweets purchase = new BuyingSweets();
         System.out.println(
           purchase.isInadequateCustomer() ? -1 : purchase.moneyGiven / purchase.sweetPrize
         );
      }
   }
}