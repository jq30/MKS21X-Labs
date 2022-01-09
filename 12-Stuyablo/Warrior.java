public class Warrior extends Adventurer {
    private int  rage;
    private String warcry;

    public Warrior(){
	     this("Magnus");
    }

    public Warrior(String name){
	     this(name,"Valhalllaaaaa!!", 18);
    }

    public Warrior(String name, String warcry, int rage){
      super(name,30+(int)(Math.random()*10));
      setWarcry(warcry);
      setRage(rage);
    }

    //warrior methods

    public void attack(Damageable other){
    	  int damage = (int)(Math.random()*10)+1;
  	    other.applyDamage(damage);
  	    setRage(getRage() + 1);
  	    System.out.println(this +
            " attacked " + other + " for " +
            damage + " damage!");
    }

    public void specialAttack(Damageable other){
	     if(getRage() >= 10){
  	        int damage = (int)(Math.random()*20)+1;
            other.applyDamage(damage);
            System.out.println(this + " unleashes his fury upon "
             + other + " for " + damage + " damage! "+warcry);
            setRage(getRage() - 10);
	    }else{
			    System.out.println("Not enough rage! ");
          attack(other);
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


}
