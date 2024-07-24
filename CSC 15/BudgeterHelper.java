/* Youssef Boujebha
   3/30/2021
   Programming assignment 4
   Budgeter helper class */
   
import java.util.Scanner; 
public class BudgeterHelper{ 

   public static void main(String[] args){ // The main method that runs the program
      FinalBudgeter(); 
  }

   public static void OpeningMessage(){ // Displays the message that appears at the start of the program
      System.out.println("This program asks for your monthly income and\n" +"expenses, then tells you your net monthly income.");
  }

   private static double GetTotalIncome(Scanner sc){ // Asks for and remembers how many categories of income someone has
      int Categories;
      double Sum=0;
      System.out.print("How many Categories of income? ");
      Categories=sc.nextInt();
      for(int i=0;i<Categories;i++){
         System.out.print("Next income amount? $");
         Sum+=sc.nextDouble();
      }
      return Sum;
  }

   public static double GetTotalExpense(Scanner sc){ // Asks for total expenses and gives the sum of them
      int Choice;
      int Categories;
      double Sum=0;
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      Choice=sc.nextInt();
      if(Choice==1){
         System.out.print("How many Categories of expense? ");
         Categories=sc.nextInt();
      for(int i=0;i<Categories;i++){
         System.out.print("Next expense amount? $");
         Sum+=sc.nextDouble();
  }
  }
   if(Choice==2){
      System.out.print("How many Categories of expense? ");
      Categories=sc.nextInt();
      for(int i=0;i<Categories;i++){
         System.out.print("Next expense amount? $");
         Sum+=sc.nextDouble();
  }
   Sum*=31;
  }
   return Sum;
  }
  
   public static void PrintSavings(double TotalIncome, double TotalExpense){ // Displays the total income and checks to see how much you've saved
      double Difference=TotalIncome-TotalExpense;
      System.out.printf("Total income = $%.2f ($%.2f/day)%n",TotalIncome,(TotalIncome/31));
      System.out.printf("Total expenses = $%.2f ($%.2f/day)%n",TotalExpense,(TotalExpense/31));
      if(Difference>0){
         System.out.printf("You earned $%.2f more than you spent this month.%n",Difference);
      if(Difference>250)
         System.out.println("You're a big saver.");
      else
         System.out.println("You're a saver.");
  }
   else{
      System.out.printf("You spent $%.2f more than you earned this month.%n",(Difference*-1));
   if(Difference>=-250 && Difference<0)
      System.out.println("You're a spender");
   else
      System.out.println("You're a big spender");
  }
  
}
   public static void FinalBudgeter(){ // Wraps all the previous methods into one single method and sets the
      double TotalIncome,TotalExpense;
      Scanner sc=new Scanner(System.in);
      OpeningMessage();
      TotalIncome=GetTotalIncome(sc);
      TotalExpense=GetTotalExpense(sc);
      PrintSavings(TotalIncome,TotalExpense);
  }
  
}
   