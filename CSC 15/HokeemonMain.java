/* Youssef Boujebha
   5/13/2021
   Programming Assignment 7/8
   Hokeemon main class */
   
import java.util.Arrays;

public class HokeemonMain{
   public static void main(String[] args){ //uses the helper class and the file to print the info for each of the hokeemon
      Hokeemon[] hokeemons = Hokeemon.getData("data.txt");
      System.out.println(Arrays.toString(hokeemons));
      System.out.println(Hokeemon.getBio(hokeemons));   
   }
}