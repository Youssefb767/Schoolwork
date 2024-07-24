/**
* A subclass of MagicalCreature with no attributes.
*
* @author Youssef Boujebha
* @date 10/24/21
*/
public class Dragon extends MagicalCreature{

   /**
   * A constructor that calls calls the constructor of the parent class.
   */
   public Dragon(String name, String type, String color, int age){
      super(name,type,color,age);   
   }
   
   public Dragon(){
      super("","","",0);
   }
   
   /**
   * Returns the MagicalCreatures toString info.
   * @return "I breathe fire!".
   */
   public String toString(){
      return "I breathe fire!";
   } 
   
   /**
   * Overrides the magical creature method.
   * @return Prints "I am a dragon - nobody gets to kill me!".
   */
   public void die(){
      System.out.println("I am a dragon - nobody gets to kill me!");
   }
   
   /**
   * Overrides the MagicalCreature method. Prints "I am too young to kill"
   * if the age is < 40. Otherwise, if its another dragon, the younger dragon dies.
   *
   * @param other Other is used to compare the first dragon to the other magical creature.
   */
   public void kill(MagicalCreature other){
      if(this == other){
         System.out.println("I cannot kill myself");
      } else {
         if (other.type.equals("Dragon")){
            System.out.println("Dragons cannot die!");
         } else{
            if(this.age >= 40){
               other.die();
               System.out.println(other.name + " Has been killed!");
            } else {
               System.out.println("I am too young to kill !");
               }
            }          
         }
   }
}