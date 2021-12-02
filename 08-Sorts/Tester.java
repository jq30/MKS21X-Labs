import java.util.*;

//for int[] only
public class Tester {
  public static void main(String[] args) {
    if (args.length > 0) {
      try {
          long seed = Long.parseLong(args[0]);
      } catch (Exception BWAHAHA) {
        System.out.println("you screwed something up what did u even put in args");
      }
      Random rng = new Random(seed);
    } else {
        Random rng = new Random();
    }

    //very small arrays
    int[] size0 = new int[0];
    int[] size1 = new int[1];

    //relatively large array
    int[] bigbig = new int[100];

    //same value array
    int[] sameValue = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    //already sorted array
    int[] sorted = new int[10];

    //reverse sorted array
    int[] reverse = new int[10];

    //list of all arrays
    int[][] things = {size0, size1, bigbig, sorted, reverse, sameValue};

    //list of all arrays to fill with random values
    int[][] stuff = {size0, size, bigbig, sorted, reverse};

    //fill stuff with random values
    for (int[] x : stuff) {
      for (int i = 0; i < x.length; i++) {
        x[i] = rng.nextInt();
      }
    }

    //sort using util.Arrays
    Arrays.sort(sorted);
    Arrays.sort(reverse);
  }
}
