import java.util.*;

public class UserInput {
  public static void main(String[] args) {
    ArrayList<Double> food = new ArrayList<Double>();
    Scanner bleh = new Scanner(System.in);

    while (bleh.hasNextLine()) {
      System.out.print("Im hungry! Feed me numbers! A negative number is poison! Don't feed me negative number or I'll die!: ");
      food.add(bleh.nextDouble());
    }

    System.out.println(food);
  }
}
