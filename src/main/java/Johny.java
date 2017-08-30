/**
 * Created by ddfrancisco on 18/08/2017.
 * https://www.codechef.com/problems/JOHNY
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Johny {

   int numberOfSongs;
   int johnySongDuration;
   List<Integer> orderedPlaylist;
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public Johny () throws Exception {
      Scanner scanner = new Scanner(reader.readLine());

      this.numberOfSongs = scanner.nextInt();
      Integer[] playlist = new Integer[this.numberOfSongs];

      scanner = new Scanner(reader.readLine());
      for(int i = 0; i < this.numberOfSongs; i++ ) {
         playlist[i] = Integer.valueOf(scanner.nextInt());
      }

      scanner = new Scanner(reader.readLine());
      int johnySongPosition = scanner.nextInt() -1;
      this.johnySongDuration = playlist[johnySongPosition];

      this.orderedPlaylist = Arrays.asList(playlist);
      Collections.sort(this.orderedPlaylist);
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         Johny testCase = new Johny();
         int newJohnyPosition = Collections.binarySearch(testCase.orderedPlaylist, testCase.johnySongDuration);
         System.out.println(newJohnyPosition + 1);
      }
   }
}
