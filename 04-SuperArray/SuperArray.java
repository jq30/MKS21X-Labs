public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String s) {
    data[size] = s;
    size++;
    return true;
  }

  public String toString() {
    String output = "[";
    for (int i = 0; i < size; i++) {
      output += data[i];
      if (i != size - 1) {
        output += ", ";
      }
    }
    return output += "]";
  }

  public String toStringDebug() {
    String output = "[";
    for (int i = 0; i < data.length; i++) {
      output += data[i];
      if (i != data.length - 1) {
        output += ", ";
      }
    }
    return output += "]";
  }
}
