import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public String[] vowels = {"a","e","i","o","u"};
    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	    // your code goes here
	for(int i = 0; i < sWord.length(); i++){
    		for (int g = 0; g < vowels.length; g++){
      			if(sWord.substring(i,i+1).equals(vowels[g])) return i;
    		}
  	}
        return -1;
    }

public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
 int temp = findFirstVowel(sWord);
 //System.out.println(temp);
 if(sWord.substring(0,2).equals("qu")){
   return sWord.substring(2)+"quay";
 }
  if(temp == -1) // no vowels
  {
    return sWord + "ay";
  }
  if(temp == 0){ //vowel is first letter
      return sWord+"way";
    }
  if(temp>0){ // start with vowel, then add starting consonants and then "ay"
    return sWord.substring(temp)+sWord.substring(0,temp)+"ay";
  }
  
    return "ERROR!";
  
}//end piglatin function
