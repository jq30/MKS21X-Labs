public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  /*
  *Return the sum of this and the other
  */
  public double add(RealNumber other){

     //other can be ANY RealNumber, including a RationalNumber

     //or other subclasses of RealNumber (that aren't written yet)

     return value + other.getValue();
  }

  /*
  *Return the product of this and the other
  */
  public double multiply(RealNumber other){
    return value * other.getValue();
  }

  /*
  *Return the this divided by the other
  */
  public double divide(RealNumber other){
    return value / other.getValue();
  }

  /*
  *Return the this minus the other
  */
  public double subtract(RealNumber other){
    return value - other.getValue();
  }

  public int compareTo(RealNumber n) {/*
    return negative //if a < b
    return 0 //if a == b
    return positive //if a > b
    //ANY NEGATIVE/POSTIVE VALUE WORKS AS LONG AS IT IS THE RIGHT SIGN*/
    double diff = getValue() - n.getValue();
    if (diff == 0) {
      return 0;
    }
    return (int)(diff - 1);
  }

  public double getValue(){
    return value;
  }

  public String toString(){
    return ""+value;
  }
}
