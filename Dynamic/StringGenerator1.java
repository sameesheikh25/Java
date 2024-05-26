package Dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringGenerator1 {
    public static List<String> generateCombinations(String str) {
        Set<String> allCombinations = new HashSet<>();
        generateCombinationsHelper(str, "", allCombinations);
        return allCombinations.stream().toList();
      }
    
      private static void generateCombinationsHelper(String remainingString, String currentString, Set<String> allCombinations) {
        if (remainingString.isEmpty()) {
          allCombinations.add(currentString);
          return;
        }
    
        for (int i = 0; i < remainingString.length(); i++) {
          char c = remainingString.charAt(i);
          String newString = currentString + c;
          String remaining = remainingString.substring(0, i) + remainingString.substring(i + 1);
          System.out.println(i+" "+c+" "+newString+" "+remaining);
          generateCombinationsHelper(remaining, newString, allCombinations);
        }
      }
    
      public static void main(String[] args) {
        String str = "aab";
        List<String> allPossibleCombinations = generateCombinations(str);
    
        System.out.println("All possible combinations of '" + str + "':");
        for (String combination : allPossibleCombinations) {
          System.out.println(combination);
        }
      }
}
