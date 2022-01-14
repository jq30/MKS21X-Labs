import java.util.Random;
public abstract class Adventurer implements Damageable{
    private String name;
    private int HP;

    //Abstract methods are meant to be implemented in child classes.
    private int maxHP;
    public int getmaxHP(){
      return maxHP;
    }
    public void setmaxHP(int newMax){
      maxHP = newMax;
    }

    //return a String that contains the description of the results of the attack
    public abstract String attack(Damageable other);

    //return a String that contains the description of the results of the specialAttack
    public abstract String specialAttack(Damageable other);

    //return the name of the special resource the class uses
    public abstract String getSpecialName();

    //return the value of the current and maximum special resource
    public abstract int getSpecial();
    public abstract int getSpecialMax();



    public Adventurer(){
  	   this("Lester");
    }

    public Adventurer(String name){
  	   this(name, 10);
    }

    public Adventurer(String name, int hp){
       this.name = name;
       this.HP = hp;
    }

    //toString method
    public String toString(){
    	return this.getName();
    }

    //Get Methods
    public String getName(){
    	return name;
    }

    public int getHP(){
	     return HP;
    }

    public void applyDamage(int amount){
      this.HP -= amount;
    }

    //Set Methods
    public void setHP(int health){
	     this.HP = health;
    }

    public void setName(String s){
	     this.name = s;
    }
}
