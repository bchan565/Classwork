/**
 * CS312 Assignment 6.
 *
 * On my honor, Brandon Chan, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Hangman.
 *
 *  email address: brandonchan@utexas.edu
 *  UTEID:bec944
 *  Number of slip days used on this assignment:
 */

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        intro();
        PhraseBank phrases = buildPhraseBank(args);
        // CS312 Students -- Do not create any additional Scanners.
        Scanner keyboard = new Scanner(System.in);
        String realWord = createRealWord(phrases);
       // System.out.println(realWord + createMysteryWord(realWord));
        playGame(keyboard,realWord,createMysteryWord(realWord));//play game is the method for running the game, it takes in a scanner, real word, and word with asterics
        gameRunner(keyboard, phrases);//this asks if you want to play another time
        // CS12 students: add your code here

        keyboard.close();
    }

    // CS12 students: add your methods here.

    // Build the PhraseBank.
    // If args is empty or null, build the default phrase bank.
    // If args is not null and has a length greater than 0
    // then the first elements is assumed to be the name of the
    // file to build the PhraseBank from.
    public static PhraseBank buildPhraseBank(String[] args) {
        PhraseBank result;
        if(args == null || args.length == 0
                || args[0] == null || args[0].length() == 0)
            result =  new PhraseBank();
        else
            result = new PhraseBank(args[0]);
        return result;
    }

    // show the intro to the program
    public static void intro() {
        System.out.println("This program plays the game of hangman.");
        System.out.println();
        System.out.println("The computer will pick a random phrase.");
        System.out.println("Enter letters for your guess.");
        System.out.println("After 5 wrong guesses you lose.");
    }
    public static String createRealWord(PhraseBank phrase){// this creates the word to guess by using a phrasebank object
    	System.out.println("\nI am thinking of a Movie ...");
    	String realWord = phrase.getNextPhrase();// makes the word
    	return realWord;
    }
    public static String createMysteryWord(String realWord){// this creates the parallel asterics word. It finds spaces or underscores
    	String mysteryWord = "";
    	for(int i = 0; i < realWord.length(); i++){//traverses the string length
    		if(realWord.charAt(i) !='_'){//detects if there isnt a _ (space)
    			mysteryWord += "*";//puts an asteric
    		}
    		else{
    		mysteryWord += "_";//puts a _
    		}
    	}
    	return mysteryWord;
    }
    public static String displayLetters(String letters, String guess){// this returns the unguessed letters
    	if(!letters.contains(guess)){//detects if there is a repeated letter guess
    		System.out.println(guess+" is not a valid guess.");
    		return letters;
    	}
    	int i = letters.indexOf(guess.toUpperCase());//this function removes the letter that is guessed
    	letters = letters.substring(0,i) + letters.substring(i+2);
    		return letters;
    }
    public static void playGame(Scanner keyboard, String realWord, String mysteryWord){//this method runs the actual game
    	String remainingLetters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";//starting word bank
    	int count = 0;//initializes number of wrong guesses
    	while(count < 5){//This loop continues as long as the play hasnt lost
    		System.out.println("\nThe current phrase is "+mysteryWord);//displays the unguessed word
    		System.out.println("\nThe letters you have not guessed yet are:\n"+remainingLetters);// displays the word bank
    		String guess = takeAGuess(keyboard);// this sets the guess by using the takeaguess method
    		remainingLetters = displayLetters(remainingLetters, guess);//this makes the modified word bank, using displayedLetters method
    		count += countGuesses(realWord, guess, remainingLetters);//adds to the count if the guess is correct, based on the countGuesses method
    		mysteryWord = giveResponse(realWord, mysteryWord, guess, remainingLetters);// this is the big part of the method. This giveResponse method modifies the mysteryword based on the guess
    		if(!mysteryWord.equals(realWord)){// this if statement is to make the program accurate to the sample
    			System.out.print("Number of wrong guesses so far: " + count+"\n");}
    		if(wordChecker(mysteryWord, realWord, count)){// checks if the mystery word matches the real word, if so it breaks the loop
    			break;
    		}
    	}
    	if(!mysteryWord.equals(realWord)){//This is the case if you run out of guesses, thus losing the game
    	System.out.println("You lose. The secret phrase was "+realWord);
    }}
    
    public static int countGuesses(String word, String guess, String remainingLetters){//this method keeps track of the count, adding to it or leaving it as is
    	if(word.contains(guess.toUpperCase())){// does not count if there is a letter in the word
    		System.out.println("");
    		return 0;
    	}

    	return 1;//counts if the word does not contain the guess
    }
    public static boolean checker (String realWord, String guess){//checks if the word contains the guess, returns
    	if(realWord.contains(guess)){//true or false
    		System.out.println("That is present in the secret phrase.");
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public static String giveResponse(String realWord, String mysteryWord, String guess,String remainingLetters){
    	if(checker(realWord,guess)){//this method decides whether or not the word contains guess based on checker, and then modifies the mystery word
    		for(int i = 0; i <realWord.length(); i++){//traverse the string
    			String letter = "" +realWord.charAt(i);//variable to check guess
    			if(letter.equals(guess)){
    				if(i==0){//this is the case if the letter is at the beginning
    					mysteryWord = guess + mysteryWord.substring(1);
    				}
    				else if(i == mysteryWord.length()-1){//this is the case if the letter is at the end
    					mysteryWord = mysteryWord.substring(0,i) + guess;
    				}
    				else{//this is the case if the letter is in the middle
    					mysteryWord = mysteryWord.substring(0,i) +guess+ mysteryWord.substring(i+1);
    				}
    			}
    		}
    		return mysteryWord;
    	}		
    	else{//if checker is false, or if guess is incorrect, returns word
    		System.out.println("That is not present in the secret phrase.");	
    		return mysteryWord;
    	}	
   }
    
    public static String takeAGuess(Scanner keyboard){//prompts and records a guess
    	System.out.print("\nEnter your next guess: ");//prompt
    	String guess = keyboard.next();
    	guess = guess.toUpperCase();//store guess
    	System.out.println("\nYou guessed " + guess + ".");
    	return guess;	//return guess
    }
    public static boolean wordChecker(String mysteryWord, String realWord, int count){
    	if(mysteryWord.equals(realWord)){//this checks if the mystery word and real word match
    		System.out.print("Number of wrong guesses so far: " + count+"\n");//returns the amount of guesses
    		System.out.println("\nThe phrase is "+realWord+".\nYou win!!");
    		return true;//displays win
    	}
    	return false;
    }
    public static void gameRunner(Scanner keyboard, PhraseBank phrases){
    	System.out.println("Do you want to play again?\nEnter 'Y' or 'y' to play again: ");
    	String response = keyboard.next();//This method repeats the game, whether or not you want to play again
    	if(response.toUpperCase().equals("Y")){
    		String realWord = createRealWord(phrases);
    		playGame(keyboard,realWord,createMysteryWord(realWord));//initiates a new game
    	}

    }

    
    
}