public class Wizard/* (ACTUALLY A MAGE) */ extends Adventurer {
  private int mana;

  public Wizard(String Name, String aaaa; int mana) {
    super(Name);
    this.mana = mana;
  }

  public void attack(Damageable other) {
    int damage = mana / 2;
    int manaRestore = 100 / damage + 1;

    other.applyDamage(damage);
    mana += manaRestore;

    System.out.println(this.toString() + " attacked " + other.toString() + " for " + damage + " damage!");
    System.out.println(this.toString() + " recovered " + manaRestore + " mana!");
  }

  public void specialAttack(Damageable other) {
    if (mana > 20) {
      int damage = other.getHP() / 2 + 5 + mana;
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
