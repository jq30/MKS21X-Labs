public class Draw {
  public static void main(String[] args) {
    //clear
    Text.clear();

    //create an 30 by 30 border of color
    final int height = 30;
    final int width = 30;
    final int color = Text.BLUE;

    //cursor position
    int row = 0;
    int col = 0;

    //draw border
    drawHorizontal(0, 30, color); //top row
    drawHorizontal(height, 30, color); //bottom row

    //pl to place cursor on next row
    System.out.println();
  }

  private static void drawHorizontal(int row, int length, int color) {
    int col = 0;
    for (col = 1; col <= length; col++) {
      Text.go(row, col);
      System.out.print(Text.colorize("M", color));
    }
  }
}
