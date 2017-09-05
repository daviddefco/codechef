/**
 * Created by ddfrancisco on 01/09/2017.
 * https://www.codechef.com/problems/CARVANS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Carvans {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   int numberOfCars;
   int[] carMaxSpeeds;

   public Carvans () throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      this.numberOfCars = scanner.nextInt();
      this.carMaxSpeeds = new int[this.numberOfCars];
      scanner = new Scanner(reader.readLine());
      for ( int i=0; i < this.carMaxSpeeds.length; i++ ) {
         this.carMaxSpeeds[i] = scanner.nextInt();
      }
   }

   private int carsAtMaxSpeed() {
      int carsAtMaxSpeed = 0;
      int currentSpeed = Integer.MAX_VALUE;
      for ( int i=0; i < this.carMaxSpeeds.length; i++ ) {
         if( this.carMaxSpeeds[i] <= currentSpeed ) {
            currentSpeed = this.carMaxSpeeds[i];
            carsAtMaxSpeed++;
         }
      }
      return carsAtMaxSpeed;
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         Carvans race = new Carvans();
         System.out.println(race.carsAtMaxSpeed());
      }
   }
}