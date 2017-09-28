/**
 * Created by ddfrancisco on 08/09/2017.
 * https://www.codechef.com/problems/CHEFFED
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class ElephantLemonade {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   static Scanner scanner;
   int numberOfRooms;

   Map<Integer, List<Integer>> bottlesPerRoom = new HashMap<Integer, List<Integer>>();
   List<Integer> roomsVisited = new ArrayList<Integer>();

   public ElephantLemonade() throws Exception {
      scanner = new Scanner(reader.readLine());
      this.numberOfRooms = scanner.nextInt();

      int numberOfVisits = scanner.nextInt();
      scanner = new Scanner(reader.readLine());
      while ( numberOfVisits-- > 0 ) {
         roomsVisited.add( scanner.nextInt() );
      }

      int numberOfRoom = 0;
      while( numberOfRoom < this.numberOfRooms -1 ) {
         scanner = new Scanner(reader.readLine());
         List<Integer> bottlesInRoom = new ArrayList<Integer>();
         while ( scanner.hasNextInt() ) {
            bottlesInRoom.add(scanner.nextInt());
         }
         Collections.sort(bottlesInRoom);
         bottlesPerRoom.put(numberOfRoom, bottlesInRoom);
         numberOfRoom++;
      }
   }

   int runTest() {
      int litresDrunk = 0;
      for( int visit: roomsVisited ) {
         List<Integer> bottlesInVisit = bottlesPerRoom.get(visit);
         litresDrunk += bottlesInVisit.get(bottlesInVisit.size() -1);
         bottlesInVisit.remove(bottlesInVisit.size() -1);
         bottlesPerRoom.put(visit, bottlesInVisit);
      }
      return litresDrunk;
   }


   public static void main (String[] args) throws Exception {
      scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();
      while ( numberOfCases-- > 0 ) {
         ElephantLemonade testCase = new ElephantLemonade();
         System.out.println( testCase.runTest() );
      }
   }
}