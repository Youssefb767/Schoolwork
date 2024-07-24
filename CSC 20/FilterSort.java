/* Youssef Boujebha
   CSC 20
   9/18/2021
   FilterSort */
   
import java.io.*;
import java.util.*;

public class FilterSort{

   public static int[] doubleArrayAndCopy(int[] arr){ //Reads tokens from file and puts them into an array
      int new_arr[] = new int[arr.length*2];
      for(int i=0; i<arr.length; i++){
         new_arr[i] = arr[i];
   }
return new_arr;
  }

public static void main(String[] args){
   int[] data = new int[8];
   try{
      Scanner in = new Scanner(new File("data.txt")); //Searches for a file named data.txt
      String temp;
      int n=0;
   while(in.hasNext()){ //Keeps going until theres no more text in the file and checks if it's an integer or not
      if(in.hasNextInt()){
         if(n<data.length)
            data = doubleArrayAndCopy(data); //Doubles the array size so the data can fit if there is too much for the regular array size
            data[n] = in.nextInt();
      n++;
   }
   else{
      temp = in.next();
      }
   }

   Arrays.sort(data, 0, n);
   for(int i=0; i<n; i++){
      System.out.println(data[i]); //prints the data from the file until it runs out of data
   }
   
   }catch(FileNotFoundException e){
      System.out.println("File not found"); //Prints if it can't find the file
   }

  }

}