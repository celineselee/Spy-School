import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.util.ArrayList; 
import java.util.Iterator;
import java.io.*;
/* Author: Celine Lee & Kristen Fajardo
 * Date created: Jan 11 2016
 * Date last updated: Jan 18 2016
 * Purpose: to run the spy school game
 */
//RUNNER CLASS
public class SpySchool{
  public static void main(String[]args){
    
//SHOW WELCOME MESSAGE AND INSTRUCTIONS
    ImageIcon spySchoolWelcome = new ImageIcon("welcome page.jpg");
    JOptionPane.showMessageDialog(null, "Click ok to continue", "Welcome!", JOptionPane.PLAIN_MESSAGE , spySchoolWelcome);
    ImageIcon spySchoolWelcome2 = new ImageIcon("welcome page2.jpg");
    JOptionPane.showMessageDialog(null, "", "Welcome!", JOptionPane.PLAIN_MESSAGE, spySchoolWelcome2);
    ImageIcon spySchoolWelcome4 = new ImageIcon("welcome page4.jpg");
    JOptionPane.showMessageDialog(null, "", "Welcome!", JOptionPane.PLAIN_MESSAGE, spySchoolWelcome4);
    ImageIcon spySchoolWelcome3 = new ImageIcon("welcome page3.jpg");
    JOptionPane.showMessageDialog(null, "", "Welcome!", JOptionPane.PLAIN_MESSAGE, spySchoolWelcome3);
    ImageIcon spySchoolWelcome5 = new ImageIcon("welcome page5.jpg");
    JOptionPane.showMessageDialog(null, "", "Welcome!", JOptionPane.PLAIN_MESSAGE, spySchoolWelcome5);

    
//SELECT NUMBER OF PLAYERS '
    
    ImageIcon landSpyIcon = new ImageIcon("land spy.jpg");
    ImageIcon waterSpyIcon = new ImageIcon("water spy.jpg");
    
    ImageIcon icon = new ImageIcon("players icon.jpg");
    Object[] possibilities = {"2", "3", "4", "5", "6", "Quit"};
    String choice = (String)JOptionPane.showInputDialog(null, "How many players are playing?", "Select Players", JOptionPane.QUESTION_MESSAGE, icon, possibilities, "2");
    //if user clicks cancel or close
    if(choice==null){ 
      JOptionPane.showMessageDialog(null, "Goodbye");
      System.exit(0);
    }
    //if user chooses quit 
    if(choice.equals("Quit")){
      JOptionPane.showMessageDialog(null, "Goodbye");
      System.exit(0);
    }
    
    //parse number of players 
    int numPlayers = Integer.parseInt(choice);
    
    //create arrayList of Spies 
    ArrayList<Spy> spies = new ArrayList<Spy>(numPlayers);
    
    //create arrayList of total points earned by all the players for EACH MINI GAME
    ArrayList<Integer> totalPoints = new ArrayList<Integer>(4);
    
//SELECT TYPE OF SPY AND ENTER NAME
    //make sure there is at least one of each spy
    boolean oneLS=false;
    boolean oneWS=false;
    
    for(int i=0; i<numPlayers; i++){
      
      JOptionPane.showMessageDialog(null, "You are player " + (i+1));
      
      //if player isn't the last player
      if(i!=numPlayers-1){
        Object[] types = {"Choose one", "Land Spy", "Water Spy"};
        Object[] types2 = {"Land Spy", "Water Spy"};
        ImageIcon typeOfSpy = new ImageIcon("type of spy.jpg");
        String type = (String)JOptionPane.showInputDialog(null, "What kind of spy would you like to play as?", "Type of Spy?", JOptionPane.QUESTION_MESSAGE, typeOfSpy, types, "Choose one");
        //if user chooses to cancel shut down program
        if(type==null) System.exit(0);
        //if user chooses "choose one" tell them to choose again
        else if(type.equals("Choose one")){
          type = (String)JOptionPane.showInputDialog(null, "Choose which type of spy you want to play as", "Type of Spy?", JOptionPane.QUESTION_MESSAGE, typeOfSpy, types2, "Choose one");
          if(type==null) System.exit(0);
        }//end else if
        
        //if user chooses to be a land spy
        if(type.equals("Land Spy")){
          JOptionPane.showMessageDialog(null, "You are a Land Spy!", "Land Spy!", JOptionPane.PLAIN_MESSAGE, landSpyIcon);
          String name = JOptionPane.showInputDialog("Please enter in your name");
          if(name==null){ 
            JOptionPane.showMessageDialog(null, "Game will shut down");
            System.exit(0);}
          else if(name.length()==0) name = "Player " + (i+1);
          LandSpy newLS = new LandSpy(name);
          oneLS=true;
          spies.add(newLS);
        }//end else if
        
        //else if user chooses to be a water spy
        else{
          oneWS=true;
          JOptionPane.showMessageDialog(null, "You are a Water Spy!", "Water Spy!", JOptionPane.PLAIN_MESSAGE, waterSpyIcon);
          String name = JOptionPane.showInputDialog(null, "Please enter in your name");
          if(name==null){ 
            JOptionPane.showMessageDialog(null, "Game will shut down");
            System.exit(0);}
          else if(name.length()==0) name = "Player " + (i+1);
          WaterSpy newWS = new WaterSpy(name);
          spies.add(newWS); 
        }//end else
        
        int playerNum = i;
        
        JOptionPane.showMessageDialog(null, "Player " + (playerNum+2) + " get ready to fill in your information");
        
      }//end big if
      
      //CHECK THAT THERE IS AT LEAST ONE OF EACH SPY BEFORE ASKING USER WHAT THEY WANT TO BE.
      
      //IF THERE ISN'T AT LEAST ONE THE LAST ONE IS BY DEFAULT THE SPY THAT THE TEAM DOESN'T HAVE
      else if(i==numPlayers-1 && oneLS==false || oneWS==false){
        if(oneLS==false){
          JOptionPane.showMessageDialog(null, "You are a Land Spy!", "Land Spy!", JOptionPane.PLAIN_MESSAGE, landSpyIcon);
          String name = JOptionPane.showInputDialog(null, "Please enter your name");
          if(name==null){ 
            JOptionPane.showMessageDialog(null, "Game will shut down");
            System.exit(0);}
          else if(name.length()==0) name = "Player " + (i+1);
          LandSpy newLS = new LandSpy(name);
          spies.add(newLS);
        }//end if
        else if(oneWS==false){
          JOptionPane.showMessageDialog(null, "You are a Water Spy!", "Water Spy!", JOptionPane.PLAIN_MESSAGE, waterSpyIcon);
          String name = JOptionPane.showInputDialog(null, "You are a Water Spy. Please enter your name"); 
          if(name==null){ 
            JOptionPane.showMessageDialog(null, "Game will shut down");
            System.exit(0);}
          else if(name.length()==0) name = "Player " + (i+1);
          WaterSpy newWS = new WaterSpy(name);
          spies.add(newWS);
        }//end else if   
      }//end big else if
      
      
      //if there is at least one of each spy then ask the last player to fill in info as usual
      else if(i==numPlayers-1 && oneLS==true || oneWS==true){
        
        Object[] types = {"Choose one", "Land Spy", "Water Spy"};
        Object[] types2 = {"Land Spy", "Water Spy"};
        ImageIcon typeOfSpy = new ImageIcon("type of spy.jpg");
        String type = (String)JOptionPane.showInputDialog(null, "What kind of spy would you like to play as?", "Type of Spy?", JOptionPane.QUESTION_MESSAGE, typeOfSpy, types, "Choose one");
        //if user chooses to cancel shut down program
        if(type==null) System.exit(0);
        //if user chooses "choose one" tell them to choose again
        else if(type.equals("Choose one")){
          type = (String)JOptionPane.showInputDialog(null, "Choose which type of spy you want to play as", "Type of Spy?", JOptionPane.QUESTION_MESSAGE, typeOfSpy, types2, "Choose one");
          if(type==null) System.exit(0);
        }//end else if
        
        //if user chooses to be a land spy
        if(type.equals("Land Spy")){
          JOptionPane.showMessageDialog(null, "You are a Land Spy!", "Land Spy!", JOptionPane.PLAIN_MESSAGE, landSpyIcon);
          String name = JOptionPane.showInputDialog(null, "Please enter in your name");
          if(name==null){ 
            JOptionPane.showMessageDialog(null, "Game will shut down");
            System.exit(0);}
          else if(name.length()==0) name = "Player " + (i+1);
          LandSpy newLS = new LandSpy(name);
          oneLS=true;
          spies.add(newLS);
        }//end else if
        
        //else if user chooses to be a water spy
        else{
          JOptionPane.showMessageDialog(null, "You are a Water Spy!", "Water Spy!", JOptionPane.PLAIN_MESSAGE, waterSpyIcon);
          oneWS=true;
          String name = JOptionPane.showInputDialog(null, "Please enter in your name");
          if(name==null){ 
            JOptionPane.showMessageDialog(null, "Game will shut down");
            System.exit(0);}
          WaterSpy newWS = new WaterSpy(name);
          spies.add(newWS); 
        }//end else
        
        
      }//end big else if 2
      
    }//end for (populating spies arrayList)
    
    //////////////////////////////////////////////////////////////////////
    //MINI GAME 1/////////////////////////////////////////////////////////*****************************************************************************************************
    ////////////////////////////////////////////Riddle Game///////////////
    
    ImageIcon challenge1 = new ImageIcon("challenge1.jpg");
    JOptionPane.showMessageDialog(null, "", "Challenge 1!", JOptionPane.PLAIN_MESSAGE, challenge1);
    ImageIcon specialPoints1 = new ImageIcon("special point.jpg");
    JOptionPane.showMessageDialog(null, "", "Special Point!", JOptionPane.PLAIN_MESSAGE , specialPoints1);
    
    //iterator for easy traversal
    Iterator <Spy> iterator = spies.iterator(); 
    
    int g1Total = 0; 
    
    for(int i=0; i<numPlayers; i++){
      
      //ask question, user has 3 chances to guess
      int points = 0;
      
      //get the next spy object in arrayList
      Spy currentSpy = iterator.next();
      
      //tell person that it's their turn
      String name = currentSpy.getName(); 
      JOptionPane.showMessageDialog(null, name + " it is your turn!");
      
      System.out.println(currentSpy.getSpyType());
      
//***************~~polymorphism~~**************//
      
      //if player is a land spy 
      if(currentSpy.getSpyType()==1){
        try{
          String[] riddleLine = MiniGames.getLandRiddle(i);
          points += MiniGames.runRiddles(riddleLine);
        }catch(IOException FileNotFoundException){
          System.out.println("no file!");
        }//end try/catch         
      }//end if
      
      //if player is a water spy 
      else if(currentSpy.getSpyType()==2){
        try{
          String[] riddleLine = MiniGames.getWaterRiddle(i);
          points += MiniGames.runRiddles(riddleLine);
        }catch(IOException FileNotFoundException){
          System.out.println("no file!");
        }//end try/catch
      }//end else if
      
      //if the user guesses the answer properly tell them good job
      if(points==1) JOptionPane.showMessageDialog(null, "Correct! You have passed this challenge");
      else JOptionPane.showMessageDialog(null, "You have failed this challenge!");
      
      //add points to their "special points"
//***************~~polymorphism~~**************//
      currentSpy.addSpecialPoints(points); 
      
      //add points to g1Total
      g1Total += points; 
      
      //tell next user to get ready as long as they are not the last one 
      if(i!=numPlayers-1) JOptionPane.showMessageDialog(null, "Player " + (i+2) + " you are next");
      
      
    }//end game1
    
    //add total number of points earned during this game into totalPoints
    totalPoints.add((Integer)g1Total);
    
    //tell team how many points they won during this game
    JOptionPane.showMessageDialog(null, "Your team has won a total of " + g1Total + " points during this game");
    
    
    ////////************************************************//////////////
    //MINI GAME 2/////////////////////////////////////////////////////////******************************************************************************************
    ////////////////////////////////////***********Maths Game************
    ImageIcon challenge2 = new ImageIcon("challenge2.jpg");
    JOptionPane.showMessageDialog(null, "", "Challenge 2!", JOptionPane.PLAIN_MESSAGE, challenge2);
    ImageIcon befast = new ImageIcon("be fast.jpg");
    JOptionPane.showMessageDialog(null, "", "Be fast!", JOptionPane.PLAIN_MESSAGE , befast);
    JOptionPane.showMessageDialog(null, "Each spy will receive 3 math questions each");
    
    int g2Total = 0; 
    
    //make new iterator
    Iterator <Spy> spyterator = spies.iterator(); 
    
    //keep track of which math question to ask
    int whichQuestion = 0; 
    
    //repat for as long as there are players 
    for(int i=0; i<numPlayers; i++){
      
      //get the next spy object in arrayList
      Spy currSpy = spyterator.next();
      
      //tell person that it's their turn
      String name = currSpy.getName(); 
      JOptionPane.showMessageDialog(null, name + " it is your turn!");
      
      JOptionPane.showMessageDialog(null, "GO!"); 
      
      int playerPoints = 0;
      
      String response;
      
      long start = System.currentTimeMillis();
      //each players answers 3 qustions each
      for(int j=0; j<3; j++){
        try{
          String[] questionLine = MiniGames.mathQuestion(whichQuestion);
          whichQuestion++; 
          response = JOptionPane.showInputDialog(null, questionLine[0]); 
          while (response == null) response = JOptionPane.showInputDialog(null, "Answer this question: \n " + questionLine[0]);
          while (response.equals("")){ 
            response = JOptionPane.showInputDialog(null, "You did not enter in anything!\n" + questionLine[0]);
            while(response==null) System.exit(0);
          }//end while
          
          //check if answer is correct and add points to playerPoints
          playerPoints += MiniGames.checkMathAnswer(response, questionLine);
          
        }catch(IOException FileNotFoundException){
          System.out.println("no file!");
        }//end try/catch         
        
      }//end for
      long difference = System.currentTimeMillis() - start;
      long time = difference/1000;
      
      //if it takes user less than 30 secs to FINISH they get 2 points extra
      if(time<30 && playerPoints>0){ 
        JOptionPane.showMessageDialog(null, "Since it took you less than 30 seconds to finish, you get an extra 2 points!");
        playerPoints += 2;
      }//end if
      
      //tell user how many points they got
      JOptionPane.showMessageDialog(null, "You have earned " + playerPoints + " points.");
      
      //add to player's points
      currSpy.addPoints(playerPoints);
      
      //add to g2Total
      g2Total += playerPoints;
      
      if(i!=numPlayers-1) JOptionPane.showMessageDialog(null, "Player " + (i+2) +", you are next!");
      
    }//end for (repeat for amount of players)
    
    totalPoints.add(g2Total);
    JOptionPane.showMessageDialog(null, "Your team has earned a total of " + g2Total + " points in this game");
    
    //////////////////////////////////////////////////////////////////////
    //MINI GAME 3/////////////////////////////////////////////////////////****************************************************************************************************
    ///////////////////////////ANAGRAMS///////////////////////////////////
    ImageIcon challenge3 = new ImageIcon("challenge3.jpg");
    JOptionPane.showMessageDialog(null, "", "Challenge 3!", JOptionPane.PLAIN_MESSAGE, challenge3);
    
    //keeps track of total points earned by team in this game
    int game3Total=0;
    //redeclare spyterator to point to top
    spyterator = spies.iterator();
    
    //repeat for as many times as there are people 
    for(int i=0; i<numPlayers; i++){
      int playerPoints = 0; 
      Spy currentSpy = spyterator.next();
      
      //tell user whose turn it is
      JOptionPane.showMessageDialog(null, "It is " + currentSpy.getName() +  "'s turn!"); 
      
      //each user has 3 anagrams to solve
      for(int j=0; j<3; j++){
        
        //show user word and ask for input
        String word = MiniGames.getAnagram(); 
        String answer = JOptionPane.showInputDialog(null, "Anagram " + (j+1) + " of 3:\n" + word);
        /*error trapping 
         if answer is blank ask again
         if user presses cancel quit game*/
        if(answer==null){ 
          JOptionPane.showMessageDialog(null, "Quitting Game");
          System.exit(0);
        }///end if 
        while(answer.equals(word)){
          answer = JOptionPane.showInputDialog(null, "You cannot enter the same word!\n" + word);
        }//end while
        while(answer.equals("")){ 
          answer = JOptionPane.showInputDialog(null, "You did not enter anything in!\n" + word);
          //error trap again
          if(answer==null){
            JOptionPane.showMessageDialog(null, "Quitting Game");
            System.exit(0);
          }//end if
        }//end while
        
        //check answer
        playerPoints = playerPoints + MiniGames.checkAnagramAnswer(word, answer);
        
                 
        
      }//end inner for
      
      //add to game3Total
      game3Total = game3Total + playerPoints;     
      
      currentSpy.addPoints(playerPoints);
      
      JOptionPane.showMessageDialog(null, "You have earned " + playerPoints + " points in this game");
      
    }//end MINI GAME 2 FOR LOOP
    
    //show team how many points they earned
    JOptionPane.showMessageDialog(null, "Your team has earned a total of " + game3Total + " points during this challenge");
    //add to totalPoints arraylist
    totalPoints.add(game3Total);
    
    //////////////////////////////////////////////////////////////////////
    //MINI GAME 4/////////////Alphabet game///////////////////////////////****************************************************************************************************
    //////////////////////////////////////////////////////////////////////
    
    ImageIcon challenge4a = new ImageIcon("challenge4a.jpg");
    JOptionPane.showMessageDialog(null, "", "Challenge 1!", JOptionPane.PLAIN_MESSAGE, challenge4a);
    ImageIcon challenge4b = new ImageIcon("challenge4b.jpg");
    JOptionPane.showMessageDialog(null, "", "Challenge 1!", JOptionPane.PLAIN_MESSAGE, challenge4b);
    ImageIcon befastandspecialpoint = new ImageIcon("be fast and special points.jpg");
    JOptionPane.showMessageDialog(null, "", "Speed and special Point!", JOptionPane.PLAIN_MESSAGE , befastandspecialpoint);
    
    spyterator = spies.iterator();
    int game4Points = 0;
    
    for(int i=0; i<numPlayers; i++){
      Spy currentSpy = spyterator.next(); 
      String name = currentSpy.getName(); 
      
      JOptionPane.showMessageDialog(null, name + " it is your turn"); 
      int spyType = currentSpy.getSpyType();
      int playerPoints = MiniGames.playAlphabet(spyType);
      JOptionPane.showMessageDialog(null, "You have earned " + playerPoints + " points in this game");
      game4Points += playerPoints;
      currentSpy.addSpecialPoints(playerPoints);
      
    }//end for
    
    totalPoints.add(game4Points);
    
    JOptionPane.showMessageDialog(null, "Your team has won a total of " + game4Points + " points in this game");
    
    ////////////////////////////////////////////////////
    /////final part -- output team and computer's/////////*******************************************************************************************
    /////////scores & if team's scores are higher//////////******************************************************************************************
    ///////they get a clue!!///////////////////////////
    
    ArrayList <Integer> compPoints = new ArrayList<Integer>(4);
    
    //make up computers's scores for each game and save to compPoints arrayList
    //game 1
    int gamePoint = MiniGames.computerPoints(1,0, numPlayers);
    compPoints.add(gamePoint);
    
    //game2
    gamePoint = MiniGames.computerPoints(5, 1, numPlayers);
    compPoints.add(gamePoint);
    
    //game3
    gamePoint = MiniGames.computerPoints(3, 1, numPlayers);
    compPoints.add(gamePoint); 
    
    //game4
    gamePoint = MiniGames.computerPoints(8, 2, numPlayers);
    compPoints.add(gamePoint);
    
    //show players game summary
    JOptionPane.showMessageDialog(null, "Here is the summary of your game!");
    
    String header = "Game\t" + "Team Score\t" + "Computer Score";
    String line1 = "1\t" + totalPoints.get(0) + "\t" + compPoints.get(0);
    String line2 = "2\t" + totalPoints.get(1) + "\t" + compPoints.get(1);
    String line3 = "3\t" + totalPoints.get(2) + "\t" + compPoints.get(2);
    String line4 = "4\t" + totalPoints.get(3) + "\t" + compPoints.get(3);
    
    JTextArea scoreCard = new JTextArea(header + "\n" + line1 + "\n" + line2 + "\n" + line3 + "\n" + line4);
    JOptionPane.showMessageDialog(null, scoreCard);
    
    //see how many times team has beat computers
    int timesBeat = 0;
    
    for(int i=0; i<4; i++){
      if(totalPoints.get(i) > compPoints.get(i)) timesBeat++;
      else if(totalPoints.get(i) == compPoints.get(i)) timesBeat++;
      else timesBeat += 0; 
    }//end for
    
    int teampoints = 0;
    //calculate total points 
    for(int i=0; i<4; i++){
      teampoints = teampoints + totalPoints.get(i);
    }//end for
    
    //if team does not beat computers at least once
    if(timesBeat==0){ 
      JOptionPane.showMessageDialog(null, "Your team has failed Spy School. You have not beat the computer even once.");
      System.exit(0);        
    }//end if
    
    //else if the team beat computers at least once!!!
    
    else{
      
      //get the password 
      String password = LastPart.getPassword();
      System.out.println(password);
      
//      //will get as many hints as team beats computers
//      char[] hints = new char[timesBeat];
      
      String hints = "";
      
      JOptionPane.showMessageDialog(null, "Since you have beat the computer team " + timesBeat + " times, you get " + timesBeat + " clues!");
      
      //make array of String of names of players playing 
      ImageIcon player = new ImageIcon("players icon.jpg");
      String[] playerChoices = new String[numPlayers];
      for(int i=0; i<numPlayers; i++){
        //populate possible player choices
        playerChoices[i] = (spies.get(i)).getName();
      }//end for
      
      //ask for as many times as they beat computer
      for(int i=0; i<timesBeat; i++){
        String hintChoice = (String)JOptionPane.showInputDialog(null, "Who will receive the hint? Choose wisely!", "Player hint", JOptionPane.QUESTION_MESSAGE, icon, playerChoices, playerChoices[0]);
        //if they choose cancel shut down game
        if(hintChoice==null) System.exit(0);
        //else ask them who wants to receive password
        else{
        for(int j=0; j<numPlayers; j++){
          if(hintChoice.equals(playerChoices[j])){ 
            Spy hintSpy = spies.get(j);
            
            System.out.println(hintSpy.getSpyType());//what kind of spy 
            System.out.println(hintSpy.getSpecialPoints());//see how many special points they have
            
           
            //if spy has at least 3 special points give them clue
            if(hintSpy.getSpecialPoints()>=3){
           
                hints = hints + hintSpy.getHint(password, i) + " ";
                System.out.println(hints);
                JOptionPane.showMessageDialog(null, "Hint recorded!");
        
            }//end if spy has enough special points 
            else if(hintSpy.getSpecialPoints()<=0) {
              JOptionPane.showMessageDialog(null, "This player does not have enough specialty points! Game will blow up!");
              System.exit(0);
            }
          }//end if
        }//end for
        }//end else
      }//end for to ask who will receive hint
    
      String hintString = ""; 
      

      
      JTextArea hintsScreen = new JTextArea("Here are your hints: \n "
                                              + "Your key word contains these letters:\n" 
                                              + hints);
      JOptionPane.showMessageDialog(null, hintsScreen);
      
      String guess = JOptionPane.showInputDialog("Guess your password!");
      if(guess==null){
        JOptionPane.showMessageDialog(null, "You have failed to use your mouse properly! Why did you press cancel?!");
        JOptionPane.showMessageDialog(null, "You have failed your team.");
        System.exit(0);
      }//end error trapping
      LastPart.guessPassword(password, guess, teampoints, numPlayers);
      
   
    }//end big else (team beats computers) 
  }//end main
}//end class