package view;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class EllipseDrawer extends GraphicObject {

	int xCoord;
	int yCoord;
	int width;
	int height;
	
	public EllipseDrawer(double x, double y, double w, double h, boolean r) {
		xCoord = (int)x;
		yCoord = (int)y;
		width  = (int)w;
		height = (int)h;
		isRed  = r;
	}
	
	public void paintObject(Graphics2D g2d) {
		Shape theCircle = new Ellipse2D.Double(312 + ((xCoord - width/2) * 13), 312 + ((yCoord + height/2) * -13), width * 13, height * 13);
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
