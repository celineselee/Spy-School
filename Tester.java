public class Tester{
  public static void main(String[] args){
  
    LandSpy ls = new LandSpy("1");
    WaterSpy ws = new WaterSpy("2");
    LandSpy ls2 = new LandSpy("3");
    WaterSpy ws2 = new WaterSpy("4");
    
    
    String word = "fjord";
    char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
    char[] hints = new char[word.length()];
    char[] vowels = {'a', 'i', 'e', 'o', 'u'};
    
    //consonants
    int hintIndex = 0; 
    for(int i=0; i<word.length(); i++){
      for(int j=0; j<consonants.length; j++){
        if(word.charAt(i)==consonants[j]){
          hints[hintIndex] = word.charAt(i);
          hintIndex++;
        }//end if
      }//end for
    }//end for
    
    for(int i=0; i<hints.length; i++){
      System.out.println(hints[i]);
    }//end for
    

    
  }//end main  
}//end class