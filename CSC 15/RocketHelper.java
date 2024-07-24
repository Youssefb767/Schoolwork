/* Youssef Boujebha
   2/20/2021
   Chapter 1 assignment
   Helper file for the main rocket file*/
  
public class RocketHelper{

   public static void main(String[] args){ //Calls the finished output
      DrawFullRocket();
  }
   
   public static void DrawRocket(){ //Draws the first and second part of the rocket
      System.out.println("     /**\\");
      System.out.println("    //**\\\\");
      System.out.println("   ///**\\\\\\");
      System.out.println("  ////**\\\\\\\\");
      System.out.println(" /////**\\\\\\\\\\");
      System.out.println("+=*=*=*=*=*=*+");
      System.out.println("|../\\..../\\..|");
      System.out.println("|./\\/\\../\\/\\.|");
      System.out.println("|/\\/\\/\\/\\/\\/\\|");
      System.out.println("|\\/\\/\\/\\/\\/\\/|");
      System.out.println("|.\\/\\/..\\/\\/.|");
      System.out.println("|..\\/....\\/..|");
      System.out.println("+=*=*=*=*=*=*+");
      System.out.println("|../\\..../\\..|");
      System.out.println("|./\\/\\../\\/\\.|");
      System.out.println("|/\\/\\/\\/\\/\\/\\|");
      System.out.println("|\\/\\/\\/\\/\\/\\/|");
      System.out.println("|.\\/\\/..\\/\\/.|");
      System.out.println("|..\\/....\\/..|");
      System.out.println("+=*=*=*=*=*=*+");
  }
   
   public static void DrawEnd(){ //Draws the end of the rocket
      System.out.println("     /**\\");
      System.out.println("    //**\\\\");
      System.out.println("   ///**\\\\\\");
      System.out.println("  ////**\\\\\\\\");
      System.out.println(" /////**\\\\\\\\\\");
      System.out.println("+=*=*=*=*=*=*+");
      System.out.println("|../\\..../\\..|");
      System.out.println("|./\\/\\../\\/\\.|");
      System.out.println("|/\\/\\/\\/\\/\\/\\|");
      System.out.println("|\\/\\/\\/\\/\\/\\/|");
      System.out.println("|.\\/\\/..\\/\\/.|");
      System.out.println("|..\\/....\\/..|");
      System.out.println("+=*=*=*=*=*=*+");
      System.out.println("     /**\\");
      System.out.println("    //**\\\\");
      System.out.println("   ///**\\\\\\");
      System.out.println("  ////**\\\\\\\\");
      System.out.println(" /////**\\\\\\\\\\");
  }
   
   public static void DrawFullRocket(){ //Puts all the parts together and draws the full rocket
      DrawRocket();
      DrawRocket();
      DrawEnd();
  }

}