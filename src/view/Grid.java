package view;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Grid extends Canvas {
    int width;
    int height;
    int rows;
    int columns;
    MainView view;

    public Grid(int w, int h, int r, int c, MainView v) {
	    setSize(width = w, height = h);
	    rows = r;
	    columns = c;
	    view = v;
    }
    
    public void paint(Graphics g) {
    	System.out.println("Grid.paint(g)");
	    int k;
	    width = getSize().width;
	    height = getSize().height;
	    
	    g.setColor(Color.LIGHT_GRAY);
	
	    int htOfRow = height / (rows);
	    for (k = 0; k < rows; k++){
	    	if(k == rows / 2){
	    		Graphics2D g2 = (Graphics2D) g;
	    		g2.setStroke(new BasicStroke(3));
	    		g2.drawLine(0, k * htOfRow , width, k * htOfRow );
	    		g2.setStroke(new BasicStroke(1));
	    	}
	    	else{
	    		g.drawLine(0, k * htOfRow , width, k * htOfRow );
	    	}
	    }
	
	    int wdOfRow = width / (columns);
	    for (k = 0; k < columns; k++){
	    	if(k == columns / 2){
	    		Graphics2D g2 = (Graphics2D) g;
	    		g2.setStroke(new BasicStroke(3));
	    		g2.drawLine(k*wdOfRow , 0, k*wdOfRow , height);
	    		g2.setStroke(new BasicStroke(1));
	    	}
	    	else{
	    		g.drawLine(k*wdOfRow , 0, k*wdOfRow , height);
	    	}
	    }
	    
	    for(int i = 0; i < view.getObjectCount(); i++){
	    	if(view.getSelectedObject() == i){
	    		view.getObject(i).setIsRed(true);
	    	}
	    	else{
	    		view.getObject(i).setIsRed(false);
	    	}
	    	view.getObject(i).paint(g);
	    }
    }
}
