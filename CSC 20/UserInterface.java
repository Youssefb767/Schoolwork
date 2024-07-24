import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

/**
* A class that creates the user interface for the menu that lets you enter
* all the information used to run the program (factory name, stop number, etc.).
*
* @author Youssef Boujebha
* @date 11/14/21
*/ 
public class UserInterface{

   /**
   * The main method that runs the program.
   */ 
   public static void main(String[] args) throws FileNotFoundException {
      Train t=new Train("car.txt");
      Scanner scan=new Scanner(System.in);
      String option="q";
      String fact,mat;
      int stop;
   do{
      menu();
      option=scan.nextLine();
      if(option.equalsIgnoreCase("d")){
         t.displayTrainCars();
      }
      else if(option.equalsIgnoreCase("a")){
         System.out.println("Enter factory name:");
         fact=scan.nextLine();
         System.out.println("Enter stop number:");
         stop=Integer.parseInt(scan.nextLine());
         System.out.println("Enter material:");
         mat=scan.nextLine();
         t.attach(fact, stop, mat);
         System.out.println("New car added.");
      }
      else if(option.equalsIgnoreCase("r")){
         System.out.print("Enter factory name to remove:");
         fact=scan.nextLine();
         t.detach(fact);
      }
      else if(option.equalsIgnoreCase("s")){
         System.out.print("Enter factory name to search:");
         fact=scan.nextLine();
         t.search(fact);
      }
      else if(option.equalsIgnoreCase("m")){
         t.merge("update.txt");
         t.displayTrainCars();
      }
      else if(option.equalsIgnoreCase("q")){
         System.out.println("\nGood Bye!!!");
         break;
      }
      else
         System.out.println("Invalid option!");
         System.out.println();
      }while(!option.equalsIgnoreCase("q"));
   }
   
   /**
   * Displays the menu with all the options.
   */
   private static void menu(){
      System.out.println("Option d: Display all car details\nOption a: Attach a car\nOption r: Detach car at factory\nOption s: Search a train car\nOption m: Merge two train cars\nOption q: Quit");  
   }
  
}