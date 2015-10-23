package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GraphicObject extends Canvas {
	
	boolean isRed;

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		if(isRed) {
			g2d.setColor(Color.red);
		}
		else {
			g2d.setColor(Color.blue);
		}
		
		paintObject(g2d);
	}
	
	public abstract void paintObject(Graphics2D g2d);
	
// SETTERS
	
	public void setIsRed(boolean r){
		isRed = r;
	}
	
}
