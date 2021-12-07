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
    //loop through looking for when next number is smaller than current index
    for (int i = 0; i < data.length - 1; i++) {
      if (data[i+1] < data[i]) {
        //find index to put this thingy
        //0 for put in beginning of array if no target found
        int target = 0;
        for (int j = i; j >= 0; j--) {
          if (data[j] < data[i+1]) {
            target = j + 1;
            //exit loop
            j = -1;
          }
        }

        //relocate values
        int placeholder = data[target];
        data[target] = data[i + 1];
        for (int k = target + 1; k < i + 1; k++) {
          int x = data[k];
          data[k] = placeholder;
          placeholder = x;
        }
        data[i+1] = placeholder;
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

    System.out.println("Starting: " + Arrays.toString(a));
/*
    if (args[p].equals("-b")) {
      bubbleSort(a);
    } else if (args[p].equals("-s")) {
      selectionSort(a);
    } else if (args[p].equals("-i")) {
      insertionSort(a);
    } else {
      selectionSort(a);
    }
*/

    insertionSort(a);
    System.out.println("Sorted: " + Arrays.toString(a));
  }
}
