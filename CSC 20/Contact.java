/**
* This class creates individual contacts using constructor alongside getters and setters
* for the first name, last name, number, etc.
*
* @author Youssef Boujebha
* @date 12/5/21
*/
public class Contact{
   public String firstName;
   public String lastName;
   public long homeNumber;
   public long officeNumber;
   public String emailAddress;

   /** 
   * The constructor for the contacts
   *
   * @param firstName the first name
   * @param lastName the last name
   * @param homeNumber the home number
   * @param officeNumber the office number
   * @param emailAddress the email address 
   */
   public Contact(String firstName, String lastName, long homeNumber, long officeNumber, String emailAddress){
      this.firstName = firstName;
      this.lastName = lastName;
      this.officeNumber = officeNumber;
      this.emailAddress = emailAddress;
      this.homeNumber = homeNumber;
   }

   /**
   * The getter for the first name
   * @return the first name
   */
   public String getFirstName(){
      return this.firstName;
   }

   /** 
   * The getter for the last name
   * @return the last name 
   */
   public String getLastName(){
      return this.lastName;
   }

   /** 
   * The getter for the home number
   * @return the home number
   */
   public long getHomeNumber(){
      return this.homeNumber;
   }

   /** 
   * The getter for the office number
   * @return the office number 
   */
   public long getOfficeNumber(){
      return this.officeNumber;
   }

   /**
   * The getter for the email address
   * @return the email address 
   */
   public String getEmailAddress(){
      return this.emailAddress;
   }


   /**
   * The setter for the first name
   * @param firstName first Name
   */
   public void setFirstName(String firstName){
      this.firstName = firstName;
   }

   /**
   * The setter for the last name
   * @param lastName last Name
   */
   public void setLastName(String lastName){
      this.lastName = lastName;
   }
   
   /**
   * The setter for the email address
   * @param emailAddress the email address
   */
   public void setEmailAddress(String emailAddress){
      this.emailAddress = emailAddress;
   }
   
   /**
   * The setter for the home number
   * @param homeNumber the home number
   */
   public void setHomeNumber(long homeNumber){
      this.homeNumber = homeNumber;
   }

   /**
   * The setter for the office number
   * @param officeNumber the office number
   */
   public void setOfficeNumber(long officeNumber){
      this.officeNumber = officeNumber;
   }

   /**
   * Returns the contact as a string and prints it
   */
   public String toString(){
      String home;
      String work;
         if(this.homeNumber == 0){
         home = "-";
      }else{
         home = Long.toString(this.homeNumber);
      }
      if (this.officeNumber == 0){
         work = "-";
      }else{
         work = Long.toString(this.officeNumber);
      }
      return String.format("%-10s%-15s%-15s%-20s%s\n", this.firstName, this.lastName,home, work,this.emailAddress);
   }
   
}