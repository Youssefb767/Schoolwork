import java.util.*;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

/**
* The main driver that is used to play a war game with the previously created MagicalCreature
* class and subclass'.
* The war game is played in turns, with the number of turns decided by the user. Each turn consists of 
* two creatures attacking eachother, following the rules of the game to decide who wins the duel, with each
* creature being chosen at random from the creatures ArrayList.
* Dead creatures are removed from the ArrayList, which removes them from the random number pool, and the list of
* creatures that are alive gets printed after each move.
* <p>
* Here are the rules of the war game: <p>
* 1. Dragons cannot be killed <p>
* 2. A young dragon who is under 40 years old cannot kill <p>
* 3. Elves and Goblins cannot kill <p>
* 4. Elves can have a shield. Those with a shield cannot be killed <p>
* 5. Genies can have wands. Only Genies that have a wand can kill <p>
* 6. Creatures cannot kill themselves
* 
* @author Youssef Boujebha
* @date 10/24/21
*/
public class MagicalCreaturesGame{
   public static File file = new File("creatures.txt");
   static Scanner scan;
   public static ArrayList<MagicalCreature> creatures = new ArrayList<>();

   /**
   * The main method that uses methods from the helper class to run the war game.
   */
   public static void main(String[] args){ 
      MagicalCreaturesHelper.fillData(); //The ArrayList of creatures.
      MagicalCreaturesHelper.playGame(); //Asks the user for the number of moves and calls the war method that many times.
      displayCreatures();
    }
    
    /**  
    * Removes dead creatures from the arraylist and prints
    * the remaining creatures.
    */  
    public static void displayCreatures(){
      System.err.println("Creatures That Are Still Alive: ");
      for( MagicalCreature e : creatures){
         System.err.println(e.getName());
      }
      System.out.println();
   }
}