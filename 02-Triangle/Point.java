public class Point {
  private double x,y;
  public Point(double X, double Y) {
    x = X;
    y = Y;
  }
  public Point(Point p) {
    x = p.x;
    y = p.y;
  }
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  }

  public static double distance(Point a, Point b) {
    return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
  }

  public double distanceTo(Point p) {
    return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public static boolean closeEnough(double a, double b) {
    if (a * b == 0) {
      return a == b;
    }
    double percentError = Math.abs(a - b) / a;
    return percentError < 0.00001;
  }

  public boolean equals(Point p) {
    if p = null {
      return false;
    }
    boolean xValues = closeEnough(x, p.x);
    boolean yValues = closeEnough(y, p.y);
    return xValues && yValues;
  }
}
