/**
 * Created by ddfrancisco on 18/08/2017.
 * https://www.codechef.com/problems/HORSES
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class RacingHorses {

   int numberOfHorses;
   List<Integer> orderedHorseSkills;
   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   public RacingHorses () throws Exception {
      Scanner scanner = new Scanner(reader.readLine());

      this.numberOfHorses = scanner.nextInt();
      Integer[] unorderedHorseSkills = new Integer[this.numberOfHorses];

      scanner = new Scanner(reader.readLine());
      for( int i=0; i < this.numberOfHorses; i++ ) {
         unorderedHorseSkills[i] = Integer.valueOf(scanner.nextInt());
      }
      this.orderedHorseSkills = Arrays.asList(unorderedHorseSkills);
      Collections.sort(this.orderedHorseSkills);
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();

      while( numberOfCases-- > 0 ) {
         RacingHorses race = new RacingHorses();
         int minimumSkillGap = Integer.MAX_VALUE;

         Integer[] orderedSkillsAsArray = (Integer[])race.orderedHorseSkills.toArray();
         for (int i=0; i < orderedSkillsAsArray.length -1; i++) {
            int firstHorseSkill = orderedSkillsAsArray[i].intValue();
            int secondHorseSkill = orderedSkillsAsArray[i+1].intValue();
            if((secondHorseSkill - firstHorseSkill) < minimumSkillGap) {
               minimumSkillGap = secondHorseSkill - firstHorseSkill;
            }
         }

         System.out.println(minimumSkillGap);
      }
   }
}
