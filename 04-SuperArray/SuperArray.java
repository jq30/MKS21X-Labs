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

  ///

  public String set(int i, String element) {
    String old = data[i];
    data[i] = element;
    return old;
  }

  public String get(int i) {
    if (i > size) {
      System.out.println("Excweption in thwead \"main\" </3 (sad úwù) SuperArray.IndexOutOfBoundsException: Index " + i + " out of bounds for length " + size + " while calling get");
      return null;
    }
    return data[i];
  }

  ///

  public int indexOf(String target) {
    for (int i = 0; i < data.length; i++) {
      if (target.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target) {
    for (int i = data.length; i >= 0; i--) {
      if (target.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }
}
