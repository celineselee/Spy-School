/* Name: AnagramGame
 * Date: January 5 2016
 * Purpose: runs Spy game's anagram game
 * Author: Lee & Fajardo
 * Date modified: ---
*/

import javax.swing.JOptionPane;

public class AnagramGame {
  static String[] anagramWords = {"alert", "coast", "below", "crate", "drawer", 
                         "horse", "steal", "rinse", "saint", "steer", 
                         "kale", "enlist", "merit", "snail", "ring", "poodle", 
                         "space","hatred", "drawer", "used", "salesman", "burned", 
                         "despair", "early", "thing", "flow", "dad", "tablet" };
  
  
  /* Method: getWord
   * Purpose: retrieves an anagram word from array "anagramWords"
   * Post-condition: random word is outputted
   * @return: a random word
  */
  public static String getWord() {
    final int MAX = 28;
    final int MIN = 0;
    
    int ranNum = (int)(Math.random()*(MAX-MIN+1))+MIN;
    return anagramWords[ranNum];
  }//end getWord
  
  
  /* Method: checkAnagramAnswer
   * Purpose: sorts the computer's word and the user's word alphabetically then compares them
   * Pre-condition: the user inputs a String
   * Post-condition: returns true if the user's word equals the computer's word
   * @param: a String
   * @return: a boolean
  */
  public static int checkAnagramAnswer(String word, String userAnswer) {
    word = getWord();
    userAnswer = JOptionPane.showInputDialog(word);
    
    /* SORT computer's word */
    //store letters of computer's word in array
    char letters[] = new char[word.length()];
    for(int i=0; i<letters.length; i++)
      letters[i] = word.charAt(i);
    //insertion sort
    char value;
    for(int i=1; i<letters.length; i++) {
      value = letters[i];
      int j=i;
      while(j>0 && letters[j-1] > value) {
        letters[j] = letters[j-1];
        j--;
      }
      letters[j] = value;
    }//end for
    //store in String
    String sortedWord = "";
    for(char curr: letters)
      sortedWord = sortedWord + curr;
    
    /* SORT user's word */
    //store letters of user's word in array
    char userLetters[] = new char[userAnswer.length()];
    for(int i=0; i<userLetters.length; i++)
      userLetters[i] = userAnswer.charAt(i);
    //insertion sort
    char nextValue;
    for(int i=1; i<userLetters.length; i++) {
      value = userLetters[i];
      int j=i;
      while(j>0 && userLetters[j-1] > value) {
        userLetters[j] = userLetters[j-1];
        j--;
      }
      userLetters[j] = value;
    }//end for
    //store in String
    String sortedUserWord = "";
    for(char curr: userLetters)
      sortedUserWord = sortedUserWord + curr;
    
    
    //CHECK
    if(sortedUserWord.equalsIgnoreCase(sortedWord))
      return 1;
    else return 0;
  }//end checkAnagramAnswer
  
  
  
  
  
 
}//end class