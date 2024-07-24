import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

/**
* The helper class that contains most of the code used to run the war game
* from the MagicalCreaturesGame class.
*
* @author Youssef Boujebha
* @date 10/24/21
*/
public class MagicalCreaturesHelper{   
   static Scanner scan;
   public static File file = new File("creatures.txt");
   public static ArrayList<MagicalCreature> creatures = new ArrayList<>();
   public static int moves;
   public static int alive;
   
   /**
   * Creates and populates the arraylist of creatures.
   */
   public static void fillData(){
      scan = new Scanner(file);
      while (scan.hasNext()){
         creatures.add(scan.next());
      }
      scan.close();
   }
   
   /**
   * Reads a line from the data file, then creates and returns a magical creature.
   */
   public static void processLine(){
      String line;
      String[] temp;
      
      try{
         scan = new Scanner(file);
      }catch (Exception e){
         System.out.println("Error opening the file!");
        }
      
      while (scan.hasNextLine()){
         line = scan.nextLine();
         temp = line.split(",");
         fillData();
      }
   }
   
   /**
   * Inputs the creature arraylist and scanner, then randomly selects a killer and a victim.
   * Asks for the wand attribute if its a genie and the shield attribute if its an elf. It then
   * uses the kill method to decide the winner.
   */
   public static void war(){
      Random rand = new Random();
      int alpha = 0, beta, i = 0, j = 10;
           
      
      }
   
   /**
   * Asks the user for the number of moves to make and calls the war method that many times.
   *
   * @return The war method until i > the number the user input.
   */
    public static void playGame(){
      int i = 0;
      
      System.out.println("How Many Moves Do You Want To Play The Game For: ");
      scan = new Scanner(System.in);
      moves = scan.nextInt();
      
      while(moves > i){
         war();
         i++;
      }
         
    }

}