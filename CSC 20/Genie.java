/**
 * A subclass of MagicalCreature with a boolean attribute called "wand".
 *
 * @author Youssef Boujebha
 * @date 10/24/21
*/
public class Genie extends MagicalCreature{
   public boolean wand;

   /**
   * A constructor that calls the parent class' constructor.
   * The wand attribute is initialized to false.
   */
   public Genie(String name, String type, String color, int age){
      super(name,type,color,age);
      this.wand = false;
   }
   
   public Genie(){
      super("","","",0);
      this.wand = false;
   }
   
   /**
   * Returns the MagicalCreature toString info.
   *
   * @return Returns "I eat leaves, I have a wand" OR "I eat leaves, I have no wand", depending on 
   * whether or not the wand attribute is true or false.
   */
   public String toString(){
      return (this.wand) ? "I eat leaves, I have a wand" : "I eat leaves, I have no wand";
   }
   
   /**
   * Setter for the wand attribute.
   */
   public void setWand(boolean wand){
      this.wand = wand;
   }
   
   /**
   * Setter for the wand attribute.
   */
   public boolean getWand(){
      return this.wand;
   }
   
   /**
   * Overrides the MagicalCreature method.
   * Causes the other creature to die if the genie has a wand.
   *
   * @param other Represents the genie's opponent
   * @return Prints "I cannot kill without my wand!" if the genie doesn't have a wand
   */
   public void kill(MagicalCreature other){
      if (this == other){
         System.out.println("I cannot kill myself");
      } else {
         boolean elim = (this.getWand()) ? true : false;
         if(elim){
            other.die();
            System.out.println(other.name + " Has been killed!");
         } else{
               System.out.println("I cannot kill without my wand!");
               }
         }
   }
}