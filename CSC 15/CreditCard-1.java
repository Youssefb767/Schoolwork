/* Youssef Boujebha
   4/27/2021
   Programming Assignment 6
   Credit card checker */
   
import java.util.Scanner;

public class CreditCard{

   public static void main (String[] args){
      Scanner kb = new Scanner(System.in);
      run(kb);
   }
   
    public static boolean LengthValidation(long cardNumber){ //Checks the length of the credit card number and makes sure is either 12 or 16
      int length=0;
      while (cardNumber > 0){
         cardNumber = cardNumber / 10;
         length++;
   }
        if (length == 13 || length == 16)
            return true;
        else
        return false;
   }
   
    public static boolean prefixDigitValidation(long cardNumber){ //Checks to see the starting number and makes sure that it's 4 
      while (cardNumber > 9)
        cardNumber = cardNumber / 10;
        if (cardNumber == 4)
         return true;
        else
         return false;
    }

    public static int sumOfOddPlaced(long cardNumber){ //Calculates the sum of the digits in the odds place
      int oddSum = 0;
         while (cardNumber > 0){
            long d = cardNumber % 10;
            oddSum += d;
            cardNumber = cardNumber / 100;
        }
        return oddSum;
    }
    
    public static int sumOfEvenPlaced(long number){ //Calculates the sum of the digits in the evens place
        int evenSum = 0;
        number = number / 10;
        while (number > 0){
            int d = (int)(number % 10);
            evenSum += sumOfDoubleDigit(2 * d);
            number = number / 100;
        }
        return evenSum;
    }

    public static int sumOfDoubleDigit(int number){ //Calculates the sum of two digits
        int sumDigits = 0;
        sumDigits += number / 10;
        sumDigits += number % 10;
        return sumDigits;
    }
    public static boolean isValid(long cardNumber){ //Uses the previous methods to determine whether or not a card number is valid
        boolean length = LengthValidation(cardNumber);
        boolean prefix = prefixDigitValidation(cardNumber);
        int oddSum = sumOfOddPlaced(cardNumber);
        int evenSum = sumOfEvenPlaced(cardNumber);
        int total = oddSum + evenSum;
        boolean div = total % 10 == 0;
        boolean result = length && prefix && div;
        return result;
    }
    
    public static void run (Scanner kb){ //Displays the text and asks if you want to keep going
        boolean valid;
        String s = "y";
        System.out.println("This program will determine if you");
        System.out.println("have entered a valid credit card number");
        while (s.equalsIgnoreCase("y")){
            System.out.print("Enter a credit card number: ");
            long number = kb.nextLong();
            valid = isValid(number);
            if (valid)
                System.out.println("This is a valid credit card number");
            else
                System.out.println("This is not a valid credit card number");
            System.out.print("Would you like to validate another credit card? y/n ");
            s = kb.next();
            if (s.equalsIgnoreCase("n"))
                System.out.print("Have a nice day!");
        }
        kb.close();
    }
    
}