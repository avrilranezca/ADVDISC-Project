package view;

import java.awt.Graphics2D;

public class LineDrawer extends GraphicObject {

	double xCoord;
	double yCoord;
	double xCoord2;
	double yCoord2;
	
	public LineDrawer(double x, double y, double x2, double y2, boolean r) {
		xCoord  = x;
		yCoord  = y;
		xCoord2 = x2;
		yCoord2 = y2;
		isRed   = r;
	}

	public void paintObject(Graphics2D g2d) {
		g2d.drawLine((int)(312 + xCoord * 13), (int)(312 - yCoord * 13),
					 (int)(312 + xCoord2 * 13), (int)(312 - yCoord2 * 13));
	}
	
// GETTERS
	
	public double getX1Coord(){
		return xCoord;
	}
	
	public double getY1Coord(){
		return yCoord;
	}
	
	public double getX2Coord(){
		return xCoord2;
	}
	
	public double getY2Coord(){
		return yCoord2;
	}
}
