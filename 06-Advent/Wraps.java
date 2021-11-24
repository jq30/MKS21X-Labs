import java.io.*;
import java.util.*;

public class Wraps {
  public static int paper(String[] dimensions) {
    int a = Integer.parseInt(dimensions[0]);
    int b = Integer.parseInt(dimensions[1]);
    int c = Integer.parseInt(dimensions[2]);

    int sideA = a * b;
    int sideB = b * c;
    int sideC = a * c;

    int surfaceArea = 2 * (sideA + sideB + sideC);
    int slack = Math.min(Math.min(sideA, sideB), Math.min(sideA, sideC));

    return surfaceArea + slack;
  }

  public static void main(String[] args) {
    try {
      File file = new File(args[0]);
      Scanner input = new Scanner(file);

      int total = 0;
      while (input.hasNextLine()) {
        total += paper(input.nextLine().split("x"));
      }
      input.close();
      System.out.println("Total wrapping paper needed: " + total);
    } catch (FileNotFoundException LOLZ) {
      System.out.println(args[0] + " not found!");
    }
  }
}
