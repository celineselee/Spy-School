import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList; 
import java.util.Iterator;
import javax.swing.JOptionPane;
/* Author: Celine Lee & Kristen Fajardo
 * Date created: Jan 16 2016
 * Date last updated: Jan 18 2016
 * Purpose: to run the last part of the game
 */

public class LastPart{
  /* method: getPassword
   * purpose: to select a random word from the array of potential passwords
   * postcondition: returns a String containing password
   */
  public static String getPassword(){
    String[] passwords = {"apple", "books", "death", "kanji", "carol", "water", "squad", "jello", "tails"};
    int max = passwords.length-1;
    String password = passwords[(int)(Math.random()*max+1)];  
    System.out.println(password); 
    return password; 
  }//end 
  
  
  
  /* method: guessPassword
   * purpose: if team correctly guesses password let them sign yearbook 
   * @param: String guess
   * preCondition: guess cannot be empty  
   */
  public static void guessPassword (String password, String guess, int teamScore, int numPlayers){
    
    if(guess.equals(password)){
      JOptionPane.showMessageDialog(null, "You have successfully guessed the password! Your team has graduated Spy School!");
      String name = JOptionPane.showInputDialog("Time to sign the yearbook! Enter your team name! (It must not contain a space)");
      if(name==null) System.exit(0);
      while(name.length()==0) name = JOptionPane.showInputDialog("Please enter your team name!");
      
      
      try{
        int pointRank = teamScore/numPlayers;
        String teamInfo = name + "-" + pointRank; 
        File file = new File("leaderboard.txt");
        
        //if file is not found create the file
        if(!file.exists()) file.createNewFile();
        
        //append the content to file
        FileWriter fw = new FileWriter(file, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw); 
        
        pw. println(teamInfo);
        pw.close();
        
        JOptionPane.showMessageDialog(null, "You have successfully signed the yearbook!");
        
        //tell them which rank they are at
        int ranking = LastPart.ranking(pointRank);
        if(ranking==1){ 
          JOptionPane.showMessageDialog(null, "Your team ranked 1st of all teams! Thanks for playing!");
          System.exit(0);
        }//end if
        else if(ranking==2){
          JOptionPane.showMessageDialog(null, "Your team ranked 2nd of all teams! Thanks for playing!");
          System.exit(0);
        }//end if
        else {
          JOptionPane.showMessageDialog(null, "Your team ranked " + ranking + "th of all teams! Thanks for playing!");
          System.exit(0);
        }//end else
        
      }catch(IOException ioe){
        System.out.println("exception!!");
      }//end try/catch 
      
    }//end if
    else{
      JOptionPane.showMessageDialog(null, "You have not guessed the password. Your team has failed Spy School");
      System.exit(0);
    }//end else
    
  }//end guessPassword method
  
  /* method: ranking
   * purpose: to output which rank the team is 
   * @param: int pointRank (teamPoints/numPlayers) 
   * preCondition: int pointRank >0
   * postcondition: int representing their rank
   */
  public static int ranking(int pointRank)throws FileNotFoundException{
    
    Scanner input = new Scanner(new FileReader("leaderboard.txt"));
    int count=0;
    String line = "";
    
    //count how many lines there are
    while(input.hasNextLine()){
      line = input.nextLine();
      count++;
    }//end while
    
    input.close();
    
    //redeclare scanner (reset to pointer to top)
    input = new Scanner(new FileReader("leaderboard.txt"));
    
    //declare and populate array with ALL points 
    int[] points = new int[count];
    
    for(int i=0; i<count; i++){
      String scoreLine = input.next();
      StringTokenizer tokenizer = new StringTokenizer(scoreLine, "-"); 
      String name = tokenizer.nextToken();
      String score = tokenizer.nextToken();
      points[i] = Integer.parseInt(score);     
    }//end for
    
    //sort points in descending order
    int j;                  
    int key;              
    int i;  

     for (j = 1; j < points.length; j++)   
    {
       key = points[ j ];
       for(i = j - 1; (i >= 0) && (points[ i ] < key); i--)   
          {
           points[ i+1 ] = points[ i ];
          }
         points[i+1] = key;    
     }

     for(int p=0; p<points.length; p++)System.out.println(points[p]);
     
    //search the position 
    int left = points.length, right = 0, target = pointRank, mid=0;
    
    boolean found = false;
    
    while (left != right-1){      
      mid = (left + right)/2;
      if (points[mid] < target) left = mid;
      else if (points[mid] > target) right = mid;
      else 
      {//found it
        found = true;
        left = right-1;
      }
    }//end while

      return mid;
      
    }//end method
    
    
  }//end class