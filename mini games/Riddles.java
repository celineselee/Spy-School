import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList; 
import java.util.Iterator;
import javax.swing.JOptionPane;
/* Author:
 * Date created: Jan 7 2016
 * Date last updated:
 * Purpose: to run the Riddles minigame 
 */

//MINI GAME 1
public class Riddles{
  
  
  /* method: getLandRiddle (riddle game for landSpy) 
   * purpose: returns string with land-related riddle in index 0 and answer in index 1 
   * @param: int whichRiddle 
   * precondition: whichRiddle>=0 
   * postcondition: returns an array of string with riddle in index 0 and answer in index 1  
   */
  public static String[] getLandRiddle(int whichRiddle)throws FileNotFoundException{
    
    Scanner input = new Scanner(new FileReader("land riddles.txt"));
    String text = "";
    int count=0;
    String[] landRiddle = new String[2]; 
    
    while(input.hasNextLine()){
      text = input.nextLine();
      count++;
    }//end while
    
    input.close();
    
    input = new Scanner(new FileReader("land riddles.txt"));
    
    String[] riddles = new String[count];
    
    for(int i=0; i<count; i++){
      riddles[i] = input.nextLine();
    }//end for
    
    String riddleLine = riddles[whichRiddle];
    
    StringTokenizer tokenizer = new StringTokenizer(riddleLine, ":"); 
    
    for(int i=0; i<2; i++){
      landRiddle[i] = tokenizer.nextToken(); 
      
    }//end for
    
    return landRiddle;
    
  }//end method getRiddle
  
  /* method: getWaterRiddle (Riddle game for waterSpy) 
   * purpose: returns string with water-related riddle in index 0 and answer in index 1 
   * @param: int whichRiddle 
   * precondition: whichRiddle>=0 
   * postcondition: returns an array of string with riddle in index 0 and answer in index 1  
   */
  public static String[] getWaterRiddle(int whichRiddle)throws FileNotFoundException{
    
    Scanner input = new Scanner(new FileReader("water riddles.txt"));
    String text = "";
    int count=0;
    String[] waterRiddle = new String[2]; 
    
    while(input.hasNextLine()){
      text = input.nextLine();
      count++;
    }//end while
    
    input.close();
    
    input = new Scanner(new FileReader("water riddles.txt"));
    
    String[] riddles = new String[count];
    
    for(int i=0; i<count; i++){
      riddles[i] = input.nextLine();
    }//end for
    
    String riddleLine = riddles[whichRiddle];
    
    StringTokenizer tokenizer = new StringTokenizer(riddleLine, ":"); 
    
    for(int i=0; i<2; i++){
      waterRiddle[i] = tokenizer.nextToken(); 
      
    }//end for
    
    return waterRiddle;
    
  }//end method getWaterRiddle
  
  
/* method: checkRiddleAnswer 
   * purpose: to check user's answer 
   * @param: String response, String[] riddle (from getWaterRiddle or getLandRiddle)  
   * precondition: response must not be "" (blank)  
   * postcondition: returns boolean (true if answer is correct, false if answer is incorrect) 
   */
//checks user's answer
  public static boolean checkRiddleAnswer(String response, String[] riddle){
    String correct = riddle[1];
    if(response.equalsIgnoreCase(correct)) return true;
    else return false;
  }//end method checkRiddleAnswer
  
  public static int runRiddles(String[] riddleLine){
    //if it is a land spy run the land spy game 

      String riddle = riddleLine[0];
      boolean correct = false;
      int chances = 0;
      
      while(correct==false && chances < 3 ){
      String response = JOptionPane.showInputDialog(null, riddle + "\n Try " + (chances+1) + " of 3");
      if(response==null){
        JOptionPane.showMessageDialog(null, "Bye");
        System.exit(0);
      }//if user presses cancel close program
      correct = checkRiddleAnswer(response, riddleLine);
      chances++;
      }//end while
          
      if(correct==true) return 1;
      else return 0;
      
  }//end method runMathGame
  
  
  
}//end class