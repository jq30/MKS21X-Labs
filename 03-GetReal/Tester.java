public class Tester {
  public static void main(String[] args) {
    if (args[0].compareTo("rational")) {
      RationalNumber n = RationalNumber(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    } else {
      RealNumber n = RealNumber(Double.parseDouble(args[1]));
    }
    System.out.println("getValue: " + n.getValue());
    System.out.println();
  }
}
