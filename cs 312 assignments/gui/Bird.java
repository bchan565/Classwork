/**
 * CS312 Assignment 11.
 *
 * On MY honor, Brandon Chan, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Brandon Chan
 * UTEID:bec944
 * email address:brandonchan@utexas.edu
 * Number of slip days used on this assignment:
 * 
 */
import java.awt.*;
public class Bird extends Critter{
	private int moveCount;//a move count to determine when to switch directions
	private String appearance;//saves appearance
	public Bird(){
		moveCount = 0;//sets initial count to 0, moving north
		appearance = "^";//sets int=itial appearance to move north
	}
	
	public Attack fight (String opponent){
	if(opponent.equals( "%")){//roar if ant, otherwise pounce
		return Attack.ROAR;
	}
	else{
		return Attack.POUNCE;
	}
	}
	public Color getColor(){//sets color to blue
		return Color.BLUE;
	}
	
	public Direction getMove(){//Modulus to decide what direction to move, increments of 3 moves per direction
		if((moveCount % 12) < 3){
			moveCount++;//increment
			appearance = "^";//saves appearance
			return Direction.NORTH;
		}
		else if((moveCount % 12) < 6){
			moveCount++;
			appearance = ">";
			return Direction.EAST;
		}
		else if((moveCount % 12) < 9){
			moveCount++;
			appearance = "V";
			return Direction.SOUTH;
		}
		else{
			moveCount++;
			appearance = "<";
			return Direction.WEST;
		}
	}
	public boolean eat(){
		return false;//always return false
	}
	
	public String toString(){
		return appearance;//outputs appearance
	}
	
}
