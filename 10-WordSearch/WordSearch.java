/* Lab9: Word Search generator */

import java.io.*; //File, FileNotFoundException
import java.util.*; //ArrayList, Scanner

public class WordSearch{
    //char[][] for the grid
    private char[][] data;

    //a random Object to unify your random calls
    private Random rng;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded;

    /*New Constructors:  Both will read in the word text file, then run addAllWords().
     *Do not fill in random letters after.*/

    public WordSearch( int rows, int cols, String fileName){
        //Choose a randSeed using the clock random
    }

    //ArrayList to store words left to add
    private ArrayList<String> wordsToAdd;

    public WordSearch( int rows, int cols, String fileName, int randSeed){
      //intialize stuff
      data = new char[rows][cols];
      rng = new Random(randSeed);
      wordsToAdd = new ArrayList<String>();

      clear();
      addAllWords();

      System.out.println("wordsToAdd: " + wordsToAdd.toString());
    }


      //sets everything in grid to underscores
      private void clear() {
        for (int i = 0; i < data.length; i++) {
          for (int j = 0; j < data[i].length; j++) {
            data[i][j] = '_';
          }
        }
      }

    //omni-directional addWord
    private boolean addWord(String word,int row, int col, int rowInc, int colInc){
      //check if both increments are 0
      if (rowInc == 0 && colInc == 0) {
        return false;
      }

      //loop through both word and data to check if word will fit
      try {
        for (int i = 0; i < word.length(); i++) {
          if (!(data[row + (rowInc * i)][col + (colInc * i)] == '_' || data[row + (rowInc * i)][col + (colInc * i)] == word.charAt(i))) {
            //return false for word unsuccessfully added
            return false;
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }

      //add the word
      for (int i = 0; i < word.length(); i++) {
        data[row + (rowInc * i)][col + (colInc * i)] = word.charAt(i);
      }

      //return true for word successfully added
      return true;
    }
    /* OLD ADDWORDS
    public boolean addWordHorizontal(String word, int row, int col) {
      //loop through both word and data[row]
      //to check if word will fit
      try {
        for (int i = 0; i < word.length(); i++) {
          if (!(data[row][col + i] == '_' || data[row][col + i] == word.charAt(i))) {
            return false;
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }

      for (int i = 0; i < word.length(); i++) {
        data[row][col + i] = word.charAt(i);
      }
      return true;
    }

    public boolean addWordDiagonal(String word, int row, int col) {
      try {
        for (int i = 0; i < word.length(); i++) {
          if (!(data[row][col + i] == '_' || data[row][col + i] == word.charAt(i))) {
            return false;
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }

      for (int i = 0; i < word.length(); i++) {
        data[row + i][col + i] = word.charAt(i);
      }
      return true;
    }

    public boolean addWordVertical(String word, int row, int col) {
      //loop through both word and data[row]
      //to check if word will fit
      try {
        for (int i = 0; i < word.length(); i++) {
          if (!(data[row][col + i] == '_' || data[row][col + i] == word.charAt(i))) {
            return false;
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }

      for (int i = 0; i < word.length(); i++) {
        data[row + i][col] = word.charAt(i);
      }
      return true;
    }
    */

    //fill ArrayList using words from document
    private void parseWords(String filename) {
      try {
        File F = new File(filename);
        Scanner sc = new Scanner(F);
        while (sc.hasNextLine()) {
          wordsToAdd.add(sc.nextLine());
        }
      } catch (FileNotFoundException bah) {
        System.out.println("File " + filename + " not found!");
        System.exit(1);
      }
    }

    //add all the words
    private void addAllWords(String filename) {
      parseWords(filename);

      //loop through ArrayList
      for (int i = 0; i < wordsToAdd.length(); i++) {
        //try 20 times to add the word
        for (int j = 0; j < 20; j++) {
          //use
          addWord(wordsToAdd.get(i), rng.nextInt() % );
        }
      }
    }

    //small math function to get sign of random number
    private static int normal(int n) {
      return n / Math.abs(n);
    }

    /*THE REST OF YOUR METHODS HERE*/

    //toString method that prints out grid and words to search and seed
    public String toString() {
      String output = "";
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          output += data[i][j];
          if (!(j == data[i].length - 1)) {
            output += " ";
          }
        }
        if (!(i == data.length - 1)) {
          output += "\n";
        }
      }
      return output;
    }
}
