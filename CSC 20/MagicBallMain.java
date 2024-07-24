/* Youssef Boujebha
   MagicBallMain
   9/12/21 */

class MagicBallMain{

  public static final int SIZE = 20;

  public static void main(String[] args){
     int numberOfAnswers;
       String[] answers = new String[10];
       numberOfAnswers = MagicBallHelper.readAnswers(answers); //gets the answer by calling the answer method
       MagicBallHelper.playGame(numberOfAnswers, answers); //Calls the playGame method
  }
}