import java.util.*;
public class StuyabloGame{
  /***** FIELDS/SCREEN SPECIFICATIONS *****/

  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  /***** DRAW METHODS *****/

  //Display a List of 1-4 adventurers on the rows row through row+3 (4 rows max)
  //Should include Name and HP on 2 separate lines. (more to be added later)
  public static void drawParty(ArrayList<Adventurer> party,int startRow){
    //store what to print as three String[]
    String[] names = new String[party.size()];
    String[] hps = new String[party.size()];
    String[] energies = new String[party.size()];
    for (int i = 0; i < party.size(); i++) {
      Adventurer guy = party.get(i);

      names[i] = guy.getName();
      energies[i] = guy.getSpecialName() + ": " + guy.getSpecial() + "/" + guy.getSpecialMax();

      //color hp accordingly
      String hp = "HP: " + guy.getHP() + "/" + guy.getmaxHP();
      if ((double)guy.getHP() / guy.getmaxHP() < 0.25) {
        hp = Text.colorize(hp, Text.RED);
      } else if ((double)guy.getHP() / guy.getmaxHP() > 0.75) {
        hp = Text.colorize(hp, Text.GREEN);
      }
      hps[i] = hp;
    }

    //use distribute method to print on screen
    GameScreen.distribute(names, WIDTH, HEIGHT, startRow);
    GameScreen.distribute(hps, WIDTH, HEIGHT, startRow + 1, 10);
    GameScreen.distribute(energies, WIDTH, HEIGHT, startRow + 2);

    //this method isnt very efficient but isnt terribly slow to the point of impacting performance either
  }

  //Display a line of text starting at column 2 of the specified row.
  public static void drawText(String s,int startRow){
    s = " " + s; //extra space so text doesn't touch border
    CoolPrint.print(s, startRow, 2);
  }

  public static void drawScreen(){
    GameScreen.screen(WIDTH, HEIGHT, BORDER_BACKGROUND);
  }


 /***** MAIN *****/

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();
    Text.go(1,1);


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1 enemy to it.
    ArrayList<Adventurer>enemies = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    enemies.add(new Warrior("Principal Yu", "YOU ARE SUSPENDED!!!1!!11!!111", 345));
    enemies.add(new Wizard("Mayor Adams", "NO REGENTS WEEK FOR YOU!!!!!!!!!", 0));
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 3 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    party.add(new Wizard("Duwumbleduwu", "discount dumbledore", 100, 100, 1000));
    party.add(new Warrior("cat", "meow?", 20, 30, 400));
    party.add(new Wizard("magic banana", "nana?", Integer.MAX_VALUE, Integer.MAX_VALUE, 10));
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Main loop
    boolean partyTurn = false;
    int whichPlayer = 0;
    int turn = 0;


    String input = "";
    Scanner in = new Scanner(System.in);
    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){

      //Draw the window border
      Text.hideCursor();
      drawScreen();

      //display current state of all Adventurers
      drawParty(party,2);
      drawParty(enemies,HEIGHT-5);

      //display event based on last turn's input
      if(partyTurn){
        //Process user input:
        if(input.equals("") || input.equals("a") || input.equals("attack")){
          Adventurer attacker = party.get(whichPlayer);
          Adventurer target = enemies.get(GameScreen.randInt(0, enemies.size()-1));
          drawText(attacker.attack(target), HEIGHT/2);
        }
        else if(input.equals("s") || input.equals("special")){
          Adventurer attacker = party.get(whichPlayer);
          Adventurer target = enemies.get(GameScreen.randInt(0, enemies.size()-1)); //pick random member of enemy team
          drawText(attacker.specialAttack(target), HEIGHT/2);
        }
        //display current state of all Adventurers
        drawParty(party,2);
        drawParty(enemies,HEIGHT-5);
        whichPlayer++;



        if(whichPlayer < party.size()){
          drawText("Enter command for "+party.get(whichPlayer)+
                   ": attack/special/quit",HEIGHT/2 + 1);
        }else{
          drawText("Press enter to see monster's turn",HEIGHT/2 + 1);
          partyTurn = false;
        }
      }else{
        //this block ignores user input!
        //display enemy attack except on turn 0.
        if(turn > 0){
          //Enemy action choices go here!
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          for (int i = 0; i < enemies.size(); i++) {
            Adventurer attacker = enemies.get(i);
            Adventurer target = party.get(GameScreen.randInt(0, party.size()-1)); //pick random member of party

            drawText(attacker.attack(target), HEIGHT/2);
          }
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //after enemy goes, change back to player's turn.
        partyTurn=true;
        whichPlayer = 0;
        //display which player's turn is next and prompt for action.
        drawText("Enter command for "+party.get(whichPlayer)+": attack/special/quit",HEIGHT/2 + 1);

        //end the turn.
        turn++;
      }

      //Draw the prompt
      Text.reset();
      Text.go(HEIGHT+1,1);
      Text.showCursor();
      System.out.print(">");
      //Read user input
      input = in.nextLine();
    }

    //After quit reset things:
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void main(String[] args) {
    run();
  }
}
