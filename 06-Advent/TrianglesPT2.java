import java.io.*;
import java.util.Scanner;

public class TrianglesPT2/*ELECTRIC BOOGEALOO*/ {
    private static boolean isTriangle(int[] sideLengths) {
      return (
        sideLengths[0] + sideLengths[1] > sideLengths[2] &&
        sideLengths[1] + sideLengths[2] > sideLengths[0] &&
        sideLengths[0] + sideLengths[2] > sideLengths[1]
      );
    }

    public static void main(String[] args) {
      int count = 0;
      try {
        File file = new File("data.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
          String line = input.nextLine();
          Scanner sideLength = new Scanner(line);

          int[][]

          if (isTriangle(a, b, c)) {
            count++;
          }
        }
        System.out.println("Number of possible triangles: " + count);
      } catch (FileNotFoundException bwahahahahah) {
        System.out.println("No data.txt provided!! idiot!!!");
      }
    }
}
