import java.util.Scanner;

/**
 * CS312 Assignment 4.
 *
 * On my honor, <NAME>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play Rock Paper Scissors
 *
 *  email address:
 *  UTEID:
 *  Number of slip days used on this assignment:
 */

public class RockPaperScissors {
	public static final int ROCK = 1;//these are final variables, class constants
	public static final int PAPER = 2;
	public static final int SCISSORS = 3;

    /* A program to allow a human player to play rock - paper - scissors
     * against the computer. If args.length != 0 then we assume
     * the first element of args can be converted to an int
     */
    public static void main(String[] args) {
		// CS312 Students. Do not change the following line.
        RandomPlayer computerPlayer = buildRandomPlayer(args);

        // CS312 students do no change the following line. Do not create any other Scanners.
        Scanner keyboard = new Scanner(System.in);
        String name = intro(keyboard);//this calls the "intro method," 
        							  //which starts the introduction and returns a String name
        							  //the String is set to a variable name	
        int numRounds = rounds(keyboard, name);//This calls the "rounds" method
        										//the rounds method takes in a scanner object and a string
        										//object, or a name. It asks for the number of rounds and
        										//returns that integer
        playGame(keyboard,numRounds,name, computerPlayer);//This method runs the game. It takes in a 
        												  //scanner, #rounds, a name, and a RandomPlayer object

        keyboard.close();
    }


    /*
     * Build the random player. If args is length 0 then the
     * default RandomPlayer is built that follows a predictable
     * sequence. If args.length > 0 then we assume we can
     * convert the first element to an int and build the
     * RandomPlayer with that initial value.
     */
    public static RandomPlayer buildRandomPlayer(String[] args) {//RandomPlayer object
        if(args.length == 0) {
            return new RandomPlayer();
        } else {
            int seed = Integer.parseInt(args[0]);
            return new RandomPlayer(seed);
        }
    }
    
   public static String intro(Scanner keyboard){//This is the introduction of the program
	   
	   System.out.print("Welcome to ROCK PAPER SCISSORS. I, Computer, will be your opponent.\nPlease type in your name and press return: ");
	   String name = keyboard.next();//It asks for a name, and sets it as a variable
	   System.out.println("\nWelcome "+name+".\n");
	   return name;//returns the name in the form of a string
	   
   }
   public static int rounds(Scanner keyboard, String name){//This is the part that asks for the number of rounds.
	   System.out.print("All right "+name+". How many rounds would you like to play?\nEnter the number of rounds you want to play and press return: ");
	   int numRounds = keyboard.nextInt(); //It asks for the number of rounds, and then stores the user input into the variable numRounds
	   return numRounds; //This returns the number of rounds
	   
   }
   
   public static void playGame(Scanner keyboard, int numRounds, String name, RandomPlayer computerPlayer){
	   int userScore = 0;//This big method takes in a scanner, a number of rounds, a randomplayer, and a string name. 
	   int computerScore = 0;//This method is the basis of the game, it plays the number of rounds, chooses winners from that round,
	   int drawScore = 0;//and declares the winner of the game through a scoreboard
	   //local variables includes userScore, computerScore, and drawScroe. These variables are count variables
	   
	   for(int round = 1; round <= numRounds; round++){//This loop is the loop for the process of a game. It loops a total of numRounds
		   System.out.print("\nRound "+round+".\n"+name+", please enter your choice for this round.\n1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
		   int choice = keyboard.nextInt();//based on prompting the user, the user choice is stored as an int in the form of either 1,2,or 3.
		   int computerChoice = computerPlayer.getComputerChoice();//The computer's choice is received by calling the getComputerChoice() from the computer player object
		   if(computerChoice==ROCK){//These if, else if, else statements state what choice the computer made based on computerChoice variable
			   System.out.print("Computer picked ROCK");
		   }
		   else if(computerChoice==PAPER){
			   System.out.print("Computer picked PAPER");
		   }
		   else{
			   System.out.print("Computer picked SCISSORS");
		   }
		   
		   if(choice==ROCK){//These if, else if, else statements state what choice the user made based on userChoice variable
			   System.out.println(", "+name+" picked ROCK.");
		   }
		   else if(choice==PAPER){
			   System.out.println(", "+name+" picked PAPER.");
		   }
		   else{
			   System.out.println(", "+name+" picked SCISSORS.");
		   }
		   
		   //There are a total of 9 possible outcomes in Rock paper scissors
		   if(choice==computerChoice){//to reduce redundancy, i include all tie games into one if statement. This if statement reduces 9 conditional statements to 7.
			   System.out.println("\nWe picked the same thing! This round is a draw.");
			   drawScore++;
			   
			     }
		   else if(choice==ROCK && computerChoice==SCISSORS){//Computer picks scissors, player picks rock
			   System.out.println("\nROCK breaks SCISSORS. You win.");
			   userScore++;
		   }
		   else if(choice==PAPER && computerChoice==SCISSORS){//Computer picks scissors, player picks paper
			   System.out.println("\nSCISSORS cut PAPER. I win.");
			   computerScore++;
		   }
		   else if(choice==ROCK && computerChoice==PAPER){//Computer picks paper, player picks rock
			   System.out.println("\nPAPER covers ROCK. I win.");
			   computerScore++;
		   }
		   else if(choice==PAPER && computerChoice==ROCK){//Computer picks rock, player picks paper
			   System.out.println("\nPAPER covers ROCK. You win.");
			   userScore++;
		   }
		   else if(choice==SCISSORS && computerChoice==ROCK){//Computer picks rock, player picks scissors
			   System.out.println("\nROCK breaks SCISSORS. I win.");
			   computerScore++;
		   }
		   else{//all other outcomes have been stated, so the last outcome must be a player picking scissors, and a computer picking paper
			   System.out.println("\nSCISSORS cut PAPER. You win.");
			   userScore++;
		   }
	      
   }
	   
	   score(numRounds,userScore, computerScore, drawScore, name);//This calls the score method. It is a method within a method. It produces the scoreboard
}
   
   public static void score(int numRounds,int userScore, int computerScore, int drawScore, String name){
	   //This method creates the ending scoreboard, and declares a winner. It takes in the number of rounds, a string name, computer score, user score, and the number of draws
	   System.out.println("\n\nNumber of games of ROCK PAPER SCISSORS: "+numRounds);//outputs rounds
	   System.out.println("Number of times Computer won: "+computerScore);//outputs computer score
	   System.out.println("Number of times "+ name+" won: "+userScore);//outputs user score
	   System.out.println("Number of draws: "+drawScore);//outputs draws
	   if(userScore>computerScore){//these three condition statements decide whether the user wins, computer wins, or a draw game
		   System.out.print("You, "+name+", are a master at ROCK, PAPER, SCISSORS.");
	   }
	   else if(computerScore>userScore){
		   System.out.print("I, Computer, am a master at ROCK, PAPER, SCISSORS.");
	   }
	   else{
		   System.out.print("We are evenly matched.");
	   }
	   
	   
	   
	   
   }
}