import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ddfrancisco on 05/09/2017.
 * https://www.codechef.com/problems/MINIMAX
 */

/* Name of the class has to be "Main" only if the class is public. */
class Minimax {

   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   static Scanner scanner;
   List<Integer>[] rows, columns;
   List<Integer> candidateRows = new ArrayList<Integer>();
   List<Integer> candidateColumns = new ArrayList<Integer>();

   int maxR = Integer.MIN_VALUE, minC = Integer.MAX_VALUE;

   public Minimax() throws Exception {
      this.scanner = new Scanner(reader.readLine());
      final int N = scanner.nextInt();
      this.rows = (ArrayList<Integer>[]) new ArrayList[N];
      this.columns = (ArrayList<Integer>[]) new ArrayList[N];

      for(int i=0; i<N; i++) {
         this.rows[i] = new ArrayList<Integer>();
         this.scanner = new Scanner(reader.readLine());
         int currentR = Integer.MAX_VALUE;
         for(int j=0; j<N; j++) {
            if(i == 0) {
               this.columns[j] = new ArrayList<Integer>();
            }
            int currentNumber = scanner.nextInt();
            this.rows[i].add(new Integer(currentNumber));
            this.columns[j].add(new Integer(currentNumber));
            if( currentNumber < currentR ) {
               currentR = currentNumber;
            }
         }

         if(currentR == maxR) {
            this.candidateRows.add(new Integer(i));
         } else if (currentR > maxR) {
            maxR = currentR;
            this.candidateRows = new ArrayList<Integer>();
            this.candidateRows.add(new Integer(i));
         }
      }

      for (int i=0; i<this.columns.length; i++) {
         Collections.sort(this.columns[i]);
         int currentC = this.columns[i].get(this.columns[i].size() -1);

         if(currentC == this.minC) {
            this.candidateColumns.add(new Integer(i));
         } else if(currentC < this.minC) {
            this.minC = currentC;
            this.candidateColumns = new ArrayList<Integer>();
            this.candidateColumns.add(new Integer(i));
         }
      }
   }

   private int numberOfChangesNeeded(List<Integer> orderedList) {
      int rIndex = Math.abs(Collections.binarySearch(orderedList, new Integer(this.maxR)));
      int cIndex = Math.abs(Collections.binarySearch(orderedList, new Integer(this.minC)));
      return Math.abs(rIndex - cIndex);
   }

   public static void main (String[] args) throws Exception {
      int minChangesNeeded = Integer.MAX_VALUE;
      int currentChanges;
      Minimax testCase = new Minimax();

      if(testCase.maxR == testCase.minC) {
         minChangesNeeded = 0;
      } else {
         for (Integer i : testCase.candidateRows) {
            currentChanges = testCase.numberOfChangesNeeded(testCase.rows[i.intValue()]);
            if (minChangesNeeded > currentChanges) {
               minChangesNeeded = currentChanges;
            }
            if(minChangesNeeded == 1) break;
         }
         for (Integer i : testCase.candidateColumns) {
            currentChanges = testCase.numberOfChangesNeeded(testCase.columns[i.intValue()]);
            if (minChangesNeeded > currentChanges) {
               minChangesNeeded = currentChanges;
            }
            if(minChangesNeeded == 1) break;
         }
      }

      System.out.println(minChangesNeeded);
   }
}