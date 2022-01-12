public class Draw {
  public static void main(String[] args) {
    //create an 80 by 30 border of color
    final int height = 80;
    final int width = 30;
    final int color = Text.BLUE;

    //cursor position
    int row = 0;
    int col = 0;

    //draw top row
    for (col = 1; col <= 30; col++) {
      Text.go(1, col);
      System.out.print(Text.colorize("M", color));
    }
  }
}
