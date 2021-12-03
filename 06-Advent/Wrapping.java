import java.io.*;
import java.util.*;

public class Wrapping {
  //return min of two numbers (logic is for losers)
  private static int min(int a, int b) {
    return (a + b - Math.abs(a - b)) / 2;
  }

  //return min of three numbers
  private static int min(int a, int b, int c) {
    return min(min(a, b), c);
  }

  //return max of two numbers (im not cheating you're cheating)
  private static int max(int a, int b) {
    return Math.max(a, b);
  }

  //return max of three numbers
  private static int max(int a, int b, int c) {
    return max(max(a, b), c);
  }

  public static int paper(String[] dimensions) {
    int a = Integer.parseInt(dimensions[0]);
    int b = Integer.parseInt(dimensions[1]);
    int c = Integer.parseInt(dimensions[2]);

    int sideA = a * b;
    int sideB = b * c;
    int sideC = a * c;

    int surfaceArea = 2 * (sideA + sideB + sideC);
    int slack = min(sideA, sideB, sideC);

    return surfaceArea + slack;
  }

  public static int ribbon(String[] dimensions) {
    int a = Integer.parseInt(dimensions[0]);
    int b = Integer.parseInt(dimensions[1]);
    int c = Integer.parseInt(dimensions[2]);

    int tie = 2 * (a + b + c - max(a, b, c)); //2 times sum of two smaller numbers
    int bow = a * b * c;

    return tie + bow;
  }

  public static void main(String[] args) {
    try {
      File file = new File(args[0]);
      Scanner input = new Scanner(file);

      int total = 0;
      if (args[1].equals("1")) {
        while (input.hasNextLine()) {
          total += paper(input.nextLine().split("x"));
        }
      } else {
        while (input.hasNextLine()) {
          total += ribbon(input.nextLine().split("x"));
        }
      }
      input.close();
      System.out.println(total);
    } catch (FileNotFoundException LOLZ) {
      System.out.println(args[0] + " not found!");
    }
  }
}
