/* Author: Celine Lee & Kristen Fajardo
 * Date created: Jan 6 2016
 * Date last updated: Jan 18 2016
 * Purpose: to create a Land Spy
 */
public class LandSpy extends Spy{
  private int landPoints;
  
  public LandSpy(String name){
    super(name);
    landPoints = 0;
  }//end constructor
  
  /* method: getHint
   * @param: the secret word
   * purpose: reveals a consonant from the secret password
   * postcondition: returns a char */
  public char getHint(String word, int hintNumber){
    
    char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    char[] hints = new char[word.length()];
   
    int hintIndex = 0; 
    for(int i=0; i<word.length(); i++){
      for(int j=0; j<consonants.length; j++){
        if(word.charAt(i)==consonants[j]){
          hints[hintIndex] = word.charAt(i);
          hintIndex++;
        }//end if
      }//end for
    }//end for
    return hints[hintNumber];
  }//end getHint
  
  /* method: getSpyType
   * purpose: returns a number to represent type of spy
   * postcondition: returns 1 */
  public int getSpyType(){
    return 1;
  }//end getSpyType 
  
    /* method: addSpecialPoints
   * purpose: adds specialty points (landPoints or waterPoints)
   * @param: int sPoints
   * precondition: sPoints>=0
   */
  public void addSpecialPoints(int sPoints){
    landPoints = landPoints + sPoints;
  }//end addSpecialPoints;
  
  
  /* method: getSpecialPoints
   * purpose: retreives specialty points (landPoints or waterPoints)
   * postcondition: returns how many special points player has 
   */
  public int getSpecialPoints(){
    return landPoints;
  }//end getSpecialPoints
  
  
}//end class