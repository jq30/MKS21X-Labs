public class SuperArray {
  private String[] data;
  private int size;

  public SuperArray() {
    data = new String[10];
    size = 0;
  }

  public SuperArray(int n) throws IllegalArgumentException {
    data = new String[n];
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String s) {
    if (data.length < size + 1) {
      resize();
    }
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

  private void throwOOB(int i, String func) {
    System.out.println("Excweption in thwead \"main\" </3 (sad úwù) SuperArray.IndexOutOfBoundsException: Index " + i + " out of bounds for length " + size + " while calling " + func);
  }

  public String get(int i) {
    if (i > size) {
      throwOOB(i, "get");
      return null;
    }
    return data[i];
  }

  ///

  private void resize() {
    //double the size of data
    String[] newData = new String[data.length * 2];
    //copy the values over
    for (int i = 0; i < data.length; i++) {
      newData[i] = data[i];
    }
    //overwrite memory address
    data = newData;
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

///

  public String remove(int index) {
    if (index > size - 1) {
      throwOOB(index, "remove");
    }
    //no need to resize because this is removing
    String[] newData = new String[data.length];
    size--;
    //copy values over until index
    for (int i = 0; i <= index; i++) {
      newData[i] = data[i];
    }
    //copy rest of values over, not including index
    //i dont like having two loops either but this still works and runs in linear so ykyk
    for (int i = index + 1; i < data.length; i++) {
      newData[i - 1] = data[i];
    }
    String removedValue = data[index];
    //overwrite memory address
    data = newData;
    return removedValue;
  }

  ///

  public boolean add(int index, String s) {
    if (index > size) {
      throwOOB(index, "add");
    }
    //adding 1 to length just in case
    String[] newData = new String[data.length + 1];
    size++;
    //same approach as remove using 2 for loops
    for (int i = 0; i < index; i++) {
      newData[i] = data[i];
    }
    //insert
    newData[index] = s;
    //copy rest of data over
    for (int i = index; i < data.length; i++) {
      newData[i+1] = data[i];
    }
    //overwrite memory address
    data = newData;
    //return true as formality
    return true;
  }

  ///

  //the racist remove method
  public String remove(String target) {
    size--;
    return remove(indexOf(target));
  }
}
