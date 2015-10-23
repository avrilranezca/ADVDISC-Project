package view;

import java.awt.Graphics2D;

public class LineDrawer extends GraphicObject {

	int xCoord;
	int yCoord;
	int xCoord2;
	int yCoord2;
	
	public LineDrawer(double x, double y, double x2, double y2, boolean r) {
		xCoord  = (int) x;
		yCoord  = (int) y;
		xCoord2 = (int) x2;
		yCoord2 = (int) y2;
		isRed   = r;
	}

	public void paintObject(Graphics2D g2d) {
		g2d.drawLine(312 + xCoord * 13, 312 - yCoord * 13, 312 + xCoord2 * 13, 312 - yCoord2 * 13);
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
