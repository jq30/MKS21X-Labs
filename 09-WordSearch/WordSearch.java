/* Lab9: Word Search generator */

import java.io.*; //File, FileNotFoundException

public class WordSearch{
    private char[][] data;

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param rows is the starting height of the WordSearch
     *@param cols is the starting width of the WordSearch
     */
    public WordSearch(int rows, int cols, String fileName) {
      data = new char[rows][cols];
      clear();
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear() {
      for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
          data[i][j] = '_';
        }
      }
    }

    //a random Object to unify your random calls
    private Random randgen;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded;

    /*New Constructors:  Both will read in the word text file, then run addAllWords().
     *Do not fill in random letters after.*/

    public WordSearch( int rows, int cols, String fileName){
        //Choose a randSeed using the clock random
    }

    public WordSearch( int rows, int cols, String fileName, int randSeed){
        //Use the random seed specified.
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
    *The word is added in the direction rowIncrement,colIncrement
    *Words must have a corresponding letter to match any letters that it overlaps.
    *
    *@param word is any text to be added to the word grid.
    *@param row is the vertical locaiton of where you want the word to start.
    *@param col is the horizontal location of where you want the word to start.
    *@param rowInc is -1,0, or 1 and represents the displacement of each letter in the row direction
    *@param colInc is -1,0, or 1 and represents the displacement of each letter in the col direction
    *@return true when: the word is added successfully.
    *        false (and do not change the board at all) when any of the following happen:
    *        a) rowInc and colInc are both 0,
    *        b) the word doesn't fit,
    *        c) there are overlapping letters that do not match
    */
    private boolean addWord(String word,int row, int col, int rowInc, int colInc){
    }


    private void addAllWords() {
      /*Attempt to add all of the words from the wordsToAdd list using the algorithm described above*/
    }

    /*THE REST OF YOUR METHODS HERE*/

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
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


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word, int row, int col) {
      //loop through both word and data[row]
      //to check if word will fit
      for (int i = 0; i < word.length(); i++) {
        if (!(data[row][col + i] == '_' || data[row][col + i] == word.charAt(i))) {
          //return false for word unsuccessfully added
          return false;
        }
      }

      //add the word
      for (int i = 0; i < word.length(); i++) {
        data[row][col + i] = word.charAt(i);
        System.out.println(this.toString());
      }

      //return true for word successfully added
      return true;
    }

    //generalized version of addWord
    public boolean addWord(String word, int row, int col, int rowInc, int colInc) throws IllegalArgumentException {
      //check if both increments are 0
      if (rowInc == 0 && colInc == 0) {
        throw new IllegalArgumentException("Both row and column increments cannot be 0!");
      }

      //loop through both word and data to check if word will fit
      for (int i = 0; i < word.length(); i++) {
        if (!(data[row + (rowInc * i)][col + (colInc * i)] == '_' || data[row + (rowInc * i)][col + (colInc * i)] == word.charAt(i))) {
          //return false for word unsuccessfully added
          return false;
        }
      }

      //add the word
      for (int i = 0; i < word.length(); i++) {
        data[row + (rowInc * i)][col + (colInc * i)] = word.charAt(i);
      }

      //return true for word successfully added
      return true;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
      addWord(word, row, col, 1, 0);
    }

    /**Adds as many words as possible from a file.
      *The program will attempt to randomly add the words to the grid multiple times.
      *
      *
      *@param fileName is the file containing the words it should be adding to the grid.
      *
    */

}
