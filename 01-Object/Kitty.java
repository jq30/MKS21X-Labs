public class Kitty {
  private int age;
  private String name;

  public Kitty() {
    name = "Mittens";
    age = 2;
  }

  public Kitty(String inputName, int inputAge) {
    name = inputName;
    age = inputAge;
  }


  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return "The amazing " + name;
  }


  public void makeOlder() {
    age++;
  }

  public void changeName(String newName) {
    name = newName;
  }
}
