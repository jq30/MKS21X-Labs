public class Driver {
  public static void main(String[] args) {
    double[] a = new double[6];
    for (int i = 0; i < args.length; i++) {
      a[i] = Double.parseDouble(args[i]);
    }
    Triangle tri = new Triangle(a[0], a[1], a[2], a[3], a[4], a[5]);

    System.out.println(tri.classify());
    System.out.println(tri.area());
  }
}

//stuff
/*
Triangle tri = new Triangle(0, 0, 3, 0, 4, 0);
System.out.println(tri.toString());
System.out.println("Perimeter: " + tri.getPerimeter()); //should be 8
Point newVertex = new Point(312, 12);
tri.setVertex(3, newVertex);
System.out.println();
System.out.println("New Vertices:");
System.out.println(tri.getVertex(1).toString());
System.out.println(tri.getVertex(2).toString());
System.out.println(tri.getVertex(3).toString());
System.out.println(tri.toString());
System.out.println("New Perimeter: " + tri.getPerimeter());

System.out.println();

Point v1 = new Point(1, 1);
Point v2 = new Point(2, 1);
Point v3 = new Point(1, 2);
Triangle uwu = new Triangle(v1, v2, v3);
System.out.println(uwu);
System.out.println("Perimeter: " + uwu.getPerimeter()); //should be 1+1+rt(2) = about 3.414
uwu.setVertex(1, new Point(2, 2));
uwu.setVertex(2, new Point(4, 2));
uwu.setVertex(3, new Point(2, 4));
System.out.println(uwu.toString());
System.out.println("Perimeter: " + uwu.getPerimeter()); //should be double that of prev perimeter ~6.818
*/
