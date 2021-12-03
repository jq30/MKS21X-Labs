import java.util.Scanner;
import java.io.*;

public class NON {
  private static boolean isVowel(char c) {
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    for (char x : vowels) {
      if (c == x) {
        return true;
      }
    }
    return false;
  }

  //require precondition that s.length() == 2
  private static boolean isDouble(String s) {
    return (s.charAt(0) == s.charAt(1));
  }

  private static boolean isIllegal(String s) {
    String[] illegalTerms = {"ab", "cd", "pq", "xy"};
    for (String x : illegalTerms) {
      if (s.equals(x)) {
        return true;
      }
    }
    return false;
  }

  private static boolean check(String s) {
    boolean vowelsCond = false;
    boolean doubleCond = false;
    boolean iTermsCond = true;

    //vowels count
    int count = 0;
    //vowel edge case
    if (isVowel(s.charAt(0))) {
      count++;
    }

    for (int i = 0; i < s.length() - 1; i++) {
      String sub = s.substring(i, i + 2);
      if (!vowelsCond && isVowel(s.charAt(i+1))) {
        count++;
        if (count >= 3) {
          vowelsCond = true;
        }
      }
      if (!doubleCond && isDouble(sub)) {
        doubleCond = true;
      }
      if (iTermsCond && isIllegal(sub)) {
        iTermsCond = false;
      }
    }

    return vowelsCond && doubleCond && iTermsCond;
  }

  private static boolean pairCondition(String s) {
    //c'est horrible, the runtime of this thing
    //make String[] of 2-letter substrings
    String[] fragments = new String[String.length - 1];
    for (int i = 0; i < String.length() - 1; i++) {
      fragments[i] = s.substring(i, i + 1);
    }
    //nested loop through String[] to see if there are any repeats
    for (int i = 0; i < fragments.length; i++) {
      String frag = fragments[i];
      //skip thingy immediately after because no overlap
      for (int j = i + 2; j < fragments.length - 2; j++) {
        if (frag.equals(fragments[j])) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean betweenRepeat(String s) {
    //loop through and see if i+2 matches index i
    for (int i = 0; i < s.length() - 2; i++) {
      if (s.charAt(i) == s.charAt(i+2)) {
        return true;
      }
    }
    return false;fragments[i]
  }

  private static checkv2(String s) {

  }

  public static void main(String[] args) {
    try {
      File file = new File(args[0]);
      Scanner sc = new Scanner(file);
      int count = 0;

      while (sc.hasNextLine()) {
        if (check(sc.nextLine())) {
          count++;
        }
      }
      System.out.println(count);
    } catch (FileNotFoundException AGHGHGH) {
      System.out.println("file not found or something, so find it yourself >:(");
    }
  }
}
