import java.io.*;
import java.util.*;

public class Triangles {
    private static boolean isTriangle(int a, int b, int c) {
      return (
        a + b > c &&
        b + c > a &&
        a + c > b
      );
    }

    public static void main(String[] args) {
      String filename = args[0];
      int mode = Integer.parseInt(args[1]);

      if (mode == 1) {
          horizontally(filename);
      } else if (mode == 2) {
          vertically(filename);
      }
    }

    public static void horizontally(String filename) {
      int count = 0;
      try {
        File file = new File(filename);
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
        System.out.println("File " + filename + " not found!!");
      }
    }

    public static void vertically(String filename) {
      int count = 0;
      try {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        ArrayList<int[]> data = new ArrayList<int[]>();
        while (input.hasNextLine()) {
          String line = input.nextLine();
          Scanner sc = new Scanner(line);
          int[] linebutarray = new int[3];
          int p = 0;
          while (sc.hasNextInt()) {
            linebutarray[p] = sc.nextInt();
            p++;
          }
          data.add(linebutarray);
        }


        for (int i = 0; i < data.size(); i += 3) {
          for (int j = 0; j < 3; j++) {
            if (isTriangle(data.get(i)[j], data.get(i+1)[j], data.get(i+2)[j])) {
              count++;
            }
          }
        }

        System.out.println(count);
      } catch (FileNotFoundException bwahahahahah) {
        System.out.println("File " + filename + " not found!!");
      }
    }
  }
