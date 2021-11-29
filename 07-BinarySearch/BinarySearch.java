public class BinarySearch {
  public static int BinarySearch(int[] data, int target) {
    int start = 0;
    int mid = data.length / 2;
    int end = data.length - 1;
    while (end > start) {
      if (data[mid] == target) {
        return mid;
      } else if (data[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    //int[] from args
    int[] agh = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      int[i] = Integer.parseInt(args[i]);
    }

    //BinarySearch
    System.out.println(BinarySearch(agh, 0));
  }
}
