public class GameScreen {
  public static void main(String[] args) {
    //clear
    Text.clear();

    //create an 30 by 80 border of color
    final int width = 80;
    final int height = 30;
    final int color = Text.BLUE + Text.BACKGROUND;

    //cursor position
    int row = 0;
    int col = 0;

    //make 4 random ints
    int[] ints = new int[4];
    for (int i = 0; i < ints.length; i++) {
      ints[i] = randInt(0, 99);
    }

    drawBorder(width, height, color);
    distribute(ints, width, height, 2); //2 is row after border

    //pl to place cursor on next row
    System.out.println();
  }

  private static void drawBorder(int width, int height, int color) {
    drawHorizontal(0, width, color); //top row
    drawHorizontal(height, width, color); //bottom row
    drawVertical(0, height, color); //left col
    drawVertical(width, height, color); //right col
  }

  private static void distribute(int[] ints, int width, int height, int y) {
    for (int i = 0; i < ints.length; i++) {
      int increment = (width / ints.length); //spacing to evenly distribute
      int offset = -(increment / 2); //offset to make it center-aligned
      Text.go(y, (i + 1) * increment + offset); //y := y position to print at
      System.out.print(ints[i]);
    }
    Text.go(height, 0); //place cursor at proper position
  }

  //return random number from lower to upper inclusive
  private static int randInt(int lower, int upper) {
    return (int)((Math.random() * (upper - lower + 1)) + lower);
  }

  private static void drawHorizontal(int row, int length, int color) {
    int col = 0;
    for (col = 1; col <= length; col++) {
      Text.go(row, col);
      System.out.print(Text.colorize(" ", color));
    }
  }

  private static void drawVertical(int col, int length, int color) {
    int row = 0;
    for (row = 1; row <= length; row++) {
      Text.go(row, col);
      System.out.print(Text.colorize(" ", color));
    }
  }
}
