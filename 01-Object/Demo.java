public class Demo{
  /* more methods can go here*/
  public static double distance(Point a, Point b) {
    double xa = a.getX();
    double ya = a.getY();
    double xb = b.getX();
    double yb = b.getY();

    return Math.sqrt(Math.pow(xa - xb, 2) + Math.pow(ya - yb, 2));
  }

  public static void main(String[]args){
    Point P1 = new Point(1,1);
    Point P2 = new Point(2,2);

    //for these two points it should return root 2 (about 1.414)
    System.out.println(  distance(P1,P2)); //call1
    System.out.println(  Point.distance(P1,P2)); //call 2
    System.out.println(  P1.distanceTo(P2)); //call 3
    //This one is IMPLIED strongly. You cannot tell by the calling style alone,
    //but you can make an educated guess.

    //this should make a 3-4-5 triangle
    Point A = new Point(0, 4);
    Point B = new Point(3, 0);
    Point C = new Point(0, 0);

    //more test cases
    System.out.println(A.distanceTo(B)); //should return 5
    System.out.println(distance(A, C)); //should return 4
    System.out.println(Point.distance(B, C)); //should return 3

    //a 1-1-sqrt(2) 45-45-90 triangle
    Point D = new Point(0, 0);
    Point E = new Point(1, 1);
    Point F = new Point(1, 0);

    //test cases go brrrr
    System.out.println(A.distance(D, E)); //should return ~1.414
    System.out.println(F.distance(F, E)); //should return 1
    System.out.println(F.distanceTo(E)); //should return 1
  }
 }
