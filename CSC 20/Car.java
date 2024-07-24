import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
* The shell class for the cars in the train. Is used by the other classes to 
* make things easier.
*
* @author Youssef Boujebha
* @date 11/14/21
*/
class Car{
   public String factory;
   public int stop;
   public String material;
   Car next;
   
   /**
   * A default constructor.
   */
   public Car(){
   
   }
   
   /**
   * A constructor that sets next to null.
   */
   public Car(String fact, int s, String m){
      factory = fact;
      stop = s;
      material = m;
   }
   
   /**
   * A constructor that sets this.next to next.
   */
   public Car(String fact, int s, String m, Car next){
      factory = fact;
      material = m;
      stop = s;
      this.next = next;   
   }

}