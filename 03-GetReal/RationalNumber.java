public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    } else {
      numerator = nume;
      denominator = deno;
    }
    reduce();
  }

  public double getValue(){
    double n = (double)numerator / (double)denominator;
    return n;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return getValue() == other.getValue();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return "" + numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if (a * b == 0) {
      return 0;
    }
    int r = a;
    int greater,lesser;
    if (a == b) {
      return a;
    } else if (a > b) {
      greater = a;
      lesser = b;
    } else {
      greater = b;
      lesser = a;
    }
    r = greater % lesser;
    while (r != 0) {
      greater = lesser;
      lesser = r;
      r = greater % lesser;
    }
    return lesser;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcd = gcd(numerator, denominator);
    if (gcd != 0) {
      numerator = numerator / gcd;
      denominator = denominator / gcd;
    } else {
      denominator = 1;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    int newNum = numerator * other.numerator;
    int newDen = denominator * other.denominator;
    return new RationalNumber(newNum, newDen);
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    int newNum = numerator * other.denominator;
    int newDen = denominator * other.numerator;
    return new RationalNumber(newNum, newDen);
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    //finding lcm doesn't matter because it is going to be reduced anyway
    int newNum = numerator * other.denominator;
    int newDen = denominator * other.denominator;

    newNum += other.numerator * denominator;

    return new RationalNumber(newNum, newDen);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber inverse = other.multiply(new RationalNumber(-1, 1));
    return this.add(inverse);
  }
}
