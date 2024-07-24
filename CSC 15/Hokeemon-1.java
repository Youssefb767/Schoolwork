/* Youssef Boujebha
   5/12/2021
   Programming Assignment 7/8
   Hokemon Helper class */
  
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hokeemon{

   private String name;
   private String type;
   private int age;

   public Hokeemon(String name, String type, int age){ 
       this.name = name;
       this.type = type;
       this.age = age;
   }

   public Hokeemon(){ //Default constuctor
       this.name = "";
       this.type = "";
       this.age = 0;
   }
      //These methods are the setters and getters for the program
   public String getName(){
       return name;
   }

   public void setName(String name){
       this.name = name;
   }

   public String getType(){
       return type;
   }

   public void setType(String type){
       this.type = type;
   }
   
   public void setAge(int age){
       this.age = age;
   }
   
   public int getAge(){
       return age;
   }

   

   public String liveIn(){ //Sets where each type of Hokeemon live
       if (this.type.equalsIgnoreCase("dwarf")){
           return "Mountain";
       } else if (this.type.equalsIgnoreCase("elf")){
           return "Dale";
       } else if (this.type.equalsIgnoreCase("fairy")){
           return "Forest";
       } else {
           return "Shire";
       }
   }

   public boolean areFriends(Hokeemon other){ //Says which Hokeemon are friends with eachother
       if (this.type.equalsIgnoreCase(other.type)){
           return true;
       } else if ((this.type.equalsIgnoreCase("dwarf") && other.type.equalsIgnoreCase("elf"))
               || (this.type.equalsIgnoreCase("elf") && other.type.equalsIgnoreCase("dwarf"))) {
           return true;
       } else if ((this.type.equalsIgnoreCase("hobbit") && other.type.equalsIgnoreCase("fairy"))
               || (this.type.equalsIgnoreCase("fairy") && other.type.equalsIgnoreCase("hobbit"))) {
           return true;
       } else{
           return false;
       }

   }

   public static Hokeemon[] getData(String file){ //Creates the array
       Hokeemon[] hokeemons = new Hokeemon[8];
       int i = 0;
       try{
           Scanner scan = new Scanner(new File(file)); //Uses the data from the "Data.txt" file
           while (scan.hasNextLine() && i < hokeemons.length){
               String line = scan.nextLine();
               String[] data = line.split("\\s+");
               String name = data[0];
               String type = data[1];
               int age = Integer.parseInt(data[2]);
               hokeemons[i] = new Hokeemon(name, type, age);
               i++;
           }
           scan.close();
       } catch (FileNotFoundException e){
           System.err.println(e);
       }
       return hokeemons;
   }

   public static String getBio(Hokeemon[] hokeemons){ //Prints the bio of each of the Hokeemon
       String s = "";
       for (Hokeemon hokeemon : hokeemons){
           s += "I am " + hokeemon.getName() + ": Type " + hokeemon.getType() + ": Age=" + hokeemon.getAge()
                   + ", I live in " + hokeemon.liveIn() + "\n";
           s += "My friends are: ";
           for (Hokeemon hokeemon2 : hokeemons){
               if (hokeemon.areFriends(hokeemon2) && !hokeemon.equals(hokeemon2)) {
                   s += (hokeemon2.getName() + " ");

               }
           }
           s += "\n";
       }
       return s;
   }
   @Override
   
   public String toString(){ //The string used for each of the hokeemons name, type and age
       return "Name " + name + ": Type " + type + ": Age=" + age + "\n";
   }

}

