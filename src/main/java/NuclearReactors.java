/**
 * Created by ddfrancisco on 31/08/2017.
 * https://www.codechef.com/problems/NUKES
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class NuclearReactors {
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   final long FIRED_PARTICLES;
   final int CHAMBER_THRESHOLD;
   int[] chambers;

   public NuclearReactors() throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      this.FIRED_PARTICLES = scanner.nextLong();
      this.CHAMBER_THRESHOLD = scanner.nextInt();
      chambers = new int[scanner.nextInt()];
   }

   private void bombParticle(int chamberNumber) {
      if(this.chambers[chamberNumber] < CHAMBER_THRESHOLD) {
         this.chambers[chamberNumber]++;
      } else {
         this.chambers[chamberNumber] = 0;
         if(chamberNumber < (this.chambers.length -1)) {
            bombParticle(chamberNumber +1);
         }
      }
   }

   public static void main (String[] args) throws Exception {
      NuclearReactors experiment = new NuclearReactors();
      long remainingParticles = experiment.FIRED_PARTICLES;
      while( remainingParticles-- > 0 ) {
         experiment.bombParticle(0);
      }
      StringBuilder chamberStatus = new StringBuilder();
      for( int i=0; i < experiment.chambers.length; i++ ) {
         chamberStatus.append(String.format("%d ", experiment.chambers[i]));
      }
      System.out.println(chamberStatus.toString().trim());
   }
}