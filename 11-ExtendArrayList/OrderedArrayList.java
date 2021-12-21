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

  @Override
  public T set(int index, T obj) {
    T replaced = super.remove(index);
    this.add(obj);
    return replaced;
  }

  public int indexOf(T obj) {
    //edge case
    if (size() == 0) {
      return -1;
    }

    int start = 0;
    int mid = size() / 2;
    int end = size() - 1;

    //hard coding because im lazy
    if (get(end).equals(obj)) {
      return end;
    }
    if (get(start).equals(obj)) {
      return start;
    }

    while (end > start) {
      if (get(start).equals(obj)) {
        return end;
      }
      if (get(start).equals(obj)) {
        return start;
      }

      mid = (start + end) / 2;
      if (get(mid).equals(obj)) {
        return mid;
      } else if (get(mid).compareTo(obj) < 0) {
        System.out.println("uwu");
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
