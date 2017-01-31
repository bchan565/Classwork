import java.util.Scanner;

/**
 * CS312 Assignment 5.
 *
 * On my honor, Brandon Chan, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to encrypt and decrypt messages using a columnar transposition cipher.
 *
 *  email address: brandonchan@utexas.edu
 *  UTEID: bec944
 *  Number of slip days used on this assignment:
 */

public class Cipher {

    // CS312 Students: This constant must be set to MAX_ROWS in the
    // final version of your program that you turn in.
    public static final int MAX_ROWS = 10;

    // main method to demonstrate various encryptions and
    // decryptions using a columnar transposition cipher
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);//creates a scanner object
        showIntro();//calls the intro method, displaying the introduction
        String message = encryptmessage(keyboard);//creates a string object and sets it equal to the message you want to encrypt
        encryptnopad(message);//encrypts the message without padding
        encryptpad(message);//encrypts the message with padding
        message = decryptmessage(keyboard);//sets the message to what you want to decrypt
        decryptor(message);//decrypts the message
		// CS312 students, add your code here.
        keyboard.close();
        
    }

    public static void showIntro() {// show the introduction to the program
        System.out.println("This program demonstrates a transposition cipher.");
        System.out.println("A cipher is an algorithm to encrypt or decrypt a message.");
        System.out.println();
        System.out.println("This program will demonstrate encrypting a message with");
        System.out.println("a columnar transposition cipher both with and without");
        System.out.println("padding characters. The program will then decrypt a message");
        System.out.println("assuming it was encrypted with a columnar transposition cipher");
        System.out.println("with padding.");
        System.out.println("After accepting user input, the program displays some tests.");
    }
    
    public static String encryptmessage(Scanner keyboard){//This method prompts and asks for the message you want to encrypt
    	System.out.print("\n\nA demonstration of encrypting with a columnar transposition cipher:\n\nEnter the message to encrypt: ");
    	return keyboard.nextLine();
    	
    }
    public static void encryptnopad(String message){//This method will produce all encryptions, with rows 2 to 10,
    	System.out.println("\nMessage encrypted with columnar transposition cipher and no padding.");
    	for(int row = 2; row <= MAX_ROWS; row++){
    		
    		System.out.println("Encrypted with "+row+ " rows: "+encryptor(message, row));//calls the encryptor method that encrypts a message based on number of rows
    		}//loops 2 to 10 times
    }
    public static void encryptpad(String message){//this method first creates the message with X Paddings, and then outputs the encrypted message with padding
    	int columns;//initiate a variable that will store # of columns
    	System.out.println("\nMessage encrypted with columnar transposition cipher and padding.\n");
    	for(int row = 2; row <= MAX_ROWS; row++){
    		if(message.length() % row != 0){//These if and else statements determine the number of columns for the message based on the # of rows
    			columns = message.length()/row+1;
    		}
    		else{
    			columns = message.length()/row;
		}
    		int numXs = columns*row-message.length();//in order to find the amount of Xs to add to the message, you have to multiply the number of columns by rows and subtract by the string length
    		String newMessage = message;// this sets a variable newMessage, while keeping the original message
    		if(numXs != 0){//this block of code adds the number of Xs to the end of the message
    			for(int i = 1; i <= numXs; i++){
    				newMessage += "X";
    			}
		}
    		System.out.println("Clear text padded for "+ row + " rows: "+newMessage);//shows the message with padding
    		System.out.println("Encrypted with "+row+" rows: "+encryptor(newMessage, row)+"\n");//shows encrypted message with padding
    	}
    }
    
    public static String encryptor(String message, int row){//a method to encrypt a message based on the amount of rows
    	String encrypt = "";
    	int startIndex = 0;//a start index is used to keep track on where to the start of a row is.
    	for(int i = startIndex; i<row; i++){//this initializes a loop that starts from the beginning of a row
			int index = startIndex;//sets the starting index to a general index, where index is used to run through the string in increments of row
		while(index < message.length()){//the while loop is used because there isnt a specific amount of times that the string needs to be run through, like in each row. In other words, prevents an out of bounds error
			encrypt += message.charAt(index);//concatenates the part of the string to the encryption
			index += row;//add row to index to skip the other parts of the string
		}
		startIndex++;//moves the starting index by 1
		}
    	
    	
    	return encrypt;//returns the encrypted message
    }
    
    public static String decryptmessage(Scanner keyboard){//this method introduces, prompts, and asks for a message to decrypt
    	System.out.print("\nA demonstration of decrypting with a columnar transposition cipher:\nIf the length of the message is not a multiple of the number of rows\nit will be padded which may throw off the decryption.\n\nEnter the message to decrypt: ");
    	return keyboard.nextLine();//returns the intended message to decrypt
    }
    public static void decryptor(String message){//this method pads the message intended for decryption, and then runs through a loop for decryption
    	int columns;//columns is needed to determine whether or not padding is needed
    	System.out.println("\nMessages Decrypted with a Columnar Transposition Cipher\n");
    	for(int row = 2; row <= MAX_ROWS; row++){//a loop for computing and outputting all decryptions

    		if(message.length() % row != 0){//the if and else statements determine the number of columns needed
    			columns = message.length()/row+1;
    		}
    		else{
    			columns = message.length()/row;
		}
    		int numXs = columns*row-message.length();// numXs determines the number of Xs needed to pad for a message
    		String newMessage = message;//preserves original message while making a soon to be decrypted message
    		if(numXs != 0){
    			for(int i = 1; i <= numXs; i++){//the if and for statements are used to put the number of Xs into the message
    				newMessage += "X";
    			}
		}   		
    	System.out.println("Decrypted text padded for "+row+" rows: "+newMessage);//outputs the encrypted message with or without padding
    	System.out.print("Decrypted with "+row+" rows: " +decryptRow(newMessage, row, columns));//outputs the decrypted message with or without padding
    	//its worth noting that the actually "decryption" process is in the method decryptRow()
    	if(row !=MAX_ROWS ){
    		System.out.println("\n");//this if statement is used to make the output accurate and the same as the sample output
    	}
    }
}
	public static String decryptRow(String message, int row,int columns){//the decryptRow method decrypts the encrypted message, taking a string, a row, and column. This method is similar to encryptor()
		String newMessage = "";//this method must have a row and column variable, in order to decrypt based on columns which is related to rows
		int startIndex = 0;//sets the starting index to 0
    	for(int i = startIndex; i<columns; i++){//same process at the encryptor method
			int index = startIndex;
		while(index < message.length()){
			newMessage += message.charAt(index);// encryption uses rows, decryption uses columns
			index += columns;//instead of going by rows, to decrypt, you have to go by columns
		}
		startIndex++;
		}
		return newMessage;//returns decryption
	}
}