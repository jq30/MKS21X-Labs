public class SortedArrayList<T extends Comparable<T>> extends NoNullArrayList {
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
    int i;
    for (i = 0; value.compareTo(get(i)) < 0; i++) {}
    return i;
  }

  /***** Public Methods *****/


}
