package view;

import java.awt.Graphics2D;

public class LineDrawer extends GraphicObject {

	double xCoord;  // x coordinate of first point
	double yCoord;	// y coordinate of first point
	double xCoord2; // x coordinate of second point
	double yCoord2;	// y coordinate of second point
	
	/* Constructor
	 * @param x  x coordinate of first point
	 * @param y  y coordinate of first point
	 * @param x2 x coordinate of second point
	 * @param y2 y coordinate of second point
	 */
	public LineDrawer(double x, double y, double x2, double y2) {
		xCoord  = x;
		yCoord  = y;
		xCoord2 = x2;
		yCoord2 = y2;
		isRed   = false;
	}

	/* Draws line
	 * @param g2d Graphics2D object
	 */
	public void paintObject(Graphics2D g2d) {
		g2d.drawLine((int)(312 + xCoord * 13), (int)(312 - yCoord * 13),
					 (int)(312 + xCoord2 * 13), (int)(312 - yCoord2 * 13));
	}
	
// GETTERS
	
	/* Returns x coordinate of first point
	 * @return x coordinate of first point
	 */
	public double getX1Coord(){
		return xCoord;
	}
	
	/* Returns y coordinate of first point
	 * @return y coordinate of first point
	 */
	public double getY1Coord(){
		return yCoord;
	}
	
	/* Returns x coordinate of second point
	 * @return x coordinate of second point
	 */
	public double getX2Coord(){
		return xCoord2;
	}
	
	/* Returns y coordinate of second point
	 * @return y coordinate of second point
	 */
	public double getY2Coord(){
		return yCoord2;
	}
}
