import java.io.*;
import java.util.*;

/**
* This is the driver class for the phonebook program. It creates the phonebook,
* reads from it, sorts the contents, and lets the user search through it.
*
* @author Youssef Boujebha
* @date 12/5/21
*/ 
public class PhoneDriver{
   public static void main(String[] args) throws FileNotFoundException{
      String dataFile = "ContactDetails.txt";
      PhoneBook phoneBook = new PhoneBook();
      File file = new File(dataFile);
      Scanner scanner = new Scanner(file);
      String inline;
      String firstName; String lastName; long homeNumber; long officeNumber; String emailAddress;
      while(scanner.hasNextLine()){
         try{
            inline = scanner.nextLine();
            String tokens[] = inline.split(",");
            firstName = tokens[0];
            lastName = tokens[1];
            if (tokens[2].equals("-")){
               homeNumber =0;
            }else{
               homeNumber = Long.parseLong(tokens[2]);
            }
         if (tokens[3].equals("-")){
            officeNumber = 0;
         }else{
            officeNumber =Long.parseLong(tokens[3]);
         }
      emailAddress = tokens[4];
      Contact newContact = new Contact(firstName, lastName, homeNumber, officeNumber, emailAddress); // Creates the contact objects and adds them to the phonebook array list
      phoneBook.add(newContact);
      }catch(Exception E){
         E.printStackTrace();
         println("Could not parse contact");
         }
      }
      phoneBookMenu(phoneBook);
   }

   /**
   * This method is used to create the main menu of the phonebook. It lists the different options
   * and lets the user select which one they want using a scanner.
   *
   * @param phoneBook This represents the phonebook
   */
   public static void phoneBookMenu(PhoneBook phoneBook){
      boolean quit = false;
      Scanner input = new Scanner(System.in);
      while (quit != true){ // The different options for the phonebook
         println("\nPhone Book Menu Options");
         println("A. Print Phonebook");
         println("B. Sort phone book by first name");
         println("C. Sort phone book by last name");
         println("D. Search contact by last name");
         println("Q. to Quit");
         String option = input.nextLine().toLowerCase();
         switch(option){
            case "a":
            print(phoneBook.toString());
            break;
            case "b":
            phoneBook.bubbleSort();
            break;
            case "c":
            phoneBook.selectionSort();
            break;
            case "d":
            print("Enter the last name to search: ");
            boolean found = phoneBook.binarySearch(input());
            if (found){
               println("Contact found");
            }else{
               println("Contact not found");
            }
         break;
         case "q":
         println("Good Bye!");
         quit = true;
         return;
         default:
         println("Invalid option, try again.");
         }
      }
   }

   /**
   *This process makes the println process easier
   *
   * @param input The string that gets printed
   */
   public static void println(String input){
      System.out.println(input);
   }
   
   /**
   * This method makes the input process easier
   *
   * @return The input of the string
   */
   public static String input(){
       Scanner input = new Scanner(System.in);
       return input.nextLine();
   }
   
   /**
   * This process makes the println process easier
   */
   public static void println(){
      System.out.println("");
   }
   
   /**
   * This method makes the print process easier
   *
   * @param input Prints the input string
   */
   public static void print(String input){
      System.out.print(input);
   }
   
}