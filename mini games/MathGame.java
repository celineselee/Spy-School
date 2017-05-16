import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;///IDK?

/* Author:
 * Date created: Jan 10 2016
 * Date last updated:
 * Purpose: to run the math game
 */
//MINI GAME 3
public class MathGame{
  
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
    
  }//end method getWaterRiddle
  
  public static int checkResponse(String input, String[] question){
    int answer = Integer.parseInt(question[1]);
    int response = Integer.parseInt(input);
    
    if(response==answer) return 1;
    else return 0;
  }//end method checkResponse
  
  
  
  
}//end class