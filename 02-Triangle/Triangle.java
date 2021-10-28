public class Triangle {
  private Point v1, v2, v3;
  private double[] sideLengths;

  public Triangle(Point A, Point B, Point C) {
    v1 = new Point(A);
    v2 = new Point(B);
    v3 = new Point(C);
    sideLengths = new double[] {
      Point.distance(v1, v2),
      Point.distance(v2, v3),
      Point.distance(v1, v3)
    };
  }

  public Triangle(double a, double b, double c, double d, double e, double f) {
    v1 = new Point(a, b);
    v2 = new Point(c, d);
    v3 = new Point(e, f);
    sideLengths = new double[] {
      Point.distance(v1, v2),
      Point.distance(v2, v3),
      Point.distance(v1, v3)
    };
  }

  public double getPerimeter() {
    double perimeter = Point.distance(v1, v2) + Point.distance(v2, v3) + Point.distance(v1, v3);
    return perimeter;
  }

  public Point getVertex(int i) {
    Point[] vertices = {v1, v2, v3};
    return vertices[i-1];
  }

  public void setVertex(int i, Point p) {
    if (i == 1) {
      v1 = new Point(p);
    } else if (i == 2) {
      v2 = new Point(p);
    } else if (i == 3) {
      v3 = new Point(p);
    }
  }

  public String toString() {
    String s = "{";
    Point[] vertices = {v1, v2, v3};
    for (int i = 0; i < vertices.length; i++) {
      s += vertices[i].toString();
      if (i != vertices.length - 1) {
        s += ", ";
      }
    }
    return s + "}";
  }

  public boolean equals(Triangle T) {
    if (T == null) {
      return false;
    }
    return v1.equals(T.v1) && v2.equals(T.v2) && v3.equals(T.v3);
  }

  public String classify() {
    String[] classification = {"scalene", "isosceles", "uwu", "equilateral"};
    int equalSides = 0;
    if (Point.closeEnough(sideLengths[0], sideLengths[1])) {
      equalSides++;
    }
    if (Point.closeEnough(sideLengths[0], sideLengths[2])) {
      equalSides++;
    }
    if (Point.closeEnough(sideLengths[1], sideLengths[2])) {
      equalSides++;
    }
    return classification[equalSides];
  }

  public double area() {
    double a = sideLengths[0];
    double b = sideLengths[1];
    double c = sideLengths[2];

    double s = (a + b + c) / 2.0;
    double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    return area;
  }
}
