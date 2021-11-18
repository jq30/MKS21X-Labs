import java.util.ArrayList;

public class ArrayListPractice {
  public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();

    for (int i = 0; i < 200000; i++) {
      a.add("0x" + i);
      b.add("0x" + i);
    }

    /*
    System.out.println("replaceEmpty: " + replaceEmpty(a));
    System.out.println("makeReversedList: " + makeReversedList(a));
    System.out.println("mixLists: " + mixLists(a, b));
    */

    System.out.println("finished");
  }

  public static ArrayList<String> replaceEmpty( ArrayList<String> data){
    //return an new ArrayList that has all of the values of the original ArrayList except
    //that all empty strings are replaced with the word "Empty".
    ArrayList<String> output = new ArrayList<String>(data.size());
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i).equals("")) {
        output.add(i, "Empty");
      } else {
        output.add(data.get(i));
      }
    }
    return output;
  }

  public static ArrayList<String> makeReversedList( ArrayList<String> data){
    //return a new ArrayList that is in the reversed order of the parameter.
    ArrayList<String> output = new ArrayList<String>(data.size());
    for (int i = data.size() - 1; i >= 0; i--) {
      output.add(data.get(i));
    }
    return output;
  }

  public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
    //return a new ArrayList that has all values of a and b in alternating order that is:
    //a[0], b[0], a[1], b[1]...
    //when one list is longer than the other, just append the remaining values to the end.
    ArrayList<String> output = new ArrayList<String>(a.size() + b.size());
    int i;
    for (i = 0; i < Math.min(a.size(), b.size()); i++) {
      output.add(a.get(i));
      output.add(b.get(i));
    }
    while (i < Math.max(a.size(), b.size())) {
      if (i < a.size()) {
        output.add(a.get(i));
      }
      if (i < b.size()) {
        output.add(b.get(i));
      }
      i++;
    }
    return output;
  }
}
