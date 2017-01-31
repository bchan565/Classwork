/**
 * CS312 Assignment 11.
 *
 * On MY honor, Brandon Chan, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Brandon Chan
 * UTEID: bec944
 * email address: brandonchan@utexas.edu
 * Number of slip days used on this assignment:
 * 
 */
import java.awt.*;
public class Ant extends Critter {

	private boolean	walkSouth;//a variable to determine the movement pattern
	private int move = 0;//a variable to determine which direction it needs to move
	public Ant(boolean walkSouth){//determines if it needs to walk South and East, else walk North and East
		this.walkSouth = walkSouth;
	}
	
	public Attack fight (String opponent){
		return Attack.SCRATCH;//always return scratch
	}
	public Color getColor(){//sets color to red
		return Color.RED;
	}
	
	public Direction getMove(){//move method
		if(walkSouth){//if south and east
			if(move % 2 == 0){//alternates between south and east
				move++;//increments to alternate
				return Direction.SOUTH;
			}
			else{
				move++;//increment
				return Direction.EAST;
			}
		}
		else{//same idea before, but this is the other case if it moves north and east
			if(move % 2 == 0){
				move++;
				return Direction.NORTH;
			}
			else{
				move++;
				return Direction.EAST;
			}
		}
	}
	
	public boolean eat(){//always eat
		return true;
	}
	
	public String toString() {//symbol is a percent sign
		return "%";
	}
}
