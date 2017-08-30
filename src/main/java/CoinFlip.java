/**
 * Created by ddfrancisco on 29/08/2017.
 * https://www.codechef.com/problems/CONFLIP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class CoinFlip {

   int gamesPlayed;
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public CoinFlip () throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      this.gamesPlayed = scanner.nextInt();
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         CoinFlip game = new CoinFlip();
         int remainingGames = game.gamesPlayed;

         while( remainingGames-- > 0 ) {
            scanner = new Scanner(reader.readLine());
            int I = scanner.nextInt();
            long rounds = scanner.nextLong();
            int Q = scanner.nextInt();
            boolean queryInitialPosition = I == Q;

            if( queryInitialPosition ) {
               System.out.println((long)Math.ceil(rounds/2));
            } else {
               System.out.println((long)(rounds - Math.ceil(rounds/2)));
            }
         }
      }
   }
}
