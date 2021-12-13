/* Lab9: Word Search generator */

import java.io.*; //File, FileNotFoundException
import java.util.*; //ArrayList

public class WordSearch{
    //char[][] for the grid
    private char[][] data;

    //old constructor
    public WordSearch(int rows, int cols, String fileName) {
      data = new char[rows][cols];
      clear();
    }

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
    private ArrayList<String> wordsToAdd = new ArrayList<String>();

    public WordSearch( int rows, int cols, String fileName, int randSeed){
      //intialize Random
      rng = new Random(randSeed);
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

    private void addAllWords() {
      /*Attempt to add all of the words from the wordsToAdd list using the algorithm described above*/
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
