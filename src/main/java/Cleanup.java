/**
 * Created by ddfrancisco on 18/08/2017.
 * https://www.codechef.com/problems/CLEANUP
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Cleanup {

   int n,m;
   boolean[] finishedTasks;
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public Cleanup() throws java.lang.Exception {
      int finishedTaskIndex;
      Scanner scanner = new Scanner(reader.readLine());

      this.n = scanner.nextInt();
      this.m = scanner.nextInt();
      this.finishedTasks = new boolean[n];

      scanner = new Scanner(reader.readLine());
      int pendingIndexes = this.m;
      while( pendingIndexes-- > 0 ) {
         finishedTaskIndex = scanner.nextInt();
         this.finishedTasks[finishedTaskIndex-1] = true;
      }
   }

   public static void main (String[] args) throws java.lang.Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         Cleanup cleanup = new Cleanup();
         StringBuilder chefTaskList = new StringBuilder();
         StringBuilder assistantTaskList = new StringBuilder();
         boolean isChefsTurn = true;

         for (int i = 0; i < cleanup.finishedTasks.length; i++) {
            if (!cleanup.finishedTasks[i]) {
               if (isChefsTurn) {
                  chefTaskList.append(String.format("%d ", i+1));
                  isChefsTurn = false;
               } else {
                  assistantTaskList.append(String.format("%d ", i+1));
                  isChefsTurn = true;
               }
            }
         }

         System.out.println(chefTaskList.toString().trim());
         System.out.println(assistantTaskList.toString().trim());
      }
   }
}
