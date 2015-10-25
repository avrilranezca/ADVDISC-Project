package view;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Grid extends Canvas {
    int      width;  // width in pixels
    int      height; // height in pixels
    int      rows;
    int      columns;
    MainView view;

    /* Constructor
     * @param w width in pixels
     * @param h height in pixels
     * @param r number of rows
     * @param c number of columns
     * @param v main view object
     */
    public Grid(int w, int h, int r, int c, MainView v) {
	    setSize(width = w, height = h);
	    rows    = r;
	    columns = c;
	    view    = v;
    }
    
    /* Draws grid
     * @param g Graphics object
     */
    public void paint(Graphics g) {
    	System.out.println("Grid.paint(g)");

	    width       = getSize().width;
	    height      = getSize().height;
	    
	    
	    g.setColor(Color.LIGHT_GRAY);
	    
	    // Draws rows
	    int htOfRow = height / (rows);
	    for (int k = 0; k < rows; k++){
	    	if(k == rows / 2){ // If x-axis row
	    		Graphics2D g2 = (Graphics2D) g;
	    		g2.setStroke(new BasicStroke(3));
	    		g2.drawLine(0, k * htOfRow , width, k * htOfRow );
	    		g2.setStroke(new BasicStroke(1));
	    	}
	    	else{
	    		g.drawLine(0, k * htOfRow , width, k * htOfRow );
	    	}
	    }
	
	    // Draws columns
	    int wdOfRow = width / (columns);
	    for (int k = 0; k < columns; k++){
	    	if(k == columns / 2){ // If y-axis column
	    		Graphics2D g2 = (Graphics2D) g;
	    		g2.setStroke(new BasicStroke(3));
	    		g2.drawLine(k*wdOfRow , 0, k*wdOfRow , height);
	    		g2.setStroke(new BasicStroke(1));
	    	}
	    	else{
	    		g.drawLine(k*wdOfRow , 0, k*wdOfRow , height);
	    	}
	    }
	    
	    // Draws objects on grid
	    for(int i = 0; i < view.getObjectCount(); i++){
	    	// Sets color
	    	if(view.getSelectedObject() == i){ // If selected object
	    		view.getObject(i).setIsRed(true);
	    	}
	    	else{
	    		view.getObject(i).setIsRed(false);
	    	}

	    	// Draws object
	    	view.getObject(i).paint(g);
	    }
    }
}
