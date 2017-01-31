/*
 *  CS312 Assignment 2.
 *  On my honor, Brandon, this programming assignment is my own work.
 *
 *  A program to print out the UT Tower in ASCII art form.
 *
 *  Name: Brandon Chan
 *  email address: brandonchan@utexas.edu
 *  UTEID:bec944
 *  Section 5 digit ID:50939
 *  Number of slip days used on this assignment:
 */

public class Tower {
	
	// CS312 students, DO NOT ALTER THE FOLLOWING LINE except for the literal int.
    // You may change the literal int assigned to SIZE to any value from 2 to 100.
    // In the final version of the program you submit set the SIZE to 3.
	public static final int SIZE = 3;
    public static void main(String[] args) {

    top();
    middle();
    upperbottom();
    lowerbottom();//PLEASE READ!!!!!!!!!!!!!!! for some reason, when 
    //i compare this to the original with that website it doesnt fully match up, but i compare them manually and
    //i get the same as the original. I don't know if my code is wrong or what. please let me know
 
    
    	}
	public static void top(){//This is the top method. It creates the ### and |||||| parts
		int middle = (SIZE*2)-1;//These variables define how the top is shaped, and the spaces it needs
		int rows = middle-1;
		int spaces = middle*2 +4;
		String radius = "";
		String base = "";
		for(int i =0; i<spaces; i++){//this creates the spaces part, radius, as a composition of spaces
			radius += " ";
		}
		base = radius;
		for(int i = 0; i<middle; i++){// this designs the ### part
	
			base+= "#";
		}
		System.out.print(base+"\n");
		
		
		for(int i = 0; i < rows; i++){// this creates the middle of the top ||||
			System.out.print(radius);
			for(int j = 0; j < middle; j++){
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.print(base+"\n");
		

	}
	public static void middle(){//this creates the middles including the windows and ~~~~
	int rows = (SIZE*SIZE)+1;//these variables help me define the size of the middle and the spaces
	int spaces = SIZE *4;
	String radius = "";
	int characters = SIZE*2 + 3;
	
	for(int i=0; i<spaces; i++){//Another part to create spaces
		radius += " ";
	}
	
	for(int i =0; i <rows; i++){//This nestedfor loop creates the ~~~ rows and window rows
		System.out.print(radius);
		for(int j=0; j <characters; j++){
			System.out.print("~");
		}
		System.out.println();
		System.out.print(radius);
		System.out.print("|");
		
		for(int j = 0; j<characters/2-1; j++){
			System.out.print("-O");
		}
		System.out.print("-|\n");
		}
	System.out.print(radius);//this ends the the middle, because there is no way to include it in the forloop, the last ~~~~part
	for(int j=0; j <characters; j++){
		System.out.print("~");

	
	}
	System.out.println();
	
	}
	
	public static void upperbottom(){//this creates the staggered bottom part
		int space = (SIZE/2)*3;//These variables set up spaces, the amount of rows, and the sizes of each row
		int rows = SIZE/2+1;
		int rowsize=(5*SIZE)-((SIZE/2)*3);
		for (int i = rows; i>0; i--){//this counts down the rows, a for loop of the row inside a forloop that makes each row
			for(int j = 0; j<space; j++){
				System.out.print(" ");
			}
			System.out.print("/");
			for(int j = 1; j< rowsize; j++){
				
				System.out.print("\"\'");
			}
			rowsize+=3;//I increase the rowsize here, giving it the staggered effect on the right side.
			space -=3;//this also creates the staggered effect on the left side
		System.out.print("\"\\");// ending the staggered part
		System.out.println();

		}
	}
	
	public static void lowerbottom(){//this is the lowerhalf of the bottom.
		for(int i =0; i <SIZE; i++){//two for loops that create rows of repeated "O"
			System.out.print("/");
			for(int j = 0; j<SIZE*5-1; j++){
				System.out.print("\"O");
				
			}
			System.out.print("\"\\\n");
			
		}
		
	}
}

