public class Wizard/* (ACTUALLY A MAGE) */ extends Adventurer {
  private int mana;
  private String flavor;

  public Wizard(String Name, String flavor, int mana) {
    super(Name);
    this.mana = mana;
    this.flavor = flavor;
  }

  //does damage scaling with half of current mana
  //restores mana inversely scaling with amount of damage dealt
  public String attack(Damageable other) {
    int damage = mana / 2;
    int manaRestore = 30 / (damage + 1) + 1;

    other.applyDamage(damage);
    mana += manaRestore;

    return this.toString() + " attacked " + other.toString() + " for " + damage + " damage and recovered " + manaRestore + " mana!";
  }

  //counsumes all mana and deals damage according to amount of mana consumed
  public String specialAttack(Damageable other) {
    if (mana > 20) {
      int damage = mana;
      mana = 0;

      other.applyDamage(damage);
      return this.toString() + " used special attack on " + other + " dealing " + damage + " damage! " + flavor;
    } else {
      attack(other);
      return("Not enough mana!");
    }
  }

  ///////

  public int getmaxHP() {
    return this.maxHP;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int n) {
    mana = n;
  }

  public int getSpecial() {
    return this.getSpecial();
  }

  public int getSpecialMax() {
    return this.getSpecialMax();
  }
}
