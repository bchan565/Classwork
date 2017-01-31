import java.awt.Color;
import java.awt.Graphics;



/**
 * @author  Brandon Chan
 * @version <Date>
 * CS312 Assignment 3.
 * 
 * On my honor, Brandon Chan, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to print out various scintillation grids and a student designed drawing. 
 *
 *  email address: brandonchan@utexas.edu
 *  UTEID: bec944
 *  Number of slip days used on this assignment:
 */

public class ScintillationGrid {

	// Main method that creates the DrawingPanel with scintillation grids.
	// Restricted to chapters 1 - 3 of Building Java Programs
    public static void main(String[] args) {
    	/* In the final version of the program DO NOT call method drawingOne 
    	   from main or anywhere else in the program */
    	DrawingPanel panel = new DrawingPanel(900, 650);
    	Graphics g = panel.getGraphics();
    	panel.setBackground(Color.CYAN);
    	drawgrid(g, 0, 0, 348, 3, 16);
    	drawgrid(g, 400, 50, 422,6,12);
    	drawgrid(g, 50, 400, 220, 1, 20);
    	drawgrid(g, 500, 500, 148, 7, 4);
  
    	
    	
    }
    
    
    // method for the student designed drawing
    // NOT restricted to chapters 1 - 3 of Building Java Programs
    public static void drawingOne() {

    	DrawingPanel panel = new DrawingPanel(400, 200);
    	Graphics b = panel.getGraphics();
    	panel.setBackground(Color.GREEN);
    	b.drawLine(200,0,200,200);
    	b.drawLine(0, 100, 400, 100);
    	b.setColor(Color.RED);
    	b.fillOval(0, 0, 200, 100);
    	b.fillOval(200,100,200,100);
    	b.setColor(Color.BLACK);
    	b.drawLine(100, 0, 100, 100);
    	b.drawLine(0, 50, 200, 50);
    	b.drawLine(300, 100, 300, 200);
    	b.drawLine(200, 150, 400, 150);
    	
	
	}
    
    public static void drawgrid(Graphics g, int x, int y, int gridsize, int numlines, int thick){
    	g.setColor(Color.BLACK);
    	g.fillRect(x, y, gridsize, gridsize);
    	int numsquares = numlines+1;
    	int squaresize = (gridsize-(numlines*thick))/numsquares;
    	g.setColor(Color.GRAY);
    	
    	for(int i = 1; i<=numlines; i++){
   
    		g.fillRect(x+(squaresize*i)+thick*(i-1),y,thick,gridsize);
    		
    	}
    	for(int i =1; i<=numlines; i++){
    		
    		g.fillRect(x, y+(squaresize*i)+thick*(i-1), gridsize, thick);
    	}
    	g.setColor(Color.WHITE);
    	double circlewidth;
    	circlewidth = Math.max(2, thick*1.4);
    	
    	for(int i = 1; i<=numlines; i++){
    		
    		for(int j =1; j<=numlines; j++){
    			g.fillOval(x+(squaresize*j)+ (j-1)*thick-thick/4, y+(squaresize*i)+(i-1)*thick-thick/4, (int) circlewidth, (int) circlewidth);
    		}
    	}
    	
    		
    	
    	
    	
 
    	
    	
    }
}
