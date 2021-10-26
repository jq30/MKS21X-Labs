public class closeEnough {
  public static boolean closeEnough(double a, double b) {
    if (a * b == 0) {
      return a == b;
    }
    double percentError = Math.abs(a - b) / a;
    return percentError < 0.00001;
  }

  public static void main(String[] args) {
    double a = Double.parseDouble(args[0]);
    double b = Double.parseDouble(args[1]);
    System.out.println(closeEnough(a, b));
  }
}
