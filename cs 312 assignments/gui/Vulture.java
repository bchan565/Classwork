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
import java.awt.Color;
public class Vulture extends Bird{//a vulture is inherits bird
	private boolean isHungry;//keeps track of hunger
	public Vulture(){
		isHungry = true;//sets initial hunger to true
	}
	public Attack fight (String opponent){//the same thing as Bird, but it keeps track of isHungry. If it fights, it becomes hungry
	isHungry = true;
	if(opponent.equals( "%")){
		return Attack.ROAR;
	}
	else{
		return Attack.POUNCE;
	}
	}
	public Color getColor(){//sets color to black
		return Color.BLACK;
	}
	public boolean eat(){//if hungry, true and become not hungry. else false
		if(isHungry){
			isHungry = false;
			return true;
		}
		else{
			return false;
		}
	}//i only need to overide eat(), fight(), and getcolor(), because they are unique to Vulture
}
