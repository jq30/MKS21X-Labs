public class SuperArray {

  private String[] data;
  private int size;

/////

  public SuperArray() {
    //10 is arbitrary, should work for most/all purposes
    data = new String[10];
    size = 0;
  }

  public SuperArray(int n) throws IllegalArgumentException {
    if (n < 0) {
      throw new IllegalArgumentException("Oh noes! Don't use negwatif numbwers! ùwú! " + n + "is an invalid list size");
    }
    data = new String[n];
    size = 0;
  }

/////

  public int size() {
    return size;
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

  public int indexOf(String target) {
    for (int i = 0; i < data.length; i++) {
      if (target.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(String target) {
    for (int i = size - 1; i >= 0; i--) {
      if (target.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }

/////

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

  public boolean add(String s) {
    if (data.length < size + 1) {
      resize();
    }
    data[size] = s;
    size++;
    return true;
  }

  public boolean add(int index, String s) throws IndexOutOfBoundsException {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException("*sad uwu noises* Index " + index + " is out of bounds for length " + size);
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

  public String set(int i, String element) throws IndexOutOfBoundsException {
    if (i >= size || i < 0) {
      throw new IndexOutOfBoundsException("AHHHHHH WAIT NO! Index " + i + " is out of bounds for length " + size);
    }
    String old = data[i];
    data[i] = element;
    return old;
  }

  public String get(int i) throws IndexOutOfBoundsException {
    if (i >= size || i < 0) {
      throw new IndexOutOfBoundsException("w-wait! Index " + i + " is out of bounds for length " + size);
    }
    return data[i];
  }

  public String remove(int index) throws IndexOutOfBoundsException {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("(i don't see anything to kill...) Index " + index + " is out of bounds for length " + size);
    }
    //no need to resize because this is removing
    String[] newData = new String[data.length];
    size--;
    //copy values over until index
    for (int i = 0; i <= index; i++) {
      newData[i] = data[i];
    }
    //copy rest of values over, not including index
    //i dont like having two loops but this still works and runs in linear so ykyk?
    for (int i = index + 1; i < data.length; i++) {
      newData[i - 1] = data[i];
    }
    String removedValue = data[index];
    //overwrite memory address
    data = newData;
    return removedValue;
  }

  //the racist remove method
  public String remove(String target) throws IllegalArgumentException {
    int i = indexOf(target);
    if (i == -1) {
      throw new IllegalArgumentException("(maybe i dropped my glasses..?) " + target + " not found in SuperArray");
    }
    return remove(i);
  }
}
