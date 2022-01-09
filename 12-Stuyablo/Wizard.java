public class Wizard/* (ACTUALLY A MAGE) */ extends Adventurer {
  private int mana;

  public Wizard(String Name, String aaaa, int mana) {
    super(Name);
    this.mana = mana;
  }

  //does damage scaling with half of current mana
  //restores mana inversely scaling with amount of damage dealt
  public void attack(Damageable other) {
    int damage = mana / 2;
    int manaRestore = 30 / (damage + 1) + 1;

    other.applyDamage(damage);
    mana += manaRestore;

    System.out.println(this.toString() + " attacked " + other.toString() + " for " + damage + " damage!");
    System.out.println(this.toString() + " recovered " + manaRestore + " mana!");
  }

  //counsumes all mana and deals damage according to amount of mana consumed
  public void specialAttack(Damageable other) {
    if (mana > 20) {
      int damage = mana;
      mana = 0;

      other.applyDamage(damage);
      System.out.println(this + " used special attack on " + other + " dealing " + damage + " damage!");
    } else {
      System.out.println("Not enough mana!");
      attack(other);
    }
  }

  ///////

  public int getMana() {
    return mana;
  }

  public void setMana(int n) {
    mana = n;
  }
}
