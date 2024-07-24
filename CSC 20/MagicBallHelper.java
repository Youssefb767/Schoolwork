/* Youssef Boujebha
   CSC 20 Magic Ball Helper
   9/10/21 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class MagicBallHelper{
 
   public static int readAnswers(String[] answers){ //Method that reads the text file
       int numberOfAnswers = 0;    
       String fileName = "answers.txt"; 
           try{ // Catches exceptions         
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
           String line;
               while((line = br.readLine()) != null){ // Runs a while loop that goes until the last line of the file               
                  answers[numberOfAnswers] = line;
                  numberOfAnswers++;
           }
           fr.close();
           br.close();
       }
           catch (Exception e){ //Displays error message
           System.out.println("Error in reading the file.");
       }
       return numberOfAnswers;
   }

   
   public static void playGame(int numberOfAnswers, String[] answers){ // Method that takes number of answers and answers as parameters
       String question;
       boolean repeat = true;
       Scanner input = new Scanner(System.in);
       System.out.print("Enter your question (or just hit enter to exit): "); //Prompt for questions
       question = input.nextLine();
       while(repeat){ //Runs while it's true
              if((question.equals(null) || question.equals("")))
               repeat = false;          
           else{ //Plays game while true
               Random r = new Random();
               int randomNumber = r.nextInt(numberOfAnswers - 1); //Generates random number
               System.out.println("Answer: " + answers[randomNumber]); //Displays answer 
               System.out.print("\nEnter your question (or just hit enter to exit): ");//Asks for another question
               question = input.nextLine();
           }
       }
       System.out.println("\nGoodbye!");
       input.close();
   }
}