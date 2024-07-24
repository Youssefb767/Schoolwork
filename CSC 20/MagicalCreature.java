import java.util.*;
/**
* A class that is extended by the other creature classes. It's used to define the
* name, type, color, and age of the rest of the creature classes.
*
* @author Youssef Boujebha
* @date 10/24/21
*/
public class MagicalCreature{
   public String name;
   public String type;
   public String color;
   public int age;
   public boolean alive;
   
   /**
   * A constructor that sets the attribute values as recieved in the parameters.
   */ 
   public MagicalCreature(String name, String type, String color, int age){
      this.name = name;
      this.type = type;
      this.color = color;
      this.age= age;
      this.alive = true;
   }
   
   /**
   * Getter for the alive attribute.
   */   
   public boolean getAlive(){
      return alive;
   }
   
   /**
   * Setter for the alive attribute. A creature is dead if alive is false.
   */
   public void setAlive(boolean alive){
      this.alive = alive;
   }
   
   /**
   * Getter for the name attribute.
   */
   public String getName(){
      return name;
   }
   
   /**
   * Setter for the name attribute.
   */
   public void setName(String name){
      this.name = name;
   }
   
   /**
   * Getter for the type attribute.
   */
   public String getType(){
      return type;
   }
   
   /**
   * Setter for the type attribute.
   */
   public void setType(String type){
      this.type = type;
   }
   
   /**
   * Getter for the color attribute.
   */
   public String getColor(){
      return color;
   }
   
   /**
   * Setter for the color attribute.
   */
   public void setColor(String color){
      this.color = color;
   }
   
   /**
   * Getter for the age attribute.
   */
   public int getAge(){
      return age;
   }
   
   /**
   * Setter for the age attribute.
   */
   public void setAge(int age){
      this.age = age;
   }
   
   /**
   * Prints the string "I do not have the license to kill."
   */
   public void kill(MagicalCreature other){
      System.out.println("I do not have the license to kill.");
   }
   
   /**
   * Sets the alive attribute to false which causes the creature to die.
   */
   public void die(){
      this.alive = false;
   }
   
   /**
   * Prints a string with a creatures given attributes
   *
   * @return Returns a string that says the creatures name, color, type, and age by using the setters and getters in the class.
   */
   public String toString(){
      return "My name is " + this.name + " I am a " + this.color + " " + this.type + " I am " + this.age + " years old";
   }
   
}