public class Triangle {
  private Point v1, v2, v3;

  public Triangle(Point A, Point B, Point C) {
    v1 = new Point(A);
    v2 = new Point(B);
    v3 = new Point(C);
  }

  public Triangle(double a, double b, double c, double d, double e, double f) {
    v1 = new Point(a, b);
    v2 = new Point(c, d);
    v3 = new Point(e, f);
  }
}
