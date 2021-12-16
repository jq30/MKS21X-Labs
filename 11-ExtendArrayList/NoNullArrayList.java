import java.util.ArrayList;

public class NoNullArrayList<T> extends ArrayList<T> {
  /***** Fields *****/


  /***** Constructors *****/

  public NoNullArrayList() {
    super();
  }

  public NoNullArrayList(int initialCapacity) {
    super(initialCapacity);
  }

  /***** Private Methods *****/


  /***** Public Methods *****/

  public boolean add(T obj) throws IllegalArgumentException {
    if (!(obj == null)) {
      return super.add(obj);
    } else {
      throw new IllegalArgumentException("Error adding null to ArrayList");
    }
  }
}
