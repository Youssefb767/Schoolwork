/**
* A subclass of MagicalCreature with a boolean attribute called shield.
*
* @author Youssef Boujebha
* @date 10/24/2021
*/
public class Elf extends MagicalCreature{
   public boolean shield;
   
   /**
   * A constructor that calls the parent class' constructor and initializes
   * the shield boolean to false.
   */
   public Elf(String name, String type, String color, int age){
      super(name,type,color,age);
      this.shield = false;
   }
   
   public Elf(){
      super("","","",0);
   }
   
   /**
   * Returns the MagicalCreature toString info.
   *
   * @return Prints "I eat leaves, I have a shield" OR "I eat leaves, I have no shield"
   * depending on whether or not the elf has a shield.
   */ 
   public String toString(){
      return (this.shield) ? "I eat leaves, I have a shield" : "I eat leaves, I have no shield";
   }
   
   /**
   * The setter for the shield attribute.
   */
   public void setShield(boolean shield){
      this.shield = shield;
   }

}