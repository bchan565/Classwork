// CSE 142 Critters - Modified for CS312
// Authors: Marty Stepp and Stuart Reges
// Minor changes by Mike Scott
//
// Stone objects are displayed as S and always stay put.
// They always pick ROAR in a fight.
//
import java.awt.*;

public class Stone extends Critter {
	// method comment goes here
	public Attack fight(String opponent) {
	    // Good old rock, I mean roar. Nothing beats that.
		return Attack.ROAR;
	}

	// method comment goes here
	public Color getColor() {
		return Color.GRAY;
	}

	// method comment goes here
	public String toString() {
		return "S";
	}
}