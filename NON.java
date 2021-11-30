public class NON {
  private char[] vowels = {'a', 'e', 'i', 'o', 'u'};
  private Sting[] illegalTerms = {"ab", "cd", "pq", "xy"};

  private static boolean isVowel(char c) {
    for (char x : vowels) {
      if (c == x) {
        return true;
      }
    }
    return false;
  }

  public static boolean threeVowels(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) {
        count++;
      }
    }
    return count >= 3;
  }

  //require precondition that s.length() == 2
  private boolean isDouble(String s) {
    return (s.charAt(0) == s.charAt(1));
  }

  private boolean isNotIllegal(String s) {
    for (String x : illegalTerms) {
      if (s.equals(x)) {
        return false;
      }
    }
    return true;
  }

  private static boolean check(String s) {
    boolean vowelsCond = false;
    boolean doubleCond = false;
    boolean iTermsCond = false;

    //vowels count
    int count = 0;

    for (int i = 0; i < s.length() - 1; i++) {
      String sub = s.substring(i, i + 2);
      if (!vowelsCond && isVowel) {
        count++;
        if (count >= 3) {
          vowelsCond = true;
        }
      }
      if (!doubleCond || isDouble(sub)) {
        doubleCond = true;
      }
      if (!iTermsCond || isNotIllegal(sub)) {
        iTermsCond = true;
      }
    }

    //for debug
    System.out.println("vowels: " + vowelsCond);
    System.out.println("double: " + doubleCond);
    System.out.println("iterms: " + iTermsCond);

    return vowelsCond && doubleCond && iTermsCond;
  }
}
