import java.io.*; //File, FileNotFoundException
import java.util.*; //Scanner, ArrayList

public class textDemo {
  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (Exception E) {
      System.out.println("if you're seeing this message in the terminal then it's the end of the world");
    }
  }

  private static char randomChar() {
    //magic numbers go brrrrrrr
    // 26 = size of alphabet 97 = 'a' ASCII value
    return (char)(int)(Math.random() * 26 + 97);
  }

  private static String[] arrayListToArray(ArrayList<String> list) {
    String[] output = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      output[i] = list.get(i);
    }
    return output;
  }

  private static void obfuscatingPrint(String[] words) {
    int row = 1;
    int col = 1;

    Text.hideCursor();
    Text.clear();

    while (row < words.length + 1) {
      String word = words[row - 1];

      Text.go(row,col);
      for (int i = 0; i < word.length(); i++) {
        //repeat obfuscating 10 times
        for (int k = 0; k < 10; k++) {
          Text.go(row, col);
          System.out.print(randomChar());
          sleep(5);
        }
        //overwrite obfuscated character with proper
        Text.go(row, col);
        System.out.print(word.charAt(i));
        sleep(10);

        //move on to next col
        col++;
      }
      //move on to next row so col resets
      col = 1;
      row++;
    }

    //reset the thingy so terminal doesn't get messed up
    System.out.println();
    Text.reset();
    Text.showCursor();
  }

  public static void main(String[] args) {
    String filename = args[0];
    try {
      //scan file and put everything in arraylist
      File input = new File(filename);
      Scanner sc = new Scanner(input);
      ArrayList<String> text = new ArrayList<String>();

      while (sc.hasNextLine()) {
        text.add(sc.nextLine());
      }

      //convert arraylist to array
      String[] stuff = arrayListToArray(text);

      //do the thing
      obfuscatingPrint(stuff);
    } catch (FileNotFoundException e) {
      System.out.println("Error opening file: " + filename);
    }
  }
}
