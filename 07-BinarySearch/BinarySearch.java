import java.util.Arrays;

public class BinarySearch {
  public static int BinarySearch(int[] data, int target) {
    //edge case
    if (data.length == 0) {
      return -1;
    }

    int start = 0;
    int mid = data.length / 2;
    int end = data.length - 1;

    //hard coding because im lazy
    if (data[end] == target) {
      return end;
    }
    if (data[start] == target) {
      return start;
    }

    while (end > start) {
      mid = (start + end) / 2;
      if (data[mid] == target) {
        return mid;
      } else if (data[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int n = 5;

    //int[] from args
    int[] agh = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      agh[i] = Integer.parseInt(args[i]);
    }
    System.out.println(Arrays.toString(agh));

    //BinarySearch
    System.out.println("Target = " + n);
    System.out.println(BinarySearch(agh, n));
  }
}
