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
import java.util.Random;

public class Hippo extends Critter{
	private int hunger;//keeps track of hunger
	private int moveCount = 0;//keeps track of number of moves
	private int direction;//random direction
	public Hippo(int hunger){//sets hunger value
		this.hunger = hunger;
	}
	public Attack fight (String opponent){
		if(hunger!=0){//scratch if hungry, otherwise pounce
			return Attack.SCRATCH;
		}
		else{
			return Attack.POUNCE;
		}
	}
	public Color getColor(){
		if(hunger!=0){//sets color to Gray if its still hungry, otherwise set color to White if it isnt
			return Color.GRAY;
		}
		else{
			return Color.WHITE;
		}
	}	
	public Direction getMove(){
		if(moveCount % 5 == 0){//if the movecount = a multiple of 5, it chooses a new random direction
			Random random = new Random();
		    direction = random.nextInt(4);
		}
		if(direction == 0){//case for north
			moveCount++;
			return Direction.NORTH;
		}
		else if(direction == 1){//case for east
			moveCount++;
			return Direction.EAST;
		}
		else if(direction == 2){//case for south
			moveCount++;
			return Direction.SOUTH;
		}
		else{
			moveCount++;//case for west
			return Direction.WEST;
		}
	}
	public boolean eat(){
		if(hunger > 0){//if it is hungry, it eats and reduces hunger by 1, else false
			hunger--;
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){//outputs hunger as a number
		return "" + hunger;
	}
}
