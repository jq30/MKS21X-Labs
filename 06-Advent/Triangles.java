import java.io.*;
import java.util.Scanner;

public class Triangles {
    private static boolean isTriangle(int a, int b, int c) {
      return (
        a + b > c &&
        b + c > a &&
        a + c > b
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
          int a = sideLength.nextInt();
          int b = sideLength.nextInt();
          int c = sideLength.nextInt();
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
