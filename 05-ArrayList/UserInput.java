import java.util.*;

public class UserInput {
  public static void main(String[] args) {
    ArrayList<Double> yummies = new ArrayList<Double>();
    System.out.print("Im hungry! Feed me numbers! A negative number is poison! Don't feed me negative number or I'll die!: ");
    Scanner bleh = new Scanner(System.in);
    double food = bleh.nextDouble();

    while (food >= 0) {
      yummies.add(food);
      System.out.print("Im hungry! Feed me numbers! A negative number is poison! Don't feed me negative number or I'll die!: ");
      food = bleh.nextDouble();
    }

    System.out.println("You fed: " + yummies);
    System.out.println("For a total of " + yummies.size() + " numbers");


    if (yummies.size() > 0) {
      double avg = 0;
      double min = yummies.get(0);
      double max = yummies.get(0);

      for (int i = 0; i < yummies.size(); i++) {
        avg += yummies.get(i);
        if (min > yummies.get(i)) {
          min = yummies.get(i);
        }
        if (max < yummies.get(i)) {
          max = yummies.get(i);
        }
      }
      avg /= (double)yummies.size();

      System.out.println("Mean: " + avg);
      System.out.println("Min Value: " + min);
      System.out.println("Max Value: " + max);
    }
  }
}
