import java.util.Arrays;

public class Sorts {
  public static void bubbleSort(int[] data) {
    for (int k = data.length - 1; k > 0; k--) {
      for (int i = 0; i < k; i++) {
        if (data[i] > data[i+1]) {
          //place to hold the thingy
          int n = data[i+1];
          //swap terms
          data[i+1] = data[i];
          data[i] = n;

          //for debug
          System.out.println("Iteration " + (data.length - k) + ": " + Arrays.toString(data));
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      a[i] = Integer.parseInt(args[i]);
    }

    System.out.println("Initial: " + Arrays.toString(a));

    bubbleSort(a);
  }
}
