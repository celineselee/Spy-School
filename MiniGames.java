import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList; 
import java.util.Iterator;
import javax.swing.JOptionPane;

/* Author: Celine Lee & Kristen Fajardo
 * Date created: Jan 7 2016
 * Date last updated: Jan 18 2016
 * Purpose: to hold minigames 
 */

public class MiniGames{
  
  /* method: computerPoints
   * purpose: to return the computer team's points 
   * @param: int numPlayers
   * preCondition: numPlayers >= 2 
   * postcondition: returns computer team's points */
  public static int computerPoints(int max, int min, int numPlayers){
    int compPoints = 0;
    for(int i=0; i<numPlayers; i++){
      int point = (int)((Math.random()*(max-min+1))+min);
      compPoints += point; 
    }//end for
    return compPoints;    
    
  }//end method computerRiddle
  
  
  ////////////////////////////////
  ////Mini Game 1/////////////////*********************************************************************************************************************************************
  ////////////////////Riddles/////
  ////////////////////////////////
  
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
  
  /* method: runRiddles 
   * purpose: to run the riddle game 
   * @param: String[] riddleline
   * precondition: riddleLine.length>0 & riddle in index 0 and answer in index 1 (intended for use with getWaterRiddle & getLandRiddle)
   * postcondition: returns num points player gets if their answer is correct (1 if it is correct and 0 if it is incorrect)
   */
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
      
  }//end method runRiddles
  
  
  ////////////////////////////////
  ////Mini Game 2/////////////////**********************************************************************************************************************************************
  ////////////////Math Game///////
  ////////////////////////////////
  
  /* method: mathQuestion
   * @param: which question line to display
   * preCondition: questionNum>=0
   * purpose: to return an array with the math question in index 0 and answer in index 1
   * postcondition: returns array with math question and response */
  public static String[] mathQuestion(int questionNum)throws FileNotFoundException{
    
    Scanner input = new Scanner(new FileReader("math game.txt"));
    String question = "";
    int count=0;
    String[] questionOut = new String[2]; 
    
    //count how many lines there are
    while(input.hasNextLine()){
      question = input.nextLine();
      count++;
    }//end while
    
    input.close();
    
    //redeclare scanner (reset to pointer to top)
    input = new Scanner(new FileReader("math game.txt"));
    
    //declare and populate array with ALL the questions 
    String[] allQuestions = new String[count];
    
    for(int i=0; i<count; i++){
      allQuestions[i] = input.nextLine();
    }//end for
    
    //the question and answer that will be returned will be from line whichQuestion
    String questionLine = allQuestions[questionNum];
    
    StringTokenizer tokenizer = new StringTokenizer(questionLine, "="); 
    
    for(int i=0; i<2; i++){
      questionOut[i] = tokenizer.nextToken(); 
    }//end for
    
    return questionOut;
    
  }//end method mathQuestion
  
  public static int checkMathAnswer(String input, String[] question){
    int answer = Integer.parseInt(question[1]);
    int response = Integer.parseInt(input);
    
    if(response==answer) return 1;
    else return 0;
  }//end method checkMathAnswer
  
  
  ////////////////////////////////
  ////Mini Game 3/////////////////*****************************************************************************************************************************************
  /////////////Anagram Game///////
  ////////////////////////////////
  static String[] anagramWords = {"alert", "coast", "below", "crate", "drawer", 
                         "horse", "steal", "rinse", "saint", "steer", 
                         "kale", "enlist", "merit", "snail", "ring", "poodle", 
                         "space","hatred", "drawer", "used", "salesman", "burned", 
                         "despair", "early", "thing", "flow", "dad", "tablet" };
  
  
  /* Method: getAnagram
   * @return: a random word from array of anagramWords
   * Purpose: retrieves an anagram word from array "anagramWords"
   * Post-condition: random word is outputted
  */
  public static String getAnagram() {
    final int MAX = anagramWords.length-1;
    final int MIN = 0;
    
    int ranNum = (int)(Math.random()*(MAX-MIN+1))+MIN;
    return anagramWords[ranNum];
  }//end getWord
  
  /* Method: sortAnagram
   * @param: String word
   * @return: String sortedWord
   * purpose: sorts word into alphabetical order 
   * precondition: String word must not be empty 
   * precondition: String which contains sorted word
   */
  public static String sortWord(String word){
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
    
    return sortedWord;

  }//end sortWord
    
  
  /* Method: checkAnagramAnswer
   * Purpose: Compares sorted original word and user input. If they are the same, player has successfully solved the anagram and gets a point.
   * Pre-condition: String word (What the user sees on the screen) & String userAnswer (what the user inputs)
   * Post-condition: If user has correctly input an anagram output 1 else output 0.
   * @param: a String word, String userAnswer
   * @return: a 1 or 0
  */
  public static int checkAnagramAnswer(String word, String userAnswer){
        
    String sortedWord = MiniGames.sortWord(word);
    String sortedUserWord = MiniGames.sortWord(userAnswer);
        
    //CHECK
    if(sortedUserWord.equalsIgnoreCase(sortedWord))
      return 1;
    else return 0;
  }//end checkAnagramAnswer
  
  
  ////////////////////////////////
  ////Mini Game 4/////////////////*****************************************************************************************************************************************
  /////////////AlphabetGame///////
  ////////////////////////////////
  
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
    final int MAX = landWords.length-1;
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
    final int MAX = waterWords.length-1;
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
  public static int playAlphabet(int spyType) {
    
    
    int points = 0;
    long start = System.currentTimeMillis();
    //forward alphabet 5 times
    for(int i=0; i<3; i++){
      /*get word for LAND spies*/
      if(spyType==1) {
        String word = getLandWords();
        
        String userWord = JOptionPane.showInputDialog(word);
        
        //ERROR TRAPPING: 
        /* WORD MUST BE:
         * 1. longer than 1 letter long
         * 2. not blank 
         * 3. if null close program
         */
        if(userWord==null){
          JOptionPane.showMessageDialog(null, "Quitting Game");
          System.exit(0); 
        }//end if
        while(userWord.length()==1){ 
          userWord = JOptionPane.showInputDialog("Your word must be more than 1 letter long!\n" + word);
          if(userWord==null) System.exit(0);
        }
        while(userWord.length()==0){ 
          userWord=JOptionPane.showInputDialog("Please enter your word! \n" + word); 
          if(userWord==null) System.exit(0);
        }//end while
        
        
        //first letter of the user's word
        String userLetter = userWord.substring(0, 1);
        
        //first letter of outputted word
        String wordLetter = word.substring(0, 1);
        
        //first letter of user's word must be one greater than 1st letter of outputted word
        if(userLetter.compareTo(wordLetter)==1) points = points + 1;
        else points += 0; 
        
      }
      /*get word for WATER spies*/
      else if (spyType==2) {
        String word=getWaterWords();
        String userWord = JOptionPane.showInputDialog(word);
        
        //ERROR TRAPPING: 
        /* WORD MUST BE:
         * 1. longer than 1 letter long
         * 2. not blank 
         * 3. if null close program
         */
        while(userWord.length()==1){ 
          userWord = JOptionPane.showInputDialog("Your word must be more than 1 letter long!\n" + word);
          if(userWord==null) System.exit(0);
        }
        while(userWord.length()==0){ 
          userWord=JOptionPane.showInputDialog("Please enter your word! \n" + word); 
          if(userWord==null) System.exit(0);
        }//end while
        if(userWord==null){
          JOptionPane.showMessageDialog(null, "Quitting Game");
          System.exit(0); 
        }//end if
        
        //first letter of user's word
        String userLetter = userWord.substring(0, 1);
        
        //first letter of outputted word
        String wordLetter = word.substring(0, 1);
        
        //first letter of userLetter must be 1 greater than 1st letter of wordLetter
        if(userLetter.compareTo(wordLetter)==1)
          points+=1;
      }
    }//end forward for 
    
    JOptionPane.showMessageDialog(null, "REVERSE!!");
    
    //reverse alphabet 5 times
    for(int i=0; i<5; i++){
    //REVERSE
      /*get word for LAND spies*/
      if(spyType==1) {
        String word=getLandWords();
        String userWord = JOptionPane.showInputDialog(word); 
        
        //ERROR TRAPPING: 
        /* WORD MUST BE:
         * 1. longer than 1 letter long
         * 2. not blank 
         * 3. if null close program
         */
        while(userWord.length()==1){ 
          userWord = JOptionPane.showInputDialog("Your word must be more than 1 letter long!\n" + word);
          if(userWord==null) System.exit(0);
        }
        while(userWord.length()==0){ 
          userWord=JOptionPane.showInputDialog("Please enter your word! \n" + word); 
          if(userWord==null) System.exit(0);
        }//end while
        if(userWord==null){
          JOptionPane.showMessageDialog(null, "Quitting Game");
          System.exit(0); 
        }//end if
        
        //first letter of user's word
        String userLetter = userWord.substring(0, 1);
        
        //first letter of outputted word
        String wordLetter = word.substring(0, 1);
        
        //first letter of userLetter must be 1 less than 1st letter of wordLetter
        if(userLetter.compareTo(wordLetter)== -1)
          points+=1;
        else points += 0; 
      }
      /*get word for WATER spies*/
      else if(spyType==2) {
        String word=getWaterWords();
        String userWord = JOptionPane.showInputDialog(word);
        
        //ERROR TRAPPING: 
        /* WORD MUST BE:
         * 1. longer than 1 letter long
         * 2. not blank 
         * 3. if null close program
         */
        while(userWord.length()==1){ 
          userWord = JOptionPane.showInputDialog("Your word must be more than 1 letter long!\n" + word);
          if(userWord==null) System.exit(0);
        }
        while(userWord.length()==0){ 
          userWord=JOptionPane.showInputDialog("Please enter your word! \n" + word); 
          if(userWord==null) System.exit(0);
        }//end while
        if(userWord==null){
          JOptionPane.showMessageDialog(null, "Quitting Game");
          System.exit(0); 
        }//end if
        
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
    
    //only award 3 extra points if they have finished in under 20 secs & they have at least 1 point
    if(time<20 && points > 0){ 
      points += 3;
      JOptionPane.showMessageDialog(null, "Since you have completed the challenge in less than 20 seconds you get an extra 3 points!");
    }
    return points;
    
    
  }//end playAlphabet
  
  
  
  
  




}//end class