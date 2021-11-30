public class NON {
  private char[] vowels = {'a', 'e', 'i', 'o', 'u'};

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

  
}
