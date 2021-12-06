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

  public static void insertionSort(int[] data) {

    for (int i = 1; i < data.length; i++) {
      if (data[i] < data[i-1]) {
        int p = 0;
        //place to hold thingy
        int placeholder = data[i];
        for (int j = i - 1; j >= 0; j--) {
          //loop backwards to find thingy less than thingy we're moving
          if (data[j] < data[i]) {
            //p is the index we're moving thingy to
            p = j + 1;
          }
        }
        //move everyone over because data[i] is mvp
        for (int k = p; k < i; k++) {
          
        }
      }
    }
  }

  //provide int[] and params in args
  public static void main(String[] args) {
    int[] a = new int[args.length];
    int p = 0;
    for (int i = 0; i < args.length; i++) {
      try {
        a[i] = Integer.parseInt(args[i]);
      } catch (NumberFormatException e) {
        //i was told not to use break :c
        p = i;
        i = args.length;
      }
    }

    System.out.println(Arrays.toString(a));

    if (args[p].equals("-bubble")) {
      bubbleSort(a);
    } else if (args[p].equals("-selection")) {
      selectionSort(a);
    } else if (args[p].equals("-insertion")) {

    } else {
      selectionSort(a);
    }

    System.out.println(Arrays.toString(a));
  }
}
