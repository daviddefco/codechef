/**
 * Created by ddfrancisco on 04/09/2017.
 * https://www.codechef.com/problems/STONES
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class JewelsAndStones {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   SortedSet<String> jewelDefinition;
   String[] stones;

   public JewelsAndStones() throws Exception {
      this.jewelDefinition = new TreeSet<String>(Arrays.asList(reader.readLine().split("")));
      this.stones = reader.readLine().split("");
   }

   private int jewelsFound() {
      int jewelsFound = 0;
      for ( int i=0; i < this.stones.length; i++ ) {
         if( this.jewelDefinition.contains(this.stones[i])) {
            jewelsFound++;
         }
      }
      return jewelsFound;
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         JewelsAndStones digging = new JewelsAndStones();
         System.out.println(digging.jewelsFound());
      }
   }
}