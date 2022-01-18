public class Warrior extends Adventurer {
    private int  rage;
    private String warcry;

    //maxHP defaults to 10
    public Warrior(){
	     this("Magnus");
    }

    public Warrior(String name){
	     this(name,"Valhalllaaaaa!!", 10);
    }

    public Warrior(String name, String warcry, int rage){
      this(name, warcry, rage, 10, 10);
    }

    public Warrior(String name, String warcry, int rage, int maxRage, int maxHP) {
      super(name, maxHP, maxHP);
      setWarcry(warcry);
      setRage(rage);
    }

    //warrior methods

    public String attack(Damageable other){
    	  int damage = (int)(Math.random()*10)+1;
  	    other.applyDamage(damage);
  	    setRage(getRage() + 1);
  	   return (this +
            " attacked " + other + " for " +
            damage + " damage!");
    }

    public String specialAttack(Damageable other){
	     if(getRage() >= 10){
  	        int damage = (int)(Math.random()*20)+1;
            other.applyDamage(damage);
            setRage(getRage() - 10);
            return (this + " unleashes his fury upon "
             + other + " for " + damage + " damage! "+warcry);
	    }else{
          attack(other);
			    return ("Not enough rage! ");
	    }
    }

    //get methods

    public int getRage(){
	     return rage;
    }

    //set methods
    public void setRage(int r){
	     this.rage = r;
    }

    public void setWarcry(String warcry){
	     this.warcry = warcry;
    }


    //implements abstract in Adventurer
    public String getSpecialName() {
      return "Rage";
    }

    public int getSpecial() {
      return rage;
    }

    public int getSpecialMax() {
      return 50;
    }
}
