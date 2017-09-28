/**
 * Created by ddfrancisco on 21/09/2017.
 * https://www.codechef.com/problems/INTEG
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class ChefIntegers {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   static Scanner scanner;
   int N;
   long operationCost;
   long moneyNeeded = 0;
   List<Long> negativeNumbers = new ArrayList<Long>();

   public ChefIntegers() throws Exception {
      long aux;
      scanner = new Scanner(reader.readLine());
      this.N = scanner.nextInt();

      scanner = new Scanner(reader.readLine());
      for( int i=1; i <= N; i++) {
         aux = scanner.nextLong();
         if( aux < 0 ) {
            negativeNumbers.add(aux);
         }
      }
      Collections.sort(negativeNumbers);

      scanner = new Scanner(reader.readLine());
      this.operationCost = scanner.nextLong();
   }

   void makeListPositive() {
      if(negativeNumbers.size() > this.operationCost) {
         addInAllList();
         makeListPositive();
      } else {
         computeIndividualOperations();
         return;
      }
   }

   void addInAllList() {
      this.moneyNeeded += operationCost;
      long aux;
      long smallestNegative = this.negativeNumbers.get(this.negativeNumbers.size() -1);
      for( int i=0; i< this.negativeNumbers.size(); i++ ) {
         aux = this.negativeNumbers.get(i);
         aux -= smallestNegative;
         if(aux < 0) {
            this.negativeNumbers.set(i, aux);
         } else {
            this.negativeNumbers.remove(i);
         }
      }
   }

   void computeIndividualOperations() {
      for(long number: this.negativeNumbers) {
         this.moneyNeeded += Math.abs(number);
      }
   }

   public static void main (String[] args) throws Exception {
      ChefIntegers problem = new ChefIntegers();
      problem.makeListPositive();
      System.out.println(problem.moneyNeeded);
   }
}