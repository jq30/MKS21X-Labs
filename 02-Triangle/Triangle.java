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

  public double getPerimeter() {
    double perimeter = Point.distance(v1, v2) + Point.distance(v2, v3) + Point.distance(v1, v3);
    return perimeter;
  }

  public Point getVertex(int i) {
    Point[] vertices = {v1, v2, v3};
    return vertices[i-1];
  }

  public void setVertex(int i, Point p) {
    //copies address of old vertex over
    Point vertex = getVertex(i);
    System.out.println(vertex);
    System.out.println(getVertex(i));
    System.out.println(getVertex(i).toString());
    vertex = p;
    System.out.println(vertex);
    System.out.println(vertex.toString());
    System.out.println(getVertex(i));
  }
}
