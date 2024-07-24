/**
* A subclass of MagicalCreature with no special attributes.
*
* @author Youssef Boujebha
* @date 10/24/21
*/ 
public class Goblin extends MagicalCreature{
   
   /**
   * Constructor that calls the parent class' constructor.
   */ 
   public Goblin(String name, String type, String color, int age){
      super(name,type,color,age);   
   }
   
   public Goblin(){
      super("","","",0);
   }
   
   /**
   * Returns the MagicalCreatures.
   *
   * @return "I kill elves if they do not have shields".
   */
   public String toString(){
      return "I kill elves if they do not have shields";
   }
}