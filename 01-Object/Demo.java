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
  }
 }
