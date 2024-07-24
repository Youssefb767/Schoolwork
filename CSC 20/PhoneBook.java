import java.util.*;

/**
* Creates a phonebook with all the contacts. Used by the other phonebook classes to
* create the full working directory.
*
* @author Youssef Boujebha
* @date 12/5/21
*/
public class PhoneBook{
   public ArrayList<Contact> contacts;
   
   /**
   * A constuctor for the phonebook.
   */
   public PhoneBook(){
      this.contacts = new ArrayList<Contact>();
   }
  
   /** 
   * Adds contacts into the phonebook
   *
   * @param c Represents the contact being added
   */
   public void add(Contact c){
      this.contacts.add(c);
   }
   
   /** 
   * Returns a printable string with the entire contact list
   *
   * @return A printable list of all contacts
   */
   public String toString(){
      String returnString = "";
      returnString += String.format("%-10s%-15s%-15s%-20s%s\n","firstName", "lastName", "homeNumber", "officeNumber", "emailAddress");
      for (int i = 0; i< contacts.size(); i++) {
         returnString += contacts.get(i);
      }
      return returnString;
   }

   /** 
   * Sorts the phonebook by first names
   */
   public void bubbleSort(){
      int n = this.contacts.size();
      for (int i = 0; i < n-1; i++){
         for (int j = 0; j < n-i-1; j++){
            if (this.contacts.get(j).getFirstName().compareTo(this.contacts.get(j+1).getFirstName()) > 0){
               Contact temp = this.contacts.get(j);
               this.contacts.set(j, this.contacts.get(j+1));
               this.contacts.set(j+1, temp);
            }
         }
      }
   }

   /** 
   *Sorts the last names
   */
   public void selectionSort(){
      int n = this.contacts.size();
      for (int i = 0; i < n-1; i++){
         int min =i;
         for(int j = i+1; j < n;j++)
            if (this.contacts.get(j).getLastName().compareTo(this.contacts.get(min).getLastName()) < 0){
               min = j;
            }  
         Contact temp = this.contacts.get(min);
         this.contacts.set(min, this.contacts.get(i));
         this.contacts.set(i, temp);
         }
      }

   /** 
   * Sort phone book using binary search
   *
   * @return true Only if the contact is found
   */
   public boolean binarySearch(String name){
      int lowIndex = 0;
      this.selectionSort();
      int highIndex = this.contacts.size();
      int middleIndex = (lowIndex + highIndex)/2;
      while (lowIndex <= highIndex) {
         middleIndex = (lowIndex + highIndex)/2;
         if(this.contacts.get(middleIndex).getLastName().equals(name)){
            return true;
         }else if (this.contacts.get(middleIndex).getLastName().compareTo(name) < 0){
            lowIndex = middleIndex + 1;
         }else if(this.contacts.get(middleIndex).getLastName().compareTo(name) > 0){
            highIndex = middleIndex - 1;
         }
      }
   return false;
   }

}