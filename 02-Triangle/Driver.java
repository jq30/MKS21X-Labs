public class Driver {
  public static void main(String[] args) {
    /*
    double[] a = new double[6];
    for (int i = 0; i < args.length; i++) {
      a[i] = Double.parseDouble(args[i]);
    }
    Triangle tri = new Triangle(a[0], a[1], a[2], a[3], a[4], a[5]);
    */

    Triangle tri = new Triangle(0, 0, 3, 0, 4, 0);

    System.out.println(tri.toString());
    System.out.println(tri.getPerimeter());

    Point newVertex = new Point(312, 12);
    tri.setVertex(3, newVertex);

    System.out.println(tri.getVertex(1).toString());
    System.out.println(tri.getVertex(2).toString());
    System.out.println(tri.getVertex(3).toString());
  }
}
