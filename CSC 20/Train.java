import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
*  A class that creates and manages a linked list of cars.
*
*  @author Youssef Boujebha
*  @date 11/14/21
*/
public class Train{
   private Car front;
   
   /**
   * Default constructor
   */
   public Train(){
      front = null;
   }
   
   /**
   * A constructor that reads the details of each train car from the file
   * into the linked list.
   *
   * @throws FileNotFoundException if it can't find the right file.
   */
   public Train(String carFile) throws FileNotFoundException{
      front = null;
      Scanner input = new Scanner(new File(carFile));
      String inline;
      while(input.hasNext()){
         inline = input.nextLine();
         String tokens[] = inline.split(",");
         attach(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
      }
   }
   
   /**
   * Removes a car with the given factoryName and deletes the
   * node from the LinkedList.
   */
   public void detach(String factoryName){
      if(front == null)
         return;
         
         Car current = front;
         Car previous = front;
         while(current != null){
            if(current.factory.equals(factoryName)){
               previous.next = current.next;
               current = current.next;
               continue;
            }
         previous = current;
         current = current.next;   
         }
      if(current != null){
         previous.next = current.next;
      }
   }
   
   /**
   * Adds a new car to the LinkedList.
   */
   public void attach(String factoryName, int stopNumber, String materialName){
        Car c = new Car(factoryName,stopNumber,materialName);
        if(front == null){
           front = c;
        }
        else{
        if(front.stop > c.stop){
           c.next = front;
           front = c;
        }
        else{
           Car current = front;
           Car previous = front;
           while(current.next != null){
              if(current.stop > c.stop){            
                 previous = current;
                 current = current.next;
                 break;
              }
              if(current.next == null){
                 current.next = c;
              }
              else{
                 previous.next = c;
                 c.next = current;   
              }
             }
           }
      }
   
   }
   
   /**
   * Searches for cars with a given factory name. Uses the List method as a
   * helper method.
   *
   * @param factoryName Used to find and sort the different cars.
   */
   public void search(String factoryName){
      Car current = front;
      List<String>matList=getCars(factoryName);
      if(matList.size() != 0){
         System.out.println("Materials in " + factoryName + ": ");
         for(String mat:matList)
         System.out.println(mat);     
      }
      else
      System.out.println("There is no car with factory name " + factoryName + " available in train");
   }
   
   /**
   *  Looks up the material name for each factory.
   */
   public List<String> getCars(String factoryName){
      List<String> materials = new ArrayList<String>();
      Car current = front;
      while(current != null){
         if(current.factory.equals(factoryName)){
            materials.add(current.material);
         }
         current = current.next;
   }
   return materials;
}
   /**
   * Displays the train cars in the sorted order.
   */
   public void displayTrainCars(){
      if(front == null){
         System.out.println("There is no car attached to train.");
         return;
      }
      Car current = front;
      boolean found = false;
      System.out.println("*================================================*");
      System.out.format("%1$-20s%2$-20s%3$-20s\n","Factory Name","Stop Number","nMaterial");
      while(current != null){
         System.out.format("%1$-20s%2$-20s%3$-20s\n",current.factory,current.stop,current.material);
         current = current.next;
      }
      System.out.println("*================================================*");
   }
   /**
   * Reads from "update.txt" and merges it with the new train car. It should
   * maintain the sorted order after the two LinkedLists are merged.
   *
   * @throws FileNotFoundException If the scanner can't find the right file.
   */
   public void merge(String update) throws FileNotFoundException{
      Scanner input = new Scanner(new File(update));
      String inline;
      while(input.hasNext()){
         inline = input.nextLine();
         String tokens[] = inline.split(",");
         attach(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
      }
   }
}