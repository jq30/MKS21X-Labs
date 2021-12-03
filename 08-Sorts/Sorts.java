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
        }
      }
    }
  }

  public static void selectionSort(int[] data) {
    int pointer; //where sorted section stops
    int minValue, minIndex;

    for (pointer = 0; pointer < data.length; pointer++) {
      //assume minValue is @ start of unsorted section until proven otherwise
      minValue = data[pointer];
      minIndex = pointer;
      //find min value in array
      for (int i = pointer; i < data.length; i++) {
        if (data[i] < minValue) {
          minValue = data[i];
          minIndex = i;
        }
      }

      //swap values
      int swap = data[pointer];
      data[pointer] = data[minIndex];
      data[minIndex] = swap;
    }
  }

  public static void main(String[] args) {
    int[] a = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      a[i] = Integer.parseInt(args[i]);
    }

    selectionSort(a);
    System.out.println(Arrays.toString(a));
  }
}
