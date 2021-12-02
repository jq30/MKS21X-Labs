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
