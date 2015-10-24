package view;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class PointDrawer extends GraphicObject {

	double  xCoord;
	double  yCoord;
	
	public PointDrawer(double x, double y, boolean r){
		xCoord = x;
		yCoord = y;
		isRed  = r;
	}
	
	public void paintObject(Graphics2D g2d) {
		Shape theCircle = new Ellipse2D.Double(310 + (xCoord * 13), 310 + (yCoord * -13), 4, 4);
		g2d.fill(theCircle);
		g2d.draw(theCircle);
	}
	
// GETTERS

	public double getXCoord(){
		return xCoord;
	}
	
	public double getYCoord(){
		return yCoord;
	}

}
