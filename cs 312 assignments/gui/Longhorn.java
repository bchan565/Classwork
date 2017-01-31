import java.awt.Color;
import java.util.Random;
import java.awt.*;
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
public class Longhorn extends Critter{
	
	private int direction;//determines direction
	private boolean hasMated;//determines if it hasmated, thus if it needs to move
	private Color color;//determines color
	private Random random = new Random();//i need a random object to do cool stuff
	private String appearance;//used for toString

	public Longhorn(){
		color = Color.ORANGE;//default is orange
		appearance = "U";//default appearance is U
		hasMated = false;//default is false
	}
	
	public Attack fight(String opponent){//attack method, each time it attacks it changes into a random color
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		color = new Color(r,g,b);//a new color based on rgb colors
		if(opponent.equals("%")){//always beat an ant
			return Attack.ROAR;
		}
		else if(opponent.equals("^")||opponent.equals("<")||opponent.equals(">")||opponent.equals("V")){//always beat birds
			return Attack.SCRATCH;
		}
		return Attack.POUNCE;//if not a bird or a ant, pounce
	}
	public Color getColor(){//returns color
		return color;
	}
	public Direction getMove(){//longhorn moves in a random direction always, unless it has mated, in which case stands still
		if(!hasMated){
	    direction = random.nextInt(4);//randomize direction
		}
		if(direction == 0){//case for north
			return Direction.NORTH;
		}
		else if(direction == 1){//case for east
			return Direction.EAST;
		}
		else if(direction == 2){//case for south
			return Direction.SOUTH;
		}
		else if(direction == 3){//case for west
			return Direction.WEST;
		}
		else{
			return Direction.CENTER;
		}
	}
	
	public String toString(){
		return appearance;//toString
	}
	public boolean eat(){//always eat
		return true;
	}
	public void mateEnd() {//if it has mated, it stops moving, settling down
		hasMated = true;
		direction = -1;
	}
	public void win() {//if it has won a fight it becomes a UT
		if(appearance.equals("U")){
			appearance += "T";
		}
	}

}

