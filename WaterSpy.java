/* Author: Celine Lee & Kristen Fajardo
 * Date created: Jan 6 2016
 * Date last updated: Jan 18 2016
 * Purpose: to create a WaterSpy
 */
public class WaterSpy extends Spy{
  private int waterPoints;
  
  public WaterSpy(String name){
    super(name);
    waterPoints = 0;
  }//end constructor
  
  /* method: getHint
   * @param: the secret word
   * purpose: reveals a vowel from the secret password
   * postcondition: returns a char */
  public char getHint(String word, int hintNumber){
    char[] vowels = {'a', 'i', 'e', 'o', 'u'};
    char[] hints = new char[word.length()];
    int hintIndex = 0; 
    for(int i=0; i<word.length(); i++){
      for(int j=0; j<vowels.length; j++){
        if(word.charAt(i)==vowels[j]){
          hints[hintIndex] = word.charAt(i);
          hintIndex++;
        }//end if
      }//end for
    }//end for
    return hints[hintNumber];
  }//end getHint
  
  /* method: getSpyType
   * purpose: returns a number to represent type of spy
   * postcondition: returns 2 */
  public int getSpyType(){
    return 2;
  }//end getSpyType 
  
  
  /* method: addSpecialPoints
   * purpose: adds specialty points (waterPoints since it is a WaterSpy)
   * @param: int sPoints
   * precondition: sPoints>=0
   */
  public void addSpecialPoints(int sPoints){
    waterPoints = waterPoints + sPoints;
  }//end addSpecialPoints
  
  /* method: getSpecialPoints
   * purpose: retreives specialty points (waterPoints)
   * postcondition: returns how many special points player has 
   */
  public int getSpecialPoints(){
    return waterPoints; 
  }//end getSpecialPoints
  
  
  
}//end class