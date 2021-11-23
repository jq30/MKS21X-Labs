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

    private static boolean isTriangle(String a, String b, String c) {
      int s1 = Integer.parseInt(a);
      int s2 = Integer.parseInt(b);
      int s3 = Integer.parseInt(c);
      return isTriangle(s1, s2, s3);
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
        System.out.println("File " + filename + " not found!! idiot!!!");
      }
    }

    public static void vertically(String filename) {
      int count = 0;
      try {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        ArrayList<String[]> data = new ArrayList<String[]>();
        while (input.hasNextLine()) {
          String line = input.nextLine();
          data.add(line.split(" "));
        }


        for (int i = 0; i < data.size(); i += 3) {
          for (int j = 0; j < 5; j+=2) {
            if (isTriangle(data.get(i)[j], data.get(i+1)[j], data.get(i+2)[j])) {
              count++;
            }
          }
        }

        System.out.println("Number of possible triangles: " + count);
      } catch (FileNotFoundException bwahahahahah) {
        System.out.println("File " + filename + " not found!! idiot!!!");
      }
    }
  }
