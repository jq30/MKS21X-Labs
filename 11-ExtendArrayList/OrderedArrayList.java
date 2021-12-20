public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList {
  /***** Fields *****/


  /***** Constructors *****/

  public SortedArrayList() {
    super();
  }

  public SortedArrayList(int initialCapacity) {
    super(initialCapacity);
  }

  /***** Private Methods *****/

  public int whereToPlace(T value) {
    //find higest index such that value is greater than the one being compared
    for (int i = 0; i < size(); i++) {
      if (value.compareTo(get(i)) > 0) {
        return i;
      }
    }
    return size();
  }

  /***** Public Methods *****/


  /***** Main *****/
  public static void main(String[] args) {

  }
}
