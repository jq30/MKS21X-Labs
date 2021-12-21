public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {
  /***** Fields *****/


  /***** Constructors *****/

  public OrderedArrayList() {
    super();
  }

  public OrderedArrayList(int initialCapacity) {
    super(initialCapacity);
  }

  /***** Private Methods *****/

  private int whereToPlace(T value) {
    //find higest index such that value is greater than the one being compared
    for (int i = 0; i < size(); i++) {
      if (value.compareTo(get(i)) < 0) {
        return i;
      }
    }
    return size();
  }

  /***** Public Methods *****/

  @Override
  public boolean add(T obj) {
    super.add(whereToPlace(obj), obj);
    return true;
  }

  @Override
  public void add(int index, T obj) {
    this.add(obj);
  }

  /***** Main *****/
  public static void main(String[] args) {

  }
}
