import java.util.*;
/**
* This program keeps track of an inventory of letters in the alphabet by
* taking a string and computing how many of each letter are in that string.
* (1 H, 1 E, 2 L, 1 O, etc.)
*
* @author Youssef Boujebha
* @version 10/09/21
*/
public class LetterInventory{
   public static final int alphabet = 26;
   private int size;
   private int[] elementData;
   
   /**
   * Makes an inventory for the letters in a word, counts how many
   * times each letter was in the word, and stores them in the inventory.
   *
   * @param data is used as the string and keeps track of the length of the string
   */ 
   public LetterInventory(String data){
      elementData = new int[alphabet];
      data = data.toLowerCase();
      for(int i = 0; i < data.length(); i++){
         if( Character.isLetter(data.charAt(i))){
            elementData[data.charAt(i) - 'a']++;
            size++;
         }
      }    
   }
   
   /**
   * Checks if each character is a letter of the alphabet
   *
   * @param letter used to check if the character is a letter
   * @throws IllegalArgumentException if the character is not a letter
   * @return The inventory count
   */
   public int get(char letter){
     if(!Character.isLetter(letter)){
        throw new IllegalArgumentException();
     }
      letter = Character.toLowerCase(letter);
      return elementData[letter - 'a'];     
   }     
   /**
   * The size of the inventory
   *
   * @return Size of inventory
   */
   public int size(){
      return size;
   }
   
   /**
   * Checks to see if the inventory is empty
   *
   * @return True if empty, false if not
   */
   public boolean isEmpty(){
      return size == 0;
      
   }
   
   /**
   * Returns a string representation of the inventory with the letters being
   * lowercase, ordered, and surrounded by square brackets.
   *
   * @return Sorted inventory
   */
   public String toString(){
      String result = "[";
      for(int i = 0; i < alphabet; i++){
         for(int j = 0; j < elementData[1]; j++){
            result += (char) (i +'a');
         }
      }
      return result + "]";
   }
   
   /**
   * Constructs and returns a new LetterInventory object that represents the sum of this
   * LetterInventory and the other LetterInventory, adding the letter count of each object together.
   *
   * @param other the new LetterInventory object
   * @return Returns the combined sum of characters between the new and other LetterInventory objects
   */
   public LetterInventory add(LetterInventory other){
      LetterInventory total = new LetterInventory("");
      for(int i = 0; i < alphabet; i++){
         char cha = (char) ('a' + i);
         int value = elementData[i] - other.get(cha);
         total.set(cha,value);
      }
      return total;
   }
   
   /**
   * Constructs and returns a new LetterInventory object that represents the result
   * of subtracting the other from this inventory
   *
   * @return null If the resulting number is negative
   */
   public LetterInventory subtract(LetterInventory other){
      LetterInventory diff = new LetterInventory("");
      for(int i = 0; i < alphabet; i++){
         char cha = (char) ('a' + i);
         int value = elementData[i] - other.get(cha);
         if( value < 0){
            return null;
         }
        diff.set(cha, value);
      }
      return diff;
   }
   /**
   * Sets the value of the inventory and makes sure the value isn't too low
   *
   * @param value The amount of letters in the inventory
   * @throws IllegalArgumentException if the value is < 0
   */
   public void set(char letter, int value){
      if(!Character.isLetter(letter) || value < 0){
         throw new IllegalArgumentException();
      }
     letter = Character.toLowerCase(letter);
      size -= elementData[letter - 'a'] = value;
      size += value;
   }
   
}