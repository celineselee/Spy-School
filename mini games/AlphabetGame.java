/* Name: AlphabetGame
 * Date: January 10 2016
 * Purpose: runs Spy game's Alphabet mini game
 * Author: Lee & Fajardo
 * Date modified: ---
 */

import javax.swing.JOptionPane;

public class AlphabetGame{
  
  /*LIST OF WORDS*/
  //LAND WORDS
  static String[] landWords = {"desert", "earth", "rock", "mountain", "cave","jungle", "mineral", "hike", "dry",
    "climb", "flower", "tree", "dirt",
    "weed", "soil", "grass", "roots",
    "leaves", "stone", "road", "hard",
    "concrete", "solid", "pavement", "mud", "wind" }; // end landWords array
  
  //WATER WORDS
  static String[] waterWords = {"creek", "cove", "ocean", "fish", "algae","shark", "sea", "wave", "lake",
    "river", "pond", "snorkle", "dive",
    "swim", "gulf", "dolphin", "wet",
    "coral", "reef", "kelp", "oyster",
    "anemone", "pyrosome", "marine", "jellyfish", "urchin" };//end waterWords array
  
  /* Method: getLandWords
   * will retreive random land word from array "landWords"
   * Post-condition: random word will be outputted
   * @return: a random word
   * */ 
  public static String getLandWords(){
    final int MAX = landWords.length;
    final int MIN = 0;
    int randomNum = (int)(Math.random()*(MAX-MIN+1))+MIN;
    return landWords[randomNum];
  }//end getWords method
  
  /* Method: getWaterWords
   * will retrieve random water word from array "waterWords"
   * Post-condition: random word will be outputted
   * @return a random word
   */
  public static String getWaterWords() {
    final int MAX = waterWords.length;
    final int MIN = 0;
    int randomNum = (int)(Math.random()*(MAX-MIN+1))+MIN;
    return waterWords[randomNum];
  }
  
  
  /* Method: playAlphabet
   * @param: int spyType
   * @return: points
   * Purpose: Organizes the Alphabet game, calculates and returns points
   * Pre-condition: int spyType == 1 or spyType == 2
   * Post-condition: # of points player wins during the game
   */
  public int playAlphabet(int spyType) {
    
    long start = System.currentTimeMillis();
    int points = 0;
    
    for(int i=0; i<5 ; i++){
      /*get word for LAND spies*/
      if(spyType==1) {
        String word = getLandWords();
        
        String userWord = JOptionPane.showInputDialog(word);
        
        //first letter of the user's word
        String userLetter = userWord.substring(0, 1);
        
        //first letter of outputted word
        String wordLetter = word.substring(0, 1);
        
        //first letter of user's word must equal outputted word
        if(userLetter.compareTo(wordLetter)==1)
          points+=1;
        else points += 0; 
        
      }
      /*get word for WATER spies*/
      else if (spyType==2) {
        String word=getWaterWords();
        String userWord = JOptionPane.showInputDialog(word);
        //first letter of user's word
        String userLetter = userWord.substring(0, 1);
        
        //first letter of outputted word
        String wordLetter = word.substring(0, 1);
        
        //first letter of userLetter must equal wordLetter
        if(userLetter.compareTo(wordLetter)==1)
          points+=1;
      }
    }//end forward for 
    
    JOptionPane.showMessageDialog(null, "REVERSE!!");
    
    for(int i=0; i<8; i++){
    //REVERSE
      /*get word for LAND spies*/
      if(spyType==1) {
        String word=getLandWords();
        String userWord = JOptionPane.showInputDialog(word);    
        //first letter of user's word
        String userLetter = userWord.substring(0, 1);
        
        //first letter of outputted word
        String wordLetter = word.substring(0, 1);
        
        //first letter of userLetter must equal wordLetter
        if(userLetter.compareTo(wordLetter)== -1)
          points+=1;
        else points += 0; 
      }
      /*get word for WATER spies*/
      else if(spyType==2) {
        String word=getWaterWords();
        String userWord = JOptionPane.showInputDialog(word);
        //first letter of user's word
        String userLetter = userWord.substring(0, 1);
        
        //first letter of outputted word
        String wordLetter = word.substring(0, 1);
        
        //first letter of userLetter must equal wordLetter
        if(userLetter.compareTo(wordLetter)== -1)
          points+=1;
        else points += 0; 
      }
    }//end reverse for
    long difference = System.currentTimeMillis() - start;
    long time = difference/1000;
    
    if(time<20) points += 3;
    
    return points;
    
    
  }//end playAlphabet
  
}//end class