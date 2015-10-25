package view;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class PointDrawer extends GraphicObject {

	double  xCoord; // x coordinate of point
	double  yCoord; // y coordinate of point
	
	/* Constructor
	 * @param x x coordinate of point
	 * @param y y coordinate of point
	 */
	public PointDrawer(double x, double y){
		xCoord = x;
		yCoord = y;
		isRed  = false;
	}
	
	/* Draws point
	 * @param g2d Graphics2D object
	 */
	public void paintObject(Graphics2D g2d) {
		Shape theCircle = new Ellipse2D.Double(310 + (xCoord * 13),
											   310 + (yCoord * -13),
											   4, 4);
		g2d.fill(theCircle);
		g2d.draw(theCircle);
	}
	
// GETTERS

	/* Returns x coordinate of point
	 * @return x coordinate of point
	 */
	public double getXCoord(){
		return xCoord;
	}
	
	/* Returns y coordinate of point
	 * @return y coordinate of point
	 */
	public double getYCoord(){
		return yCoord;
	}

}
