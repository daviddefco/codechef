import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ddfrancisco on 29/08/2017.
 * https://www.codechef.com/problems/LAPIN
 */

/* Name of the class has to be "Main" only if the class is public. */
class Lapindrome {

   static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   private String testingString;

   public Lapindrome(String testingString) {
      this.testingString = testingString;
   }

   public static void main (String[] args) throws Exception {
      Scanner scanner = new Scanner(reader.readLine());
      int numberOfCases = scanner.nextInt();
      Lapindrome testCase;

      while( numberOfCases-- > 0 ) {
         boolean isLapindrome = true;
         testCase = new Lapindrome(reader.readLine());
         Map<String, Integer> charCounter = new HashMap<String, Integer>();
         String[] splitString = testCase.splitTestString();

         String[] firstSubstringSplit = splitString[0].split("");
         for (int i=0; i < firstSubstringSplit.length; i++) {
            String key = firstSubstringSplit[i];
            if(charCounter.containsKey( key )) {
               charCounter.put(key, Integer.valueOf(charCounter.get(key).intValue() + 1));
            } else {
               charCounter.put(key, Integer.valueOf(1));
            }
         }

         String[] secondSubstringSplit = splitString[1].split("");
         for (int i=0; i < secondSubstringSplit.length; i++) {
            String key = secondSubstringSplit[i];
            if(charCounter.containsKey( key )) {
               charCounter.put(key, Integer.valueOf(charCounter.get(key).intValue() - 1));
            } else {
               isLapindrome = false;
               break;
            }
         }

         if(isLapindrome) {
            for(String key: charCounter.keySet()) {
               if(charCounter.get(key).intValue() != 0) {
                  isLapindrome = false;
                  break;
               }
            }
         }

         System.out.println(isLapindrome ? "YES" : "NO");
      }
   }

   private String[] splitTestString() {
      int middlePoint = this.testingString.length() / 2;
      String[] splitString = new String[2];
      splitString[0] = this.testingString.substring(0, middlePoint);
      splitString[1] = (this.testingString.length() % 2 == 0) ?
        this.testingString.substring(middlePoint) :
        this.testingString.substring(middlePoint + 1);
      return splitString;
   }
}