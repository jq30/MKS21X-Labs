public class tester {
  public static void main(String[] args) {
    WordSearch aaaaaaaaaaaaaaaaaaaaaa = new WordSearch(10, 10);

    System.out.println("Constructor");
    System.out.println(aaaaaaaaaaaaaaaaaaaaaa.toString());

    System.out.println("addWordHorizontal");
    System.out.println(aaaaaaaaaaaaaaaaaaaaaa.addWord("kekw", 2, 2, 1, 1));

    System.out.println(aaaaaaaaaaaaaaaaaaaaaa.addWord("osu!", 8, 7, -1, 0));

    System.out.println("final");
    System.out.println(aaaaaaaaaaaaaaaaaaaaaa.toString());
  }
}
