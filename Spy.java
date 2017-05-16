/* Author: Celine Lee & Kristen Fajardo
 * Date created: Jan 6 2016
 * Date last updated: Jan 18 2016
 * Purpose: to create a super Spy class for LandSpy and WaterSpy to inherit from
 */
public abstract class Spy{
  private String name;
  private int points; 
  
  //Spy constructor
  public Spy(String name){
    this.name=name;
    points = 0;
  }//end constructor
  
  /* method: addPoints
   * purpose: to add points to Spy objects
   * @param: int add
   * precondition: add>=0 */
  public void addPoints(int point){
    points = points + point; 
  }//end addPoints
  
  /* method: getPoints
   * purpose: to retreive the number of points
   * postcondition: number of points */
  public int getPoints(){
    return points; 
  }//end getPoints
  
  /* method: getName
   * purpose: to retreive Spy's name
   * postcondition: String of spy's name */
  public String getName(){
    return name;
  }//end getName()
  
  /* method: getHint
   * purpose: to get a hint 
   * postcondition: returns hints*/
  public abstract char getHint(String word, int hintNumber);
  
  /* method: getSpyType 
   * purpose: returns int to represent type of spy 
   * postcondition: if LandSpy return 1, if WaterSpy return 2 */
  public abstract int getSpyType();
  
  /* method: addSpecialPoints
   * purpose: adds specialty points (landPoints or waterPoints)
   * @param: int sPoints
   * precondition: sPoints>=0
   */
  public abstract void addSpecialPoints(int sPoints);
  
  
  /* method: getSpecialPoints
   * purpose: retreives specialty points (landPoints or waterPoints)
   * postcondition: returns how many special points player has 
   */
  public abstract int getSpecialPoints();
  
  
  //type of spy method
}//end class