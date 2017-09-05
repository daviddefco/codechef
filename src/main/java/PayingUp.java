/**
 * Created by ddfrancisco on 30/08/2017.
 * https://www.codechef.com/problems/MARCHA1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class PayingUp {

   List<Integer> wallet = new ArrayList<Integer>();
   int askedMoney;
   boolean isPaymentPossible = false;

   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public PayingUp() throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfNotes = scanner.nextInt();
      int currentNote;
      this.askedMoney = scanner.nextInt();

      while ( numberOfNotes-- > 0 ) {
         currentNote = Integer.parseInt(reader.readLine());
         // If the note is higher than the asked money is not worth considering it
         if( currentNote <= this.askedMoney ) {
            this.wallet.add(Integer.valueOf(currentNote));
         }
      }
      Collections.sort(this.wallet);
   }

   private void giveNote(int remainingMoney, int nextTryingNote) {
      System.out.println(nextTryingNote);
      while(!this.isPaymentPossible && nextTryingNote < this.wallet.size()) {
         int currentNote = this.wallet.get(nextTryingNote);
         nextTryingNote++;
         if(currentNote == remainingMoney) {
            this.isPaymentPossible = true;
            break;
         } else if (currentNote < remainingMoney) {
            giveNote( remainingMoney - currentNote, nextTryingNote);
         }
      }
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         PayingUp testCase = new PayingUp();
         if(testCase.wallet.size() > 0) {
            int testingNote = 0;
            while (!testCase.isPaymentPossible && testingNote < testCase.wallet.size()) {
               testCase.giveNote(testCase.askedMoney, testingNote);
               testingNote++;
            }
         }
         System.out.println(testCase.isPaymentPossible? "Yes" : "No");
      }
   }
}
